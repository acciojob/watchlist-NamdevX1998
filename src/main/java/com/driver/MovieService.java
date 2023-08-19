package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository=new MovieRepository();
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
       return "Movie added Succefully!!!";
    }

    public Movie getMovie(String name) {
        return movieRepository.getMovie(name);
    }
    public ArrayList<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }
}
