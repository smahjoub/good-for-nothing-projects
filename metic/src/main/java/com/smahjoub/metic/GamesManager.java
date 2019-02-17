package com.smahjoub.metic;

import java.util.LinkedList;

/**
 *
 * @author smahjoub
 */
public class GamesManager {

    private final LinkedList<GameScore> scores;

    private int setScore;
    private State state;

    /**
     *
     */
    public GamesManager(){
        scores = new LinkedList<>();
        state = State.NotReady;
    }

    public void initialize(){
        scores.clear();
        setScore = 0;
        moveNextSet();
        state = State.Ready;
    }

    /**
     *
     */
    public void start(){
        state = State.Playing;
    }

    /**
     *
     * @return
     * @throws UnsupportedOperationException
     */
    public GameScore getCurrentSetScore()
            throws UnsupportedOperationException {
        if(state == State.NotReady){
            throw new UnsupportedOperationException("Cannot get set score if the game is not ready");
        }

        return scores.getLast();
    }

    /**
     *
     * @param opponentPlayerSetManager
     * @throws IllegalArgumentException
     * @throws UnsupportedOperationException
     */
    public void score(GamesManager opponentPlayerSetManager)
            throws IllegalArgumentException, UnsupportedOperationException {

        if(opponentPlayerSetManager == null){
            throw new IllegalArgumentException("Opponent player GamesManager should not be null");
        }

        if(state != State.Playing){
            throw new UnsupportedOperationException("Cannot score on this state: " + state.getName());
        }

        GameScore currentPlayerScore = getCurrentSetScore();
        currentPlayerScore.increase(opponentPlayerSetManager.getCurrentSetScore());

        if(currentPlayerScore.isWinningScore()){
            setScore++;
            moveNextSet();
            opponentPlayerSetManager.moveNextSet();
        }
    }

    public int getSetScore() {
        return setScore;
    }

    public State getState() {
        return state;
    }

    public void end() throws UnsupportedOperationException{
        if(state != State.Playing){
            throw new UnsupportedOperationException("Cannot end game at this state: " + state.getName());
        }
        state = State.Finished;
    }

    public void moveNextSet() {
        scores.add(new GameScore());
    }
}
