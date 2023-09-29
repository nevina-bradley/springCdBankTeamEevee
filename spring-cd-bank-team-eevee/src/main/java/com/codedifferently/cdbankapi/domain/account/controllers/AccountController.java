package com.codedifferently.cdbankapi.domain.account.controllers;

import com.codedifferently.cdbankapi.domain.account.models.Account;
import com.codedifferently.cdbankapi.domain.account.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class represents our controller for our account models/entities.
 * This is responsible for handling any and all http requests and responses.
 *
 * First, this class injects the AccountService, because all of the
 * requests and responses will come through the service.
 * Then, we define the methods for handling all the requests/responses that will occur
 * over the course of the app (POST, PUT, UPDATE, DELETE)
 */
@RestController // tells Spring that this is where it should check for URIs and URLs
@RequestMapping("/api/v1/accounts") // the base route, any request/response starts here
public class AccountController {

    // inject service into controller
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<Account> getAccount() {
        List<Account> account = accountService.getAllAccounts();
        return new ResponseEntity(account, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody Account account) {
        account = accountService.createAccount(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Integer id) {
        Optional<Account> account = accountService.getById(id);
        return new ResponseEntity(account, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Account> getAccountsByType(@RequestParam String type) {
        List<Account> account = accountService.getAccountsByType(type);
        return new ResponseEntity(account, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Account> update(@PathVariable("id") Integer id, @RequestBody Account updatedAccount) {
        try {
            Optional<Account> optionalExistingAccount = accountService.getById(id);
            if (!optionalExistingAccount.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Account existingAccount = optionalExistingAccount.get();

            existingAccount.setType(updatedAccount.getType());
            existingAccount.setNickname(updatedAccount.getNickname());
            existingAccount.setRewards(updatedAccount.getRewards());
            existingAccount.setBalance(updatedAccount.getBalance());

            Account updatedAccountResult = accountService.updateAccount(existingAccount);
            return new ResponseEntity<>(updatedAccountResult, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        accountService.deleteAccountById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
