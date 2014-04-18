package org.adrian;

public interface Game {

    public abstract void frame(int roll1, int roll2);
    
    public void frame( int roll1, int roll2, int roll3);

    public abstract int score();

    public abstract void strike();

}