package com.smahjoub.metic;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class SetScoreTest {

    @Test
    public void testIncreaseSetScore(){
        SetScore s1 = new SetScore();
        SetScore s2 = new SetScore();

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
