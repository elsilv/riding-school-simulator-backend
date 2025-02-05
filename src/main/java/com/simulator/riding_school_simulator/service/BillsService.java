package com.simulator.riding_school_simulator.service;

import com.simulator.riding_school_simulator.model.Balance;
import com.simulator.riding_school_simulator.model.Bills;
import com.simulator.riding_school_simulator.model.Transaction;
import com.simulator.riding_school_simulator.repository.BalanceRepository;
import com.simulator.riding_school_simulator.repository.BillsRepository;
import com.simulator.riding_school_simulator.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Transactional
    public void payBill(Long billId) {
        Bills bill = getBillsById(billId);

        if (bill.isPaid()) {
            throw new RuntimeException("Bill is already paid");
        }

        Transaction transaction = new Transaction();
        transaction.setType("BILL_PAYMENT");
        transaction.setAmount(bill.getAmount().negate());
        transaction.setDate(new Date());
        transactionRepository.save(transaction);

        Balance balance = balanceRepository.findById(1L).orElseThrow();
        balance.setAmount(balance.getAmount().subtract(bill.getAmount()));
        balanceRepository.save(balance);

        bill.setPaid(true);
        billsRepository.save(bill);
    }
}
