package com.codedifferently.cdbankapi.domain.withdrawal.controllers;

import com.codedifferently.cdbankapi.domain.withdrawal.models.Withdrawal;
import com.codedifferently.cdbankapi.domain.withdrawal.services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/withdrawal")
public class WithdrawalController {
    private WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) { this.withdrawalService = withdrawalService; }

    @GetMapping
    public ResponseEntity<Withdrawal> getWithdrawal() {
        List<Withdrawal> withdrawals = withdrawalService.getAllWithdrawals();
        return new ResponseEntity(withdrawals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Withdrawal> create(@RequestBody Withdrawal withdrawal) {
        withdrawal = withdrawalService.createWithdrawal(withdrawal);
        return new ResponseEntity<>(withdrawal, HttpStatus.CREATED);
    }

    @GetMapping("{date}")
    public ResponseEntity<Withdrawal> getWithdrawalsByDate(@PathVariable("date") Date date) {
        List<Withdrawal> withdrawals = withdrawalService.getWithdrawalsByDate(date);
        return new ResponseEntity(withdrawals, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Withdrawal> getWithdrawalsByType(@RequestParam String type) {
        List<Withdrawal> withdrawals = withdrawalService.getWithdrawalsByType(type);
        return new ResponseEntity(withdrawals, HttpStatus.OK);
    }
}
