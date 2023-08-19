package com.driver;

import java.util.HashMap;

public class DirectorRepository {
    HashMap<String,Director>db=new HashMap<>();

    public void addDirector(Director director) {
        db.put(director.getName(),director);
    }
    public Director getDirector(String name) {
        return db.get(name);
    }
}
