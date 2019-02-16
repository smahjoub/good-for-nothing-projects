package com.smahjoub.metic;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ScoreTest {

    @Test
    public void testIncreaseScore(){
        Score s1 = new Score();
        Score s2 = new Score();

        assertTrue(s1.getCurrentScore() == TennisScore.Zero);
        assertTrue(!s1.isWinningScore());

        s1.increase(s2);

        assertTrue(s1.getCurrentScore() == TennisScore.Fifteen);
        assertTrue(!s1.isWinningScore());

        s1.increase(s2);

        assertTrue(s1.getCurrentScore() == TennisScore.Thirty);
        assertTrue(!s1.isWinningScore());

        s1.increase(s2);

        assertTrue(s1.getCurrentScore() == TennisScore.Forty);
        assertTrue(!s1.isWinningScore());

        s2.increase(s1);
        s2.increase(s1);
        s2.increase(s1);

        s1.increase(s2);

        assertTrue(s1.getCurrentScore() == TennisScore.Advantage);
        assertTrue(!s1.isWinningScore());

        s2.increase(s1);

        assertTrue(s1.getCurrentScore() == TennisScore.Forty);
        assertTrue(!s1.isWinningScore());

        s1.increase(s2);

        assertTrue(s1.getCurrentScore() == TennisScore.Advantage);
        assertTrue(!s1.isWinningScore());

        s1.increase(s2);

        assertTrue(s1.getCurrentScore() == TennisScore.Victory);
        assertTrue(s1.isWinningScore());
    }
}
