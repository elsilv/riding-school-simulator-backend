package com.simulator.riding_school_simulator.controller;

import com.simulator.riding_school_simulator.model.Bills;
import com.simulator.riding_school_simulator.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    BillsService billsService;

    @GetMapping
    public List<Bills> getAllBills() {
        return billsService.getAllBills();
    }

    @GetMapping("/{userId}")
    public List<Bills> getAllOwnedBills(@PathVariable Long userId) {
        return billsService.getAllOwnedBills(userId);
    }

    @GetMapping("/unpaid")
    public List<Bills> getUnpaidBills() {
        return billsService.getAllUnpaidBills();
    }

    @GetMapping("/{userId}/unpaid")
    public List<Bills> getAllUsersUnpaidBills(@PathVariable Long userId) {
        return billsService.getAllUsersUnpaidBills(userId);
    }

    @PutMapping("/{id}/pay")
    public String payBill(@PathVariable Long id) {
        billsService.payBill(id);
        return "Bill paid successfully!";
    }
}