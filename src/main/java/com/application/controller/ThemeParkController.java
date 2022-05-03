package com.application.controller;

import com.application.bean.ThemePark;
import com.application.repo.ThemeParkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ThemeParkController {

    @Autowired
    private ThemeParkRepo repo;

    @GetMapping("/")
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/ride")
    public List<ThemePark> getAllRides(){
        return repo.findAll();
    }

    @GetMapping("/ride/{id}")
    public ThemePark getRide(@PathVariable int id) throws ResponseStatusException {
              return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Invalid id")));

    }

    @PostMapping("/ride/add")
    public Object addRide(@RequestBody ThemePark data){
        return repo.save(data);
    }
}
