package com.smahjoub.jodie;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author smahjoub
 */
public final class Transaction {

    private final String id;

    private final Date date;

    private final BigDecimal amount;

    private final TransactionType type;

    public Transaction(String id, Date date, BigDecimal amount, TransactionType type){
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
        return type;
    }
}
