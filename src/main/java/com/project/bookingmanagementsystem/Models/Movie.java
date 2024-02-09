package Models;

import enums.Language;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie extends BaseModel{
    private String name;
    private double rating;
    private String category;
    @Enumerated
    @ElementCollection
    private List<Language> languages=new ArrayList<>();
    @OneToMany(mappedBy = "movie")
    private List<Show> shows =new ArrayList<>();
}
