import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class ScoreBoard extends Actor
{
    int score;
    public SimpleTimer timer;
    
    public ScoreBoard()
    {    
        score = 0;
        timer = new SimpleTimer();
        timer.mark();
        updateImage();
    }
    
    public void act()
    {
        updateScore();
    }
    public void addToScore(int points)
    {
        score += points;
        updateImage();
    }

    public void decrementScore(int points)
    {
        score -= points;
        updateImage();
    }

    public void updateScore()
    {
        if (timer.millisElapsed() > 1000) {
            addToScore(1); 
            timer.mark();
        }

        if (score < 0) {
            MyWorld myWorldInstance = (MyWorld) getWorld();
            if (myWorldInstance != null) {
            myWorldInstance.gameOver();
            }
        }
    }
    
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage("Score: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
