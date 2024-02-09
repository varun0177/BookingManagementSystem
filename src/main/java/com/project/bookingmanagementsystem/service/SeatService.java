package service;

import Models.Seat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.SeatRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class SeatService {
    private SeatRepository seatRepository;
    public List<Seat> saveAll(List<Seat> seats){
        return seatRepository.saveAll(seats);
    }
    public List<Seat> getALl(Long hallId) {
        return seatRepository.findAllByHall_Id(hallId);
    }
}
