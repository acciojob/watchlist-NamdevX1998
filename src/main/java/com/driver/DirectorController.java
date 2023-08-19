package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DirectorController {
    @Autowired
    DirectorService directorService=new DirectorService();
    @PostMapping("/POST /movies/add-director")
    public String addDirector(@RequestBody Director director){
        return directorService.addDirector(director);
    }
    @GetMapping("/get/{name}")
    public Director getDirector(@PathVariable ("name") String name){
        return directorService.getDirector(name);
    }
}
