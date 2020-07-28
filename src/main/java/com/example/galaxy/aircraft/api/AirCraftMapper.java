package com.example.galaxy.aircraft.api;

import com.example.galaxy.aircraft.domain.AirCraft;
import org.springframework.stereotype.Service;

@Service
public class AirCraftMapper {

    public AirCraft map(AirCraftForm form, AirCraft airCraft) {
        airCraft.setName(form.getName());
        return airCraft;
    }

    public AirCraftView map(AirCraft airCraft) {
        AirCraftView view = new AirCraftView();
        view.setId(airCraft.getId());
        view.setName(airCraft.getName());
        return view;
    }
}
