package com.smahjoub.metic;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ScoreTest {

    @Test
    public void testIncreaseScore(){
        Score s1 = new Score();

        assertTrue(s1.getCurrentScore() == TennisScore.Zero);
        assertTrue(!s1.isWinningScore());

        s1.increase();

        assertTrue(s1.getCurrentScore() == TennisScore.Fifteen);
        assertTrue(!s1.isWinningScore());

        s1.increase();

        assertTrue(s1.getCurrentScore() == TennisScore.Thirty);
        assertTrue(!s1.isWinningScore());

        s1.increase();

        assertTrue(s1.getCurrentScore() == TennisScore.Forty);
        assertTrue(!s1.isWinningScore());

        s1.increase();

        assertTrue(s1.getCurrentScore() == TennisScore.Victory);
        assertTrue(s1.isWinningScore());

        s1.increase();

        assertTrue(s1.getCurrentScore() == TennisScore.Victory);
        assertTrue(s1.isWinningScore());
    }
}
