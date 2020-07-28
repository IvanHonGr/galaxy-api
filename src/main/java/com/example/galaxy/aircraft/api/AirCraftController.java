package com.example.galaxy.aircraft.api;

import com.example.galaxy.aircraft.domain.AirCraft;
import com.example.galaxy.aircraft.domain.AirCraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aircraft")
public class AirCraftController {

    @Autowired
    private AirCraftMapper mapper;

    @Autowired
    private AirCraftRepo repo;

    @GetMapping
    public String getDepartment() {
        return "{\"hi\": \"hello www\"}";
    }

    @PostMapping
    public AirCraftView
    create(@RequestBody AirCraftForm form) {
        AirCraft airCraft = repo.save(a -> mapper.map(form, a));
        return mapper.map(airCraft);
    }

    @GetMapping("/{id}")
    public AirCraftView
    get(@PathVariable Long id) {
        AirCraft airCraft = repo.findById(id);
        return mapper.map(airCraft);
    }
}
