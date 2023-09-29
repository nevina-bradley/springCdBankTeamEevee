package com.codedifferently.cdbankapi.domain.deposit.services;


import com.codedifferently.cdbankapi.domain.deposit.models.Deposit;
import com.codedifferently.cdbankapi.domain.deposit.repos.DespositRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * This class represents the service layer for our deposit model/entity
 * Handles the business logic aka the CRUD methods that will interact with
 * our database/data access layer (repos and database).
 * Meant to be used by our controller and other services.
 *
 * @Service - tells Spring that this is the Service for our application, making it a spring bean.
 *
 */
@Service
public class DepositService {

    // data injection
    private DespositRepo depositRepo;

    @Autowired
    public DepositService(DespositRepo depositRepo) {
        this.depositRepo = depositRepo;
    }

    //  Bizness logic aka CRUD methods

    // CREATE

    public Deposit createDeposit(Deposit deposit) {
        return depositRepo.save(deposit);
    }

    // READ

    public List<Deposit> getAllDeposits() {
        return depositRepo.findAll();
    }

    public List<Deposit> getDepositsByDate(Date date) {
        return depositRepo.findByDate(date);
    }

    public List<Deposit> getDepositsByType(String type) {
        return depositRepo.findByType(type);
    }
}
