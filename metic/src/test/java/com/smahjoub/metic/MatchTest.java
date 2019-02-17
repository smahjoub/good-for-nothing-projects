package com.smahjoub.metic;

import org.junit.Test;
import java.util.Random;

import static junit.framework.TestCase.assertTrue;

public class MatchTest {


    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectPlayerParameters(){
        Match g1 = new Match();
        g1.setPlayers(null,
                new Player(2, "Pete Sampras"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectPlayerParameters2(){
        Match g1 = new Match();
        g1.setPlayers(new Player(2, "Pete Sampras"),
                new Player(2, "Pete Sampras"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void setIncorrectPlayerParameters3(){
        Match g1 = new Match();
        g1.setPlayers(null,
                null);
    }

    @Test
    public void startGameWithPlayersTest(){
        Match g1 = new Match();
        g1.setPlayers(new Player(1, "Roger Federer"),
                new Player(2, "Pete Sampras"));
        g1.start();
    }


    @Test(expected = UnsupportedOperationException.class)
    public void startGameWithoutPlayersTest(){
        Match g1 = new Match();
        g1.start();
    }


    @Test
    public void randomGamePlayTest(){
        Match g1 = new Match();

        assertTrue(g1.getState() == State.NotReady);
        Player[] players = new Player[] { new Player(1, "Roger Federer"),
                new Player(2, "Pete Sampras")};
        g1.setPlayers(players[0],  players[1]);

        assertTrue(g1.getState() == State.Ready);

        g1.start();

        assertTrue(g1.getState() == State.Playing);
        Random r = new Random();
        while (g1.getState() == State.Playing){
            g1.score(players[r.nextInt(1)]);
        }

        assertTrue(g1.getState() == State.Finished);
    }


    @Test
    public void guidedGamePlayTest(){
        Match g1 = new Match();

        assertTrue(g1.getState() == State.NotReady);
        Player[] players = new Player[] { new Player(1, "Roger Federer"),
                new Player(2, "Pete Sampras")};
        g1.setPlayers(players[0],  players[1]);

        assertTrue(g1.getState() == State.Ready);

        g1.start();

        assertTrue(g1.getState() == State.Playing);

        for (int i = 1; i <= 5; i++){
            g1.score(players[0]); // 15-0
            g1.score(players[0]); // 30-0
            g1.score(players[0]); // 40-0
            g1.score(players[0]); // Win 1 point
        }

        for (int i = 1; i <= 5; i++){
            g1.score(players[1]); // 15-0
            g1.score(players[1]); // 30-0
            g1.score(players[1]); // 40-0
            g1.score(players[1]); // Win 1 point
        }

        for (int i = 1; i <= 2; i++){
            g1.score(players[0]); // 15-0
            g1.score(players[0]); // 30-0
            g1.score(players[0]); // 40-0
            g1.score(players[0]); // Win 1 point
        }

        assertTrue(g1.getState() == State.Finished);

        assertTrue(g1.getWinner().equals(players[0]));
    }

}
