import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class ScoreBoard extends Actor
{
    int score;
    public SimpleTimer timer;
    public boolean gameOver;
    public ScoreBoard()
    {    
        score = 10;
        timer = new SimpleTimer();
        timer.mark();
        updateImage();
        gameOver = false;
    }
    
    public void act()
    {
        updateScore();
    }
    public void addToScore(int points)
    {
        if (!gameOver) {
            score += points;
            updateImage();
        }
    }

    public void decrementScore(int points)
    {
        if (!gameOver) {
            score -= points;
            updateImage();
        }
    }

    public void updateScore()
    {
        if (timer.millisElapsed() > 1000) {
            addToScore(3); 
            timer.mark();
        }

        if (score < 0) {
            MyWorld myWorldInstance = (MyWorld) getWorld();
            if (myWorldInstance != null) {
                myWorldInstance.gameOver();
                gameOver = true;
            }
        }
        
        if(score >= 100) {
            MyWorld myWorldInstance = (MyWorld) getWorld();
            if (myWorldInstance != null) {
                myWorldInstance.displayWinLabel();
                gameOver = true;
            }
        }
    }
    
    public void updateImage()
    {
        GreenfootImage image = new GreenfootImage("Score: " + score, 24, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(image);
    }
}
