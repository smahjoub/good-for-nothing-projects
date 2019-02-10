package com.smahjoub.jodie;

/**
 *
 * @author smahjoub
 */
public enum TransactionType {
    Deposit("Deposit"),
    Withdrawl("Withdrawal");

    private final String name;

    TransactionType(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
