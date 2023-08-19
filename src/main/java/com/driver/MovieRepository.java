package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
@Repository
public class MovieRepository {
    HashMap<String,Movie> hm=new HashMap<>();

    public void addMovie(Movie movie) {
        hm.put(movie.getName(),movie);
    }

    public Movie getMovie(String name) {
        return hm.get(name);
    }
    public ArrayList<Movie> getAllMovies(){
        ArrayList<Movie>list=new ArrayList<>();
        for(String s:hm.keySet()){
            Movie m=hm.get(s);
            list.add(m);
        }
        return list;
    }
}
