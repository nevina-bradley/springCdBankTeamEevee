package com.codedifferently.cdbankapi.domain.withdrawal.services;

import com.codedifferently.cdbankapi.domain.withdrawal.models.Withdrawal;
import com.codedifferently.cdbankapi.domain.withdrawal.repos.WithdrawalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * This class represents the service layer for our withdrawal model/entity
 * Handles the business logic aka the CRUD methods that will interact with
 * our database/data access layer (repos and database).
 * Meant to be used by our controller and other services.
 *
 * @Service - tells Spring that this is the Service for our application, making it a spring bean.
 *
 */
@Service
public class WithdrawalService {

    // data injection
    private WithdrawalRepo withdrawalRepo;

    @Autowired
    public WithdrawalService(WithdrawalRepo withdrawalRepo) {
        this.withdrawalRepo = withdrawalRepo;
    }

    //  Bizness logic aka CRUD methods

    // CREATE

    public Withdrawal createWithdrawal(Withdrawal withdrawal) {
        return withdrawalRepo.save(withdrawal);
    }

    // READ

    public List<Withdrawal> getAllWithdrawals() {
        return withdrawalRepo.findAll();
    }

    public List<Withdrawal> getWithdrawalsByDate(Date date) {
        return withdrawalRepo.findByDate(date).orElse(null);
    }

    public List<Withdrawal> getWithdrawalsByType(String type) {
        return withdrawalRepo.findByType(type).orElse(null);
    }
}
