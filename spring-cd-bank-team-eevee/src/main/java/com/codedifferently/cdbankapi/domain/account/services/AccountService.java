package com.codedifferently.cdbankapi.domain.account.services;

import com.codedifferently.cdbankapi.domain.account.models.Account;
import com.codedifferently.cdbankapi.domain.account.repos.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * This class represents the service layer for our account model/entity
 * Handles the business logic aka the CRUD methods that will interact with
 * our database/data access layer (repos and database).
 * Meant to be used by our controller and other services.
 *
 * @Service - tells Spring that this is the Service for our application, making it a spring bean.
 *
 */
@Service
public class AccountService {

    // inject our repo to allow access to the database layer
    private final AccountRepo accountRepo;

    @Autowired // automatically finds and injects the required object/dependency for this constructor
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    // Bizness logic aka CRUD methods

    // CREATE - satisfy the POST request to create a account and post it to the database
    public Account createAccount(Account account) {
        return accountRepo.save(account); // sends the account to the repo to save it to the database
    }

    // READ - Fulfill the GET requests (getAll, getById, etc.)
    public List<Account> getAllAccounts(){
        return accountRepo.findAll();
    }

    public Optional<Account> getById(Integer id){ // account might not be present so return optional
        return accountRepo.findById(id);
    }

    public List<Account> getAccountsByType(String type){
        return accountRepo.findByType(type).orElse(null);
    }

    // UPDATE
    public Account updateAccount(Account updatedAccount) {
        return accountRepo.save(updatedAccount);
    }

    // DELETE
    public void deleteAccountById(Integer id) {
        accountRepo.deleteById(id);
    }

}
