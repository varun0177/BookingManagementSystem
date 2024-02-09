package service;

import Models.ShowSeat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.ShowSeatRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ShowSeatService {
    private ShowSeatRepository showSeatRepository;
    public List<ShowSeat> getShowSeats(List<Long> showSeatsId) {
        return showSeatRepository.findAllById(showSeatsId);
    }

    public List<ShowSeat> saveAll(List<ShowSeat> showSeats) {
        return showSeatRepository.saveAll(showSeats);
    }
}
