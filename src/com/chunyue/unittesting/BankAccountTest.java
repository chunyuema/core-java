package com.chunyue.unittesting;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int testCount;

    @org.junit.jupiter.api.BeforeAll
    public static void setupBeforeAllTest(){
        System.out.println("This is executed before all the tests! Number of test ran: " + testCount++);
    }

    @org.junit.jupiter.api.AfterAll
    public static void cleanUpAfterAllTest(){
        System.out.println("This is executed after all the tests! Number of test ran: " + testCount++);
    }

    @org.junit.jupiter.api.BeforeEach // run before each test is completed
    public void setupForEachTest(){
        account = new BankAccount("Chunyue", "Ma", 1000.0, BankAccount.CHECKING);
        System.out.println("Running the tests now");
    }

    @org.junit.jupiter.api.AfterEach
    public void cleanUpAfterEachTest(){
        System.out.println("Count = " + testCount++);
    }

    // needs to be annotated
    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        // the third parameter is the delta that is tolerated for error margin
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.0, true);
        assertEquals(400, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw_notbranch() throws Exception {
        assertThrows(IllegalArgumentException.class, ()->{
            double balance = account.withdraw(600.0, false);
        });
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        // the third parameter is the delta that is tolerated for error margin
        assertEquals(800, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        // a test should be self contained
        account.deposit(200.00, true);
        // the third parameter is the delta that is tolerated for error margin
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true(){
        assertTrue(account.isChecking());
    }

    @org.junit.jupiter.api.Test
    void dummyTest(){
        // use assertEqauls to compare expected with the actual
        assertEquals(21, 21);
        assertEquals(20, 20);
    }
}