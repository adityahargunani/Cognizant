package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private BankAccount account;

    @Before
    public void setUp() {
        // This is part of 'Arrange' but shared across tests
        account = new BankAccount(100.0);
        System.out.println("Before Test: Account initialized with $100.");
    }

    @Test
    public void testDeposit() {
        // Arrange
        double depositAmount = 50.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(150.0, account.getBalance(), 0.001);
        System.out.println("Test: Deposit logic verified.");
    }

    @After
    public void tearDown() {
        account = null;
        System.out.println("After Test: Cleaning up account object.");
    }
}