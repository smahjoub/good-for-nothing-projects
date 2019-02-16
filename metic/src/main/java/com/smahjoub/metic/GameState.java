package com.smahjoub.metic;

public enum GameState {
    NotReady("NotReady"),
    Ready("Ready"),
    Playing("Playing"),
    Finished("Finished");

    private final String state;

    GameState(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
