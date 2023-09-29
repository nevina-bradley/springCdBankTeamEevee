package com.codedifferently.cdbankapi.domain.withdrawal;

import com.codedifferently.cdbankapi.domain.withdrawal.services.WithdrawalService;
import com.codedifferently.cdbankapi.domain.withdrawal.models.Withdrawal;
import com.codedifferently.cdbankapi.domain.withdrawal.repos.WithdrawalRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WithdrawalServiceTest {

    @Mock
    private WithdrawalRepo withdrawalRepo;

    @InjectMocks
    private WithdrawalService withdrawalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createWithdrawalTest() {
        Withdrawal mockWithdrawal = new Withdrawal();
        when(withdrawalRepo.save(mockWithdrawal)).thenReturn(mockWithdrawal);

        Withdrawal result = withdrawalService.createWithdrawal(mockWithdrawal);

        assertEquals(mockWithdrawal, result);
    }

    @Test
    void getAllWithdrawalsTest() {
        List<Withdrawal> mockWithdrawals = new ArrayList<>();
        mockWithdrawals.add(new Withdrawal());
        when(withdrawalRepo.findAll()).thenReturn(mockWithdrawals);

        List<Withdrawal> result = withdrawalService.getAllWithdrawals();

        assertEquals(mockWithdrawals, result);
    }

    @Test
    void getWithdrawalsByDateTest() {
        Date date = new Date();
        List<Withdrawal> mockWithdrawals = new ArrayList<>();
        mockWithdrawals.add(new Withdrawal());
        when(withdrawalRepo.findByDate(date)).thenReturn(Optional.of(mockWithdrawals));

        List<Withdrawal> result = withdrawalService.getWithdrawalsByDate(date);

        assertEquals(mockWithdrawals, result);
    }

    @Test
    void getWithdrawalsByTypeTest() {
        String type = "Savings";
        List<Withdrawal> mockWithdrawals = new ArrayList<>();
        mockWithdrawals.add(new Withdrawal());
        when(withdrawalRepo.findByType(type)).thenReturn(Optional.of(mockWithdrawals));

        List<Withdrawal> result = withdrawalService.getWithdrawalsByType(type);

        assertEquals(mockWithdrawals, result);
    }
}