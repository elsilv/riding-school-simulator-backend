package com.simulator.riding_school_simulator.repository;

import com.simulator.riding_school_simulator.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    @Query("SELECT b FROM Balance b WHERE b.id = 1")
    Balance getCurrentBalance();
}
