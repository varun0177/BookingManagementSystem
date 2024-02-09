package Models;

import enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Seat seat;
    @ManyToOne
    private Show show;
    @Enumerated
    private SeatStatus seatStatus;
}
