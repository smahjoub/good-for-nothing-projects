package com.smahjoub.jodie;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static junit.framework.TestCase.assertTrue;

/**
 *
 * @author smahjoub
 */
public class BankAccountTest {

    private final int threadCount = 5;

    @Test
    public void testWithdrawMoneyMultiThread() throws InterruptedException{

        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.deposit(new BigDecimal("9"));
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        Collection<Callable<BigDecimal>> tasks = new ArrayList<>();
        for (int x = 0; x < threadCount; x++) {
            Callable<BigDecimal> task = () -> {
                ba.withdraw(new BigDecimal("3"));
                return ba.getBalance();
            };
            tasks.add(task);
        }
        List<Future<BigDecimal>> futures =  executorService.invokeAll(tasks);
        List<Exception> exceptions = new ArrayList<>();
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                exceptions.add(e);
            }
        }

        executorService.shutdown();
        assertTrue(threadCount == futures.size());
        // we should expect 2 exceptions
        //  3 * 5 = 15; 15 - 9 = 6; 6 / 3 = 2
        assertTrue(exceptions.size() == 2);
    }

    @Test
    public void testDepositMoneySingleThread(){

        final BigDecimal expectedBalance = new BigDecimal("49.23");

        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.deposit(new BigDecimal("34"));
        ba.deposit(new BigDecimal("15.23"));

        assertTrue(ba.getBalance().equals(expectedBalance));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNullValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.deposit(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.deposit(new BigDecimal("-42"));
    }

    @Test
    public void testWithdrawMoneySingleThread(){
        final BigDecimal expectedBalanceForSource = new BigDecimal("0.23");

        BankAccount baSource = new BankAccount("id1", "Jodie Alba");
        baSource.deposit(new BigDecimal("10.23"));
        baSource.withdraw(new BigDecimal("10"));

        assertTrue(baSource.getBalance().equals(expectedBalanceForSource));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNullValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.withdraw(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.withdraw(new BigDecimal("-42"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testWithdrawMoreThanBalanceValue() {
        BankAccount ba = new BankAccount("id1", "Jodie Alba");
        ba.deposit(new BigDecimal("34"));
        ba.withdraw(new BigDecimal("42"));
    }

    @Test
    public void testGetTransactionsHistorySingleThread(){

        BankAccount ba = new BankAccount("id1", "Jodie Alba");

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
