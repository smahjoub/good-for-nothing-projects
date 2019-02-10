package com.smahjoub.jodie;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.lang.RandomStringUtils;

/**
 *
 * @author smahjoub
 */
public final class BankAccount {

    private final String id;

    private final String owner;

    private AtomicReference<BigDecimal> balanceRef;

    private List<Transaction> transactions;

    public BankAccount(String id, String owner){
        this.id = id;
        this.owner = owner;
        this.balanceRef = new AtomicReference<>(BigDecimal.ZERO);
        this.transactions = new CopyOnWriteArrayList<>();
    }

    public void deposit(BigDecimal amount)
            throws IllegalArgumentException {
        if(amount == null || amount.compareTo(BigDecimal.ZERO) < 0){
            throw  new  IllegalArgumentException("Amount should be not negative and not null");
        }

        balanceRef.accumulateAndGet(amount, (bg1, bg2) -> bg1.add(bg2));
        transactions.add(new Transaction(RandomStringUtils.randomAlphanumeric(5), new Date(), amount, TransactionType.Deposit));
    }

    public void withdraw(BigDecimal amount)
            throws IllegalArgumentException, UnsupportedOperationException {
        if(amount == null ||
                amount.compareTo(BigDecimal.ZERO) < 0){
            throw  new  IllegalArgumentException("Amount should be not negative and not null");
        }

        if(balanceRef.get().subtract(amount).compareTo(BigDecimal.ZERO) < 0){
            throw new UnsupportedOperationException("Could not withdraw more than balance amount");
        }

        balanceRef.accumulateAndGet(amount, (bg1, bg2) -> bg1.subtract(bg2));
        transactions.add(new Transaction(RandomStringUtils.randomAlphanumeric(5),
                new Date(), amount, TransactionType.Withdrawl));

    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public BigDecimal getBalance() {
        return balanceRef.get();
    }

    public List<Transaction> getTransactions() {
        return Collections
                .unmodifiableList(transactions);
    }
}
