package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Balance;
import com.simulator.riding_school_simulator.model.Transaction;
import com.simulator.riding_school_simulator.repository.BalanceRepository;
import com.simulator.riding_school_simulator.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Transactional
    public Transaction addTransaction(Transaction transaction) {
        Balance balance = balanceRepository.findById(1L)
                .orElse(new Balance(1L, BigDecimal.ZERO));

        BigDecimal newBalance = balance.getAmount().add(transaction.getAmount());
        balance.setAmount(newBalance);

        balanceRepository.save(balance);

        transaction.setBalanceAfter(newBalance);
        return transactionRepository.save(transaction);
    }

}