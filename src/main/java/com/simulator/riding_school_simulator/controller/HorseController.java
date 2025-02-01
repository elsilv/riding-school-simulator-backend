package com.simulator.riding_school_simulator.controller;

import com.simulator.riding_school_simulator.model.Horse;
import com.simulator.riding_school_simulator.service.HorseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/horses")
public class HorseController {

    private final HorseService horseService;

    public HorseController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping
    public List<Horse> getAllHorses() {
        return horseService.getAllHorses();
    }

    @PostMapping
    public Horse addHorse(@RequestBody Horse horse) {
        return horseService.addHorse(horse);
    }

    @DeleteMapping("/{id}")
    public void deleteHorse(@PathVariable Long id) {
        horseService.deleteHorse(id);
    }
}