package com.chunyue.unittesting;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    // needs to be annotated
    @org.junit.jupiter.api.Test
    void deposit() {
        // return void
        // a test should be self contained
        BankAccount account = new BankAccount("Tim", "Ma", 1000.00);
        double balance = account.deposit(200.00, true);
        // the third parameter is the delta that is tolerated for error margin
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Tim", "Ma", 1000.00);
        account.withdraw(200.00, true);
        // the third parameter is the delta that is tolerated for error margin
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        // a test should be self contained
        BankAccount account = new BankAccount("Tim", "Ma", 1000.00);
        account.deposit(200.00, true);
        // the third parameter is the delta that is tolerated for error margin
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void dummyTest(){
        // use assertEqauls to compare expected with the actual
        assertEquals(21, 21);
        assertEquals(20, 20);
    }
}