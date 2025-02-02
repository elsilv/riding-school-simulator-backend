package com.simulator.riding_school_simulator.controller;

import com.simulator.riding_school_simulator.model.Balance;
import com.simulator.riding_school_simulator.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping
    public ResponseEntity<BigDecimal> getBalance() {
        Balance balance = balanceRepository.getCurrentBalance();
        if (balance == null) {
            return ResponseEntity.ok(BigDecimal.ZERO);
        }
        return ResponseEntity.ok(balance.getAmount());
    }
    

    @PutMapping
    public ResponseEntity<Balance> updateBalance(@RequestBody Balance newBalance) {
        Balance balance = balanceRepository.getCurrentBalance();
        balance.setAmount(newBalance.getAmount());
        balanceRepository.save(balance);
        return ResponseEntity.ok(balance);
    }
}
