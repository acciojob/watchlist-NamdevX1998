package com.driver;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


@Repository
public class MovieRepository {
    HashMap<String,Movie> movieMap =new HashMap<>();
    HashMap<String,Director> directorMap =new HashMap<>();
    HashMap<Director,List<Movie>>directorMovieMapping=new HashMap<>(); //director_name and list of movies

    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(),movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(),director);
    }

    private boolean help(List<Movie>temp,String mname){
        for(Movie m:temp){
            String str=m.getName();
            if(str.equalsIgnoreCase(mname))
                return true;
        }
        return false;
    }

    public void addMovieDirectorPair(String dname,String mname){
        Director d=null;
        if(directorMap.containsKey(dname))
            d=directorMap.get(dname);
        else
            return;

        Movie m=null;
        if(movieMap.containsKey(mname))
            m=movieMap.get(dname);
        else
            return;


        if(directorMovieMapping.containsKey(d)){
            List<Movie>temp=directorMovieMapping.get(d);
            if(!help(temp,mname)){
                temp.add(m);
                directorMovieMapping.put(d,temp);
            }
            return;
        }
        else{
            List<Movie>temp=new ArrayList<>();
            temp.add(m);
            directorMovieMapping.put(d,temp);
        }
    }

    public Movie getMovieByName(String name) {
        if(movieMap.containsKey(name))
        return movieMap.get(name);
        return null;
    }

    public Director getDirectorByName(String name) {
        if(directorMap.containsKey(name))
        return directorMap.get(name);
        return null;
    }
    public List<String> getMoviesByDirectorName(String dname){
        Director d=null;
        if(directorMap.containsKey(dname))
            d=directorMap.get(dname);
        else
            return new ArrayList<>();

        List<String>temp=new ArrayList<>();
        if(directorMovieMapping.containsKey(d)){
            List<Movie>movies=directorMovieMapping.get(d);
            for(Movie m:movies)
            temp.add(m.getName());
            return temp;
        }
        return new ArrayList<>();
    }
    public List<String> findAllMovies() {
        List<String>ans=new ArrayList<>();
        if(movieMap.size()==0)
            return ans;
        for(String movie:movieMap.keySet()){
            ans.add(movie);
        }
        return ans;
    }
    public void deleteDirectorByName(String dname) {
        Director d=null;
        if(directorMap.containsKey(dname)){
            d=directorMap.get(dname);
            directorMap.remove(d);
        }
        else
            return;

        List<Movie>m=new ArrayList<>();
        if(directorMovieMapping.containsKey(d)){
            m=directorMovieMapping.get(d);
            directorMovieMapping.remove(d);
            help2(m);
        }
        else
            return;
    }
    private void help2(List<Movie>m){
        for(Movie movies:m){
            String Movie=movies.getName();
                for(String movie:movieMap.keySet()){
                    if(Movie.equalsIgnoreCase(movie)){
                        movieMap.remove(movie);
                        break;
                    }
                }
        }
    }

    public void deleteAllDirectors() {
        if(directorMovieMapping.size()==0){
            directorMap.clear();
            return;
        }

        List<Movie>m=new ArrayList<>();
        for(List<Movie>movies:directorMovieMapping.values()){
            for(Movie movie:movies){
                m.add(movie);
            }
        }
        help2(m);
        directorMap.clear();
    }
}
