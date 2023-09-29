package com.codedifferently.cdbankapi.domain.account;

import com.codedifferently.cdbankapi.domain.account.models.Account;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountTest {

    @Test
    public void constructorTest01(){
        Account account = new Account();
        assertNotNull(account);
    }

//    @Test
//    public void constructorTest02(){
//        Account account = new Account("Savings", )
//    }

}
