package service;

import Models.*;
import dtos.CreateShowRequest;
import enums.SeatStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ShowRepository;
import repository.ShowSeatRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ShowService {
    private ShowSeatRepository seatRepository;
    private HallService hallService;
    private MovieService movieService;
    private ShowRepository showRepository;
    private ShowSeatService showSeatService;
    private SeatService seatService;
    public Show createShow(CreateShowRequest request) {
        Hall hall=hallService.getHall(request.getHallId());
        if(hall ==null){
            throw new RuntimeException("no hall with the id");
        }
        Movie movie=movieService.getMovie(request.getMovieId());
        if(movie == null){
            throw new RuntimeException("no movie with that id");
        }
        List<Seat> seats=seatService.getALl(request.getHallId());
        Show show=Show.builder()
                .duration(request.getDuration())
                .hall(hall)
                .movie(movie)
                .build();
        List<ShowSeat> showSeats=seats.stream()
                .map(seat -> ShowSeat.builder()
                        .seat(seat)
                        .seatStatus(SeatStatus.Available)
                        .show(show)
                        .build())
                .toList();

        Show savedshow=Show.builder()
                .duration(request.getDuration())
                .showSeats(showSeats)
                .hall(hall)
                .movie(movie)
                .build();
        seatRepository.saveAll(showSeats);
       return showRepository.save(savedshow.toBuilder().showSeats(showSeats).build());
    }

    public Show getShow(Long id) {
        return showRepository.findById(id).orElse(null);
    }
}
