package com.smahjoub.metic;

/**
 * The score manager class
 * @author smahjoub
 */
public class Score {

    private static final TennisScore WINNING_SCORE = TennisScore.Victory;
    private TennisScore currentScore;

    /**
     * Get a socre object with score set to 'Zero'
     */
    public Score(){
        currentScore = TennisScore.Zero;
    }

    /**
     * Increase the score
     */
    public void increase(){
        TennisScore newScore = null;
        switch (currentScore){
            case Zero:
                newScore = TennisScore.Fifteen;
                break;
            case Fifteen:
                newScore = TennisScore.Thirty;
                break;
            case Thirty:
                newScore = TennisScore.Forty;
                break;
            case Forty:
                newScore = TennisScore.Victory;
                break;
            case Victory:
                newScore = TennisScore.Victory;
                break;
        }

        currentScore = newScore;
    }

    /**
     * The current score
     * @return
     */
    public TennisScore getCurrentScore() {
        return currentScore;
    }

    /**
     * if the current score is winning score.
     * @return a boolean flag
     */
    public boolean isWinningScore() {
        return WINNING_SCORE == currentScore;
    }
}
