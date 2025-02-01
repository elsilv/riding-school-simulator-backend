package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Horse;
import com.simulator.riding_school_simulator.repository.HorseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseService {

    private final HorseRepository horseRepository;

    public HorseService(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    public Horse addHorse(Horse horse) {
        return horseRepository.save(horse);
    }

    public List<Horse> getAllHorses() {
        return horseRepository.findAll();
    }

    public void deleteHorse(Long id) {
        horseRepository.deleteById(id);
    }
}