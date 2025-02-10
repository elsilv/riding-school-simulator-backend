package com.simulator.riding_school_simulator.repository;

import com.simulator.riding_school_simulator.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorseRepository extends JpaRepository<Horse, Long> {
    List<Horse> findByOwnerIsNull();
}