package com.smahjoub.jodie;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 *
 * @author smahjoub
 */
public class BankAccountTest {


    @Test
    public void testDepositMoneySingleThread(){

        final BigDecimal expectedBalance = new BigDecimal("49.23");

        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("34"));
        ba.deposit(new BigDecimal("15.23"));

        assertTrue(ba.getBalance().equals(expectedBalance));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNullValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("34"));
        ba.deposit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("34"));
        ba.deposit(new BigDecimal("-42"));
    }

    @Test
    public void testWithdrawMoneySingleThread(){
        final BigDecimal expectedBalanceForSource = new BigDecimal("0.23");

        BankAccount baSource = new BankAccount("id1", "Jodie Alba", new BigDecimal("10.23"));
        baSource.withdraw(new BigDecimal("10"));

        assertTrue(baSource.getBalance().equals(expectedBalanceForSource));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNullValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("34"));
        ba.withdraw(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("34"));
        ba.withdraw(new BigDecimal("-42"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testWithdrawMoreThanBalanceValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("34"));
        ba.withdraw(new BigDecimal("42"));
    }

    @Test
    public void testGetTransactionsHistorySingleThread(){

        BankAccount ba = new BankAccount("id1", "Jodie Alba", new BigDecimal("10.23"));

        ba.deposit(new BigDecimal("10"));
        ba.deposit(new BigDecimal("20"));

        ba.withdraw(new BigDecimal("10"));

        List<Transaction> baHistory = ba.getTransactions();

        assertTrue(baHistory.size() == 3);

        assertTrue(baHistory.get(0).getType() == TransactionType.Deposit);
        assertTrue(baHistory.get(0).getAmount().equals(new BigDecimal("10")));

        assertTrue(baHistory.get(1).getType() == TransactionType.Deposit);
        assertTrue(baHistory.get(1).getAmount().equals(new BigDecimal("20")));

        assertTrue(baHistory.get(2).getType() == TransactionType.Withdrawl);
        assertTrue(baHistory.get(2).getAmount().equals(new BigDecimal("10")));

    }
}
