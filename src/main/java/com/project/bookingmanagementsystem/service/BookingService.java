package service;

import Models.Booking;
import Models.Customer;
import Models.Show;
import Models.ShowSeat;
import dtos.CreateBookingRequest;
import enums.PaymentStatus;
import enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import repository.BookingRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class BookingService {
    private BookingRepository bookingRepository;
    private CustomerService customerService;
    private ShowService showService;
    private ShowSeatService showSeatService;
    public Booking createBooking(CreateBookingRequest request) {
        Customer customer=customerService.getCustomerInternal(request.getCustomer_id());
        if(customer==null){
            throw new RuntimeException("Invalid customer");
        }
        Show show=showService.getShow(request.getShow_id());
        if(show==null){
            throw new RuntimeException("No show exists");
        }
        List<ShowSeat> showSeats=showSeatService.getShowSeats(request.getShowSeatsId());
        for(ShowSeat showSeat :showSeats){
            if(showSeat.getSeatStatus() != SeatStatus.Available){
                throw new RuntimeException("Already booked");
            }
        }
        for(ShowSeat showSeat: showSeats){
            showSeat.setSeatStatus(SeatStatus.Booked);
        }
        List<ShowSeat> savedSeats=showSeatService.saveAll(showSeats);
        Booking booking=Booking.builder()
                .seats(savedSeats)
                .show(show)
                .customer(customer)
                .paymentStatus(PaymentStatus.Booked)
                .bookedAt(new Date())
                .build();
        return bookingRepository.save(booking);
    }
}
