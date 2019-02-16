package com.smahjoub.metic;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to handle the actual tennis game
 * @author smahjoub
 */
public final class Game {

    private HashMap<Player, Score> scoreboard;
    private GameState state;

    /**
     * Construct the game Object with empty score board and 'not ready' state.
     */
    public Game(){
        scoreboard = new HashMap<>();
        state = GameState.NotReady;
    }

    /**
     * Reset the game by deleting all players and set the game to 'not ready' state.
     */
    public void reset(){
        scoreboard.clear();
        state = GameState.NotReady;
    }

    /**
     * Set the Game players
     * @param player1
     * @param player2
     * @throws IllegalArgumentException if one or two players are null or the two players are the same
     * @throws UnsupportedOperationException if the game is not on 'not ready' state
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
            throw new IllegalArgumentException("The game should have two different players");
        }

        if(state != GameState.NotReady){
            throw new UnsupportedOperationException("Cannot not change players on this state: " + state.getState());
        }

        scoreboard.clear();
        scoreboard.put(player1, new Score());
        scoreboard.put(player2, new Score());

        state = GameState.Ready;
    }

    /**
     * Check if players are ready and start the game.
     * @throws UnsupportedOperationException if the game is not ready.
     */
    public void start()
        throws UnsupportedOperationException{

        if(state != GameState.Ready){
            throw new UnsupportedOperationException("Cannot start the game on this state: " + state.getState());
        }

        state = GameState.Playing;
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
            throw new IllegalArgumentException("No such player in the game");
        }

        if(state != GameState.Playing){
            throw new UnsupportedOperationException("Cannot not change score on this game state:" + state.getState());
        }

        Player opponent = getOpponent(player);

        Score currentPlayerScore = scoreboard.get(player);
        currentPlayerScore.increase(scoreboard.get(opponent));

        if(currentPlayerScore.isWinningScore()){
            state = GameState.Finished;
        }
    }

    private Player getOpponent(Player player) {
        Player returnValue = null;

        for (Player p : scoreboard.keySet()) {
            if (!player.equals(p)) {
                returnValue = p;
                break;
            }
        }

        return  returnValue;
    }

    /**
     * Get the game winner
     * @return a player instance
     * @throws UnsupportedOperationException if the game is not finished yet.
     */
    public Player getWinner()
        throws UnsupportedOperationException{
        if(state != GameState.Finished){
            throw new UnsupportedOperationException("Cannot get the game winner on this state :" + state.getState());
        }

        Player winner = null;
        for (Map.Entry<Player, Score> playerScore : scoreboard.entrySet()) {
            if (playerScore.getValue().isWinningScore()) {
                winner = playerScore.getKey();
            }
        }

        return winner;
    }

    /**
     * Get the game state
     * @return GameState value
     */
    public GameState getState() {
        return state;
    }
}
