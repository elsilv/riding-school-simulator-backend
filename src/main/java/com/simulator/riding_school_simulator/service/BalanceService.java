package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Balance;
import com.simulator.riding_school_simulator.repository.BalanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }
}