package controllers;

import Models.Movie;
import dtos.CreateMovieRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.MovieService;

@RestController
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;
    @PostMapping("/movie")
    public Movie createMovie(@RequestBody CreateMovieRequest request){
       return movieService.createMovie(request.toMovie());
    }
    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable Long id){

        return movieService.getMovie(id);
    }
}
