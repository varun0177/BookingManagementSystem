package dtos;

import Models.Movie;
import enums.Features;
import enums.Language;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class CreateMovieRequest {
    private String name;
    private Double rating;
    private List<Language> languages = new ArrayList<>();
    private List<Features> features = new ArrayList<>();
    public Movie toMovie(){
        return Movie.builder()
                .name(name)
                .rating(rating)
                .languages(languages)
                .build();
    }

}
