package com.driver;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap =new HashMap<>();
    HashMap<String,Director> directorMap =new HashMap<>();
    HashMap<String,List<String>>directorMovieMapping=new HashMap<>(); //director_name and list of movies

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(),director);
    }

    public void add_movie_director_pair(String dname,String mname){
        if(movieMap.containsKey(mname) && directorMap.containsKey(dname)){
            if(directorMovieMapping.containsKey(dname)){
                List<String> temp=directorMovieMapping.get(dname);
                temp.add(mname);
                directorMovieMapping.put(dname,temp);
                return;
            }
            List<String>temp=new ArrayList<>();
            temp.add(mname);
            directorMovieMapping.put(dname,temp);
        }
    }

    public Movie getMovie(String name) {
        if(movieMap.containsKey(name))
        return movieMap.get(name);
        return null;
    }

    public Director getDirector(String name) {
        if(directorMap.containsKey(name))
        return directorMap.get(name);
        return null;
    }
    public List<String> getAllMovies(String dname){
        if(directorMovieMapping.containsKey(dname))
        return directorMovieMapping.get(dname);
        return new ArrayList<>();
    }
    public List<String> getAllMovies() {
        List<String>ans=new ArrayList<>();
        if(movieMap.size()==0)
            return ans;
        for(String movie:movieMap.keySet()){
            ans.add(movie);
        }
        return ans;
    }
    public void delete_director(String dname) {
        if(!(directorMovieMapping.containsKey(dname)))
            return;
        List<String>deleteMovies=directorMovieMapping.get(dname);
        directorMovieMapping.remove(dname);
        for(String delete:deleteMovies){
            movieMap.remove(delete);
        }
        directorMap.remove(dname);
        if(directorMap.containsKey(dname))
            directorMap.remove(dname);
    }

    public void delete_director() {
        if(directorMap.size()!=0)
            directorMap.clear();

        for(List<String>movies:directorMovieMapping.values()){
            for(String s:movies){
                movieMap.remove(s);
            }
        }
        directorMovieMapping.clear();
    }
}
