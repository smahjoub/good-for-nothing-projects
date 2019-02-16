package com.smahjoub.metic;

import org.junit.Test;

import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class GameTest {


    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectPlayerParameters(){
        Game g1 = new Game();
        g1.setPlayers(null,
                new Player(2, "Pete Sampras"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectPlayerParameters2(){
        Game g1 = new Game();
        g1.setPlayers(new Player(2, "Pete Sampras"),
                new Player(2, "Pete Sampras"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectPlayerParameters3(){
        Game g1 = new Game();
        g1.setPlayers(null,
                null);
    }

    @Test
    public void startGameWithPlayersTest(){
        Game g1 = new Game();
        g1.setPlayers(new Player(1, "Roger Federer"),
                new Player(2, "Pete Sampras"));
        g1.start();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void startGameWithoutPlayersTest(){
        Game g1 = new Game();
        g1.start();
    }


    @Test
    public void randomGamePlayTest(){
        Game g1 = new Game();

        assertTrue(g1.getState() == GameState.NotReady);
        Player[] players = new Player[] { new Player(1, "Roger Federer"),
                new Player(2, "Pete Sampras")};
        g1.setPlayers(players[0],  players[1]);

        assertTrue(g1.getState() == GameState.Ready);

        g1.start();

        assertTrue(g1.getState() == GameState.Playing);
        Random r = new Random();
        while (g1.getState() == GameState.Playing){
            g1.score(players[r.nextInt(1)]);
        }

        assertTrue(g1.getState() == GameState.Finished);
    }

    @Test
    public void guidedGamePlayTest(){
        Game g1 = new Game();

        assertTrue(g1.getState() == GameState.NotReady);
        Player[] players = new Player[] { new Player(1, "Roger Federer"),
                new Player(2, "Pete Sampras")};
        g1.setPlayers(players[0],  players[1]);

        assertTrue(g1.getState() == GameState.Ready);

        g1.start();
        assertTrue(g1.getState() == GameState.Playing);

        g1.score(players[0]); // Player 1: 15, Player 2: 0
        assertTrue(g1.getState() == GameState.Playing);
        g1.score(players[0]); // Player 1: 30, Player 2: 0
        assertTrue(g1.getState() == GameState.Playing);
        g1.score(players[0]); // Player 1: 40, Player 2: 0
        assertTrue(g1.getState() == GameState.Playing);
        g1.score(players[1]); // Player 1: 40, Player 2: 15
        assertTrue(g1.getState() == GameState.Playing);
        g1.score(players[0]); // Player 1: Victory, Player 2: 15
        assertTrue(g1.getState() == GameState.Finished);

        assertTrue(g1.getWinner().equals(players[0]));

    }



}
