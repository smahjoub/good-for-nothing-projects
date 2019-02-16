package com.smahjoub.metic;

public enum TennisScore {
    Zero("Zero"),
    Fifteen("Fifteen"),
    Thirty("Thirty"),
    Forty("Forty"),
    Victory("Victory");

    private final String name;

    TennisScore(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
