package com.simulator.riding_school_simulator.controller;


import com.simulator.riding_school_simulator.model.Bills;
import com.simulator.riding_school_simulator.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/unpaid")
    public List<Bills> getUnpaidBills() {
        return billsService.getAllUnpaidBills();
    }
}