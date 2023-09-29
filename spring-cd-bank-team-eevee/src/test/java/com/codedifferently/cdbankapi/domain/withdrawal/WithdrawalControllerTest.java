package com.codedifferently.cdbankapi.domain.withdrawal;

import com.codedifferently.cdbankapi.domain.withdrawal.controllers.WithdrawalController;
import com.codedifferently.cdbankapi.domain.withdrawal.models.Withdrawal;
import com.codedifferently.cdbankapi.domain.withdrawal.services.WithdrawalService;
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

public class WithdrawalControllerTest {

    @Mock
    private WithdrawalService withdrawalService;

    @InjectMocks
    private WithdrawalController withdrawalController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllWithdrawalsTest() {
        List<Withdrawal> mockWithdrawals = new ArrayList<>();
        mockWithdrawals.add(new Withdrawal());
        when(withdrawalService.getAllWithdrawals()).thenReturn(mockWithdrawals);

        ResponseEntity<Withdrawal> response = withdrawalController.getWithdrawal();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockWithdrawals, response.getBody());
    }

    @Test
    void createWithdrawalTest() {
        Withdrawal mockWithdrawal = new Withdrawal();
        when(withdrawalService.createWithdrawal(mockWithdrawal)).thenReturn(mockWithdrawal);

        ResponseEntity<Withdrawal> response = withdrawalController.create(mockWithdrawal);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockWithdrawal, response.getBody());
    }

    @Test
    void getWithdrawalsByDateTest() {
        Date date = new Date();
        List<Withdrawal> mockWithdrawals = new ArrayList<>();
        mockWithdrawals.add(new Withdrawal());
        when(withdrawalService.getWithdrawalsByDate(date)).thenReturn(mockWithdrawals);

        ResponseEntity<Withdrawal> response = withdrawalController.getWithdrawalsByDate(date);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockWithdrawals, response.getBody());
    }

    @Test
    void getWithdrawalsByTypeTest() {
        String type = "Savings";
        List<Withdrawal> mockWithdrawals = new ArrayList<>();
        mockWithdrawals.add(new Withdrawal());
        when(withdrawalService.getWithdrawalsByType(type)).thenReturn(mockWithdrawals);

        ResponseEntity<Withdrawal> response = withdrawalController.getWithdrawalsByType(type);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockWithdrawals, response.getBody());
    }
}
