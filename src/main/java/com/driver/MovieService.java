package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.ArrayList;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void add_movie_director_pair(String dname, String mname) {
        movieRepository.add_movie_director_pair(dname,mname);
    }

    public Movie getMovie(String mname) {
        return movieRepository.getMovie(mname);
    }

    public Director getDirector(String name) {
        return movieRepository.getDirector(name);
    }

    public List<String> getAllMovies(String name){
        return movieRepository.getAllMovies(name);
    }

    public List<String> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public void delete_director(String dname) {
        movieRepository.delete_director(dname);
    }

    public void delete_director() {
        movieRepository.delete_director();
    }
}
