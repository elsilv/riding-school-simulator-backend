package com.simulator.riding_school_simulator.controller;

import com.simulator.riding_school_simulator.model.Balance;
import com.simulator.riding_school_simulator.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @Autowired
    private BalanceRepository balanceRepository;

    @GetMapping("/{userId}")
            public ResponseEntity<Balance> getUserBalance(@PathVariable Long userId) {
                Balance balance = balanceRepository.findByUserId(userId);
                if (balance != null) {
                    return ResponseEntity.ok(balance);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }

    @PutMapping("/{userId}")
    public ResponseEntity<Balance> updateBalance(@RequestBody Balance newBalance, @PathVariable Long userId) {
        Balance balance = balanceRepository.findByUserId(userId);
        balance.setAmount(newBalance.getAmount());
        balanceRepository.save(balance);
        return ResponseEntity.ok(balance);
    }
}
