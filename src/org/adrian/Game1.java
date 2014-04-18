package org.adrian;

public class Game1 implements Game {

	private int score = 0;
	private boolean lastFrameSpare;
	private boolean lastFrameStrike;
	
	/* (non-Javadoc)
     * @see org.adrian.Game#frame(int, int)
     */
	@Override
    public void frame(int roll1, int roll2) {
		score += roll1 + roll2;

		if (lastFrameSpare) {
			score += roll1;
		}
		
		if (lastFrameStrike) {
			score += roll1 + roll2;
		}

		lastFrameStrike = false;
		lastFrameSpare = (roll1 + roll2 == 10);

	}


	/* (non-Javadoc)
     * @see org.adrian.Game#score()
     */
	@Override
    public int score() {
		return score;
	}

	/* (non-Javadoc)
     * @see org.adrian.Game#strike()
     */
	@Override
    public void strike() {
	    
		score += 10;
		
		if (lastFrameStrike) {
			score += 10;
			lastFrameSpare = true;
		}
		
		lastFrameStrike = true;
		
	}


    @Override
    public void frame(int roll1, int roll2, int roll3) {
        frame(roll1, roll2);
        score += roll3;
        
    }

}
