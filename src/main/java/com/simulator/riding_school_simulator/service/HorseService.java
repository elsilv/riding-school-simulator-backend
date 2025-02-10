package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Horse;
import com.simulator.riding_school_simulator.repository.HorseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseService {

    @Autowired
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

    public List<Horse> getAvailableHorses() {
        return horseRepository.findByOwnerIsNull();
    }

    public void deleteHorse(Long id) {
        horseRepository.deleteById(id);
    }
}