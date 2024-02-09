package service;

import Models.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repository.MovieRepository;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovie(Long id) {
        return movieRepository.findById(id).orElse(null);
    }
}
