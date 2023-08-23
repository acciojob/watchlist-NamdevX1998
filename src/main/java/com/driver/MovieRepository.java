package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;


@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap =new HashMap<>();
    HashMap<String,Director> directorMap =new HashMap<>();
    HashMap<String,ArrayList<String>>directorMovieMapping=new HashMap<>(); //director_name and list of movies

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(),director);
    }

    public void add_movie_director_pair(String dname,String mname){
        if(movieMap.containsKey(mname) && directorMap.containsKey(dname)){
            if(directorMovieMapping.containsKey(dname)){
                ArrayList<String>temp=directorMovieMapping.get(dname);
                temp.add(mname);
                directorMovieMapping.put(dname,temp);
                return;
            }
            ArrayList<String>temp=new ArrayList<>();
            temp.add(mname);
            directorMovieMapping.put(dname,temp);
        }
    }

    public Movie getMovie(String name) {
        return movieMap.get(name);
    }

    public Director getDirector(String name) {
        return directorMap.get(name);
    }
    public ArrayList<String> getAllMovies(String dname){
        return directorMovieMapping.get(dname);
    }
    public ArrayList<String> getAllMovies() {
        ArrayList<String>ans=new ArrayList<>();
        for(String movie:movieMap.keySet()){
            ans.add(movie);
        }
        return ans;
    }
    public void delete_director(String dname) {
        ArrayList<String>deleteMovies=directorMovieMapping.get(dname);
        directorMovieMapping.remove(dname);
        for(String delete:deleteMovies){
            movieMap.remove(delete);
        }
        directorMap.remove(dname);
    }

    public void delete_director() {
        for(ArrayList<String>movie:directorMovieMapping.values()){
            for(String s:movie){
                movieMap.remove(s);
            }
        }
        directorMap.clear();
        directorMovieMapping.clear();
    }
}
