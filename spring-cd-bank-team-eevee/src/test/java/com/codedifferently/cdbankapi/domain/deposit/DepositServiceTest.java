package com.codedifferently.cdbankapi.domain.deposit;

import com.codedifferently.cdbankapi.domain.deposit.services.DepositService;
import com.codedifferently.cdbankapi.domain.deposit.models.Deposit;
import com.codedifferently.cdbankapi.domain.deposit.repos.DespositRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DepositServiceTest {

    @Mock
    private DespositRepo depositRepo;

    @InjectMocks
    private DepositService depositService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDepositTest() {
        Deposit mockDeposit = new Deposit();
        when(depositRepo.save(mockDeposit)).thenReturn(mockDeposit);

        Deposit result = depositService.createDeposit(mockDeposit);

        assertEquals(mockDeposit, result);
    }

    @Test
    void getAllDepositsTest() {
        List<Deposit> mockDeposits = new ArrayList<>();
        mockDeposits.add(new Deposit());
        when(depositRepo.findAll()).thenReturn(mockDeposits);

        List<Deposit> result = depositService.getAllDeposits();

        assertEquals(mockDeposits, result);
    }

    @Test
    void getDepositsByDateTest() {
        Date date = new Date();
        List<Deposit> mockDeposits = new ArrayList<>();
        mockDeposits.add(new Deposit());
        when(depositRepo.findByDate(date)).thenReturn(mockDeposits);

        List<Deposit> result = depositService.getDepositsByDate(date);

        assertEquals(mockDeposits, result);
    }

    @Test
    void getDepositsByTypeTest() {
        String type = "Savings";
        List<Deposit> mockDeposits = new ArrayList<>();
        mockDeposits.add(new Deposit());
        when(depositRepo.findByType(type)).thenReturn(mockDeposits);

        List<Deposit> result = depositService.getDepositsByType(type);

        assertEquals(mockDeposits, result);
    }
}