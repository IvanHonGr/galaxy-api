package com.example.galaxy.aircraft.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.function.Consumer;

@Repository
public class AirCraftRepo {

    interface Repo extends JpaRepository<AirCraft, Long> {

    }

    @Autowired
    private Repo airCraftRepository;


    public AirCraft findById(Long id) {
        return airCraftRepository.findById(id).orElseGet(() -> {throw new IllegalArgumentException("heyyyy, no such id"); });
    }

    public AirCraft save(Consumer<AirCraft> update) {
        AirCraft airCraft = new AirCraft();
        update.accept(airCraft);
        return airCraftRepository.save(airCraft);
    }

}
