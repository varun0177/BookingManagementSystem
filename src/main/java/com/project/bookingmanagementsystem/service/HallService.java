package service;

import Models.Hall;
import Models.Seat;
import dtos.CreateHallRequest;
import dtos.SeatPosition;
import enums.SeatType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.HallRepository;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HallService {
    private SeatService seatService;
    private HallRepository hallRepository;
    public Hall createHall(CreateHallRequest request){
        Hall hall=Hall.builder()
                .name(request.getName())
                .features(request.getFeatures())
                .build();
        List<Seat> seats=toSeats(hall,request.getSeatRanges());
        List<Seat> savedSeats=seatService.saveAll(seats);
        return hallRepository.save(hall.toBuilder().seats(seats).build());
    }

    public List<Seat> toSeats(Hall hall, Map<SeatType, List<SeatPosition>> seatPositions) {
        return seatPositions.entrySet().stream().flatMap(entry -> {

            SeatType seatType = entry.getKey();
            List<SeatPosition> positions = entry.getValue();

            return positions
                    .stream()
                    .map(seatPosition ->
                            Seat.builder()
                                    .seatType(seatType)
                                    .rowNumber(seatPosition.getRowNumber())
                                    .colNumber(seatPosition.getColNumber())
                                    .hall(hall)
                                    .build());
        }).toList();
    }

    public Hall getHall(Long hallId) {
        return hallRepository.findById(hallId).orElse(null);
    }
}
