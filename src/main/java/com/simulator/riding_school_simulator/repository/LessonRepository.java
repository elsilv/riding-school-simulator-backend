package com.simulator.riding_school_simulator.repository;

import com.simulator.riding_school_simulator.model.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lessons, Long> {
    
}