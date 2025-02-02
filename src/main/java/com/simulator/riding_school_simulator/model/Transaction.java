package com.simulator.riding_school_simulator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private BigDecimal amount;
    private String type;
    private String description;

    private Long related_id;
    private BigDecimal balance_after;

    public void setBalanceAfter(BigDecimal balanceAfter) {
        this.balance_after = balanceAfter;
    }

    public BigDecimal getBalanceAfter() {
        return balance_after;
    }

}