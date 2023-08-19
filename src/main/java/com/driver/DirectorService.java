package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    @Autowired
    DirectorRepository directorRepository=new DirectorRepository();
    public String addDirector(Director director) {
        directorRepository.addDirector(director);
        return "Added Succefully!!";
    }
    public Director getDirector(String name) {
        return directorRepository.getDirector(name);
    }
}
