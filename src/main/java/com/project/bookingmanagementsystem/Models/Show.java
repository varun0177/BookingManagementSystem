package Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shows")
@Builder(toBuilder = true)
public class Show extends BaseModel{
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private int duration;
    private String language;
    @OneToMany(mappedBy = "Show")
    private List<ShowSeat> showSeats=new ArrayList<>();
    @ManyToOne
    private Hall hall;

}
