package Models;

import enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Seat extends BaseModel{
    private int rowNumber;
    private int colNumber;
    @Enumerated
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall hall;

}
