package com.simulator.riding_school_simulator.repository;

import com.simulator.riding_school_simulator.model.Horse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorseRepository extends JpaRepository<Horse, Long> {
}