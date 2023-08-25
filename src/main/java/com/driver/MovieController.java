package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added Successfully", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New directed added Successfully", HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("dname") String dname,@RequestParam("mname") String mname){
        //dname->director name mname->movie name
        movieService.add_movie_director_pair(dname,mname);
        return new ResponseEntity<>("New movie-director pair added Successfully", HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{movie_name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movie_name") String mname){
        Movie m=movieService.getMovie(mname);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{director-name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable ("director-name") String name){
        Director d=movieService.getDirector(name);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<ArrayList<String>> getMoviesByDirectorName(@PathVariable("director")String dname){
        ArrayList<String>m=movieService.getAllMovies(dname);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<ArrayList<String>> findAllMovies(){
        ArrayList<String>m=movieService.getAllMovies();
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    //hello

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director_name") String dname){
        movieService.delete_director(dname);
        return new ResponseEntity<>(dname+" is removed successfully.",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.delete_director();
        return new ResponseEntity<>("All directors are removed successfully.",HttpStatus.OK);
    }
}
