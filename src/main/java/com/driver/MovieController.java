package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        movieService.addMovieDirectorPair(dname,mname);
        return new ResponseEntity<>("New movie-director pair added Successfully", HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{movie_name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movie_name") String mname){
        Movie m=movieService.getMovieByName(mname);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{director-name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable ("director-name") String name){
        Director d=movieService.getDirectorByName(name);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director")String dname){
        List<String> m=movieService.getMoviesByDirectorName(dname);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String>m=movieService.findAllMovies();
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director_name") String dname){
        movieService.deleteDirectorByName(dname);
        return new ResponseEntity<>(dname+" is removed successfully.",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors are removed successfully.",HttpStatus.OK);
    }
}
