package com.simulator.riding_school_simulator.repository;

import com.simulator.riding_school_simulator.model.Bills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillsRepository extends JpaRepository<Bills, Long> {
    List<Bills> findByPaidFalse();
    List<Bills> findByUserId(Long userId);
    List<Bills> findByPaidFalseAndUserId(Long userId);
}