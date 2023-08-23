package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public String addMovie(Movie movie) {
        movieRepository.addMovie(movie);
       return "Movie added Succefully!!!";
    }

    public String addDirector(Director director) {
        movieRepository.addDirector(director);
        return "Added Succefully!!";
    }

    public String add_movie_director_pair(String dname, String mname) {
        movieRepository.add_movie_director_pair(dname,mname);
        return "Operation Successful!!!";
    }

    public Movie getMovie(String mname) {
        return movieRepository.getMovie(mname);
    }

    public Director getDirector(String name) {
        return movieRepository.getDirector(name);
    }

    public ArrayList<String> getAllMovies(String name){
        return movieRepository.getAllMovies(name);
    }

    public ArrayList<String> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public String delete_director(String dname) {
        movieRepository.delete_director(dname);
        return "Successfully deletion";
    }

    public String delete_director() {
        movieRepository.delete_director();
        return "Successfully deletion";
    }
}
