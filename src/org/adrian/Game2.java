package org.adrian;

public class Game2 implements Game {
    
    private int score = 0;
    private boolean lastFrameSpare;
    private boolean lastFrameStrike;
    
    public void frame(int roll1, int roll2) { 
        // Called for any non-strike
        // frames, except the 10th frame
        frame(roll1, roll2, 0);
    }

    public void frame(int roll1, int roll2, int roll3) { // Only called directly
                                                         // for 10th frame
        openFrameScore(roll1, roll2, roll3);
        spareBonus(roll1);
        strikeBonus(roll1, roll2);
        saveFrameState(roll1, roll2);
    }

    public void strike() {
        frame(10, 0, 0);
    }
    
    private void saveFrameState(int roll1, int roll2) {
        
        if (roll1 == 10) {
            lastFrameStrike = true;
        } else if (roll1 + roll2 == 10) {
            lastFrameSpare = true;
        }
    }

    private void strikeBonus(int roll1, int roll2) {
        if (lastFrameStrike) {
            score += roll1 + roll2;
            lastFrameStrike = false;

            if (roll1 == 10) {
                lastFrameSpare = true; // Abusing this flag to indicate a strike
                                       // which still needs another ball bonus
            }
        }
    }

    private void spareBonus(int roll1) {
        if (lastFrameSpare) {
            score += roll1;
            lastFrameSpare = false;
        }
    }

    private void openFrameScore(int roll1, int roll2, int roll3) {
        score += roll1 + roll2 + roll3;
    }

    public int score() {
        return score;
    }

}
