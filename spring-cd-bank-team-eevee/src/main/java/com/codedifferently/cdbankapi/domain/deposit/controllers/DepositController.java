package com.codedifferently.cdbankapi.domain.deposit.controllers;

import com.codedifferently.cdbankapi.domain.deposit.models.Deposit;
import com.codedifferently.cdbankapi.domain.deposit.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/deposit")
public class DepositController {
    private DepositService depositService;

    @Autowired
    public DepositController(DepositService depositService) { this.depositService = depositService; }

    @GetMapping
    public ResponseEntity<Deposit> getDeposit() {
        List<Deposit> deposits = depositService.getAllDeposits();
        return new ResponseEntity(deposits, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deposit> create(@RequestBody Deposit deposit) {
        deposit = depositService.createDeposit(deposit);
        return new ResponseEntity<>(deposit, HttpStatus.CREATED);
    }

    @GetMapping("{date}")
    public ResponseEntity<Deposit> getDepositsByDate(@PathVariable("date") Date date) {
        List<Deposit> deposit = depositService.getDepositsByDate(date);
        return new ResponseEntity(deposit, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Deposit> getDepositsByType(@RequestParam String type) {
        List<Deposit> deposits = depositService.getDepositsByType(type);
        return new ResponseEntity(deposits, HttpStatus.OK);
    }
}
