import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    int score = 0;
    Label scoreLabel;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,380,1);
        
        Bob bob = new Bob();
        addObject(bob, 300, 354);
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel,50,50);
    }
    
    public void checkTeleport()
    {
        Bob bob = (Bob) getObjects(Bob.class).get(0);

        int worldWidth = getWidth();
        int worldHeight = getHeight();

        if (bob.getX() <= 0)
        {
            bob.setLocation(worldWidth - 1, bob.getY());
        }
        else if (bob.getX() >= worldWidth-1)
        {
            bob.setLocation(1, bob.getY());
        }
    }
    
    public void act() {
        checkTeleport();
    }
}
