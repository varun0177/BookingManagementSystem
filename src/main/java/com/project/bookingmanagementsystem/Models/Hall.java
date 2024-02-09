package Models;

import enums.Features;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Hall extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "hall")
    private List<Seat> seats=new ArrayList<>();
    @ElementCollection
    @Enumerated
    private List<Features> features=new ArrayList<>();
}
