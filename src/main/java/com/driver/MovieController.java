package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public String addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PostMapping("/add-director")
    public String addDirector(@RequestBody Director director){
        return movieService.addDirector(director);
    }

    @PutMapping("/add-movie-director-pair")
    public String add_movie_director_pair(@RequestParam("dname") String dname,@RequestParam("mname") String mname){
        //dname->director name mname->movie name
        return movieService.add_movie_director_pair(dname,mname);
    }

    @GetMapping("/get-movie-by-name/{movie_name}")
    public Movie getMovie(@PathVariable("movie_name") String mname){
        return movieService.getMovie(mname);
    }

    @GetMapping("/get-director-by-name/{director-name}")
    public Director getDirector(@PathVariable ("director-name") String name){
        return movieService.getDirector(name);
    }

    @GetMapping("/get-movies-by-director-name/{director}")   //not display a result
    public ArrayList<String> getAllMovies(@PathVariable("director")String dname){
        return movieService.getAllMovies(dname);
    }
    @GetMapping("/get-all-movies")
    public ArrayList<String> getAllMovies(){
        return movieService.getAllMovies();
    }

    @DeleteMapping("/delete-director-by-name/{director_name}")
    public String delete_director(@PathVariable("director_name") String dname){
        return movieService.delete_director(dname);
    }

    @DeleteMapping("/delete-all-directors")
    public String delete_all_director(){
        return movieService.delete_director();
    }
}
