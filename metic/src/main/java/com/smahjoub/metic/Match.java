package com.smahjoub.metic;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to handle the actual tennis match
 * @author smahjoub
 */
public final class Match {

    private HashMap<Player, GamesManager> scoreboard;
    private State state;
    private Player winner;

    /**
     * Construct the match Object with empty score board and 'not ready' state.
     */
    public Match(){
        scoreboard = new HashMap<>();
        state = State.NotReady;
    }

    /**
     * Reset the match by deleting all players and set the match to 'not ready' state.
     */
    public void reset(){
        scoreboard.clear();
        winner = null;
        state = State.NotReady;
    }

    /**
     * Set the Match players
     * @param player1
     * @param player2
     * @throws IllegalArgumentException if one or two players are null or the two players are the same
     * @throws UnsupportedOperationException if the match is not on 'not ready' state
     */
    public void setPlayers(Player player1, Player player2)
        throws IllegalArgumentException, UnsupportedOperationException {

        if(player1 == null){
            throw new IllegalArgumentException("Player 1 should not be null");
        }

        if(player2 == null){
            throw new IllegalArgumentException("Player 2 should not be null");
        }

        if(player1.equals(player2)){
            throw new IllegalArgumentException("The match should have two different players");
        }

        if(state != State.NotReady){
            throw new UnsupportedOperationException("Cannot not change players on this state: " + state.getName());
        }
        winner = null;
        scoreboard.clear();
        scoreboard.put(player1, new GamesManager());
        scoreboard.put(player2, new GamesManager());

        state = State.Ready;

        scoreboard.get(player1).initialize();
        scoreboard.get(player2).initialize();
    }

    /**
     * Check if players are ready and start the match.
     * @throws UnsupportedOperationException if the match is not ready.
     */
    public void start()
        throws UnsupportedOperationException{

        if(state != State.Ready){
            throw new UnsupportedOperationException("Cannot start the match on this state: " + state.getName());
        }

        state = State.Playing;

        for (GamesManager psm : scoreboard.values()) {
            psm.start();
        }
    }

    /**
     * Increase the score for a given player
     * @param player the player who scored
     * @throws IllegalArgumentException if the given player does not belong to this match
     * @throws UnsupportedOperationException
     */
    public void score(Player player)
            throws IllegalArgumentException, UnsupportedOperationException {

        if(!scoreboard.containsKey(player)){
            throw new IllegalArgumentException("No such player in the match");
        }

        if(state != State.Playing){
            throw new UnsupportedOperationException("Cannot not change score on this match state:" + state.getName());
        }

        GamesManager opponentScoreManager = getOpponentSetManager(player);
        GamesManager setManager = scoreboard.get(player);
        setManager.score(opponentScoreManager);

        if(hasWon(setManager, opponentScoreManager)){
            setManager.end();
            opponentScoreManager.end();
            winner = player;
            state = State.Finished;
        }
    }

    private boolean hasWon(GamesManager playerSetManager, GamesManager opponentPlayerSetManager){
        boolean hasWon = false;

        hasWon |= playerSetManager.getSetScore() == 6 && opponentPlayerSetManager.getSetScore() <= 4;
        hasWon |= playerSetManager.getSetScore() == 7 && opponentPlayerSetManager.getSetScore() == 5;

        return hasWon;
    }

    private GamesManager getOpponentSetManager(Player player) {
        GamesManager returnValue = null;

        for (Map.Entry<Player, GamesManager> playerScore : scoreboard.entrySet()) {
            if (!player.equals(playerScore.getKey())) {
                returnValue = playerScore.getValue();
                break;
            }
        }

        return  returnValue;
    }

    /**
     * Get the match winner
     * @return a player instance
     * @throws UnsupportedOperationException if the match is not finished yet.
     */
    public Player getWinner()
        throws UnsupportedOperationException{
        if(state != State.Finished){
            throw new UnsupportedOperationException("Cannot get the match winner on this state :" + state.getName());
        }

        return winner;
    }

    /**
     * Get the match state
     * @return State value
     */
    public State getState() {
        return state;
    }
}
