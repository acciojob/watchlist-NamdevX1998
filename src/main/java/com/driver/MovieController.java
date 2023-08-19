package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService=new MovieService();
    @PostMapping("/POST /movies/add-movie")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }
    @GetMapping("/get/{name}")
    public Movie getMovie(@PathVariable("name") String name){
        return movieService.getMovie(name);
    }

    @GetMapping("/get")
    public ArrayList<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }
}
