package com.codedifferently.cdbankapi.domain.deposit;

import com.codedifferently.cdbankapi.domain.deposit.controllers.DepositController;
import com.codedifferently.cdbankapi.domain.deposit.models.Deposit;
import com.codedifferently.cdbankapi.domain.deposit.services.DepositService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DepositControllerTest {

    @Mock
    private DepositService depositService;

    @InjectMocks
    private DepositController depositController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllDepositsTest() {
        List<Deposit> mockDeposits = new ArrayList<>();
        mockDeposits.add(new Deposit());
        when(depositService.getAllDeposits()).thenReturn(mockDeposits);

        ResponseEntity<Deposit> response = depositController.getDeposit();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockDeposits, response.getBody());
    }

    @Test
    void createDepositTest() {
        Deposit mockDeposit = new Deposit();
        when(depositService.createDeposit(mockDeposit)).thenReturn(mockDeposit);

        ResponseEntity<Deposit> response = depositController.create(mockDeposit);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockDeposit, response.getBody());
    }

    @Test
    void getDepositsByDateTest() {
        Date date = new Date();
        List<Deposit> mockDeposits = new ArrayList<>();
        mockDeposits.add(new Deposit());
        when(depositService.getDepositsByDate(date)).thenReturn(mockDeposits);

        ResponseEntity<Deposit> response = depositController.getDepositsByDate(date);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockDeposits, response.getBody());
    }

    @Test
    void getDepositsByTypeTest() {
        String type = "Savings";
        List<Deposit> mockDeposits = new ArrayList<>();
        mockDeposits.add(new Deposit());
        when(depositService.getDepositsByType(type)).thenReturn(mockDeposits);

        ResponseEntity<Deposit> response = depositController.getDepositsByType(type);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockDeposits, response.getBody());
    }
}