package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Bills;
import com.simulator.riding_school_simulator.repository.BalanceRepository;
import com.simulator.riding_school_simulator.repository.BillsRepository;
import com.simulator.riding_school_simulator.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillsService {

    @Autowired
    private BillsRepository billsRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    public List<Bills> getAllBills() {
        return billsRepository.findAll();
    }

    public Bills getBillsById(Long id) {
        Optional<Bills> bill = billsRepository.findById(id);
        return bill.orElse(null);
    }

    public List<Bills> getAllUnpaidBills() {
        return billsRepository.findByPaidFalse();
    }
}
