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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000,500,1);
        
        Bob bob = new Bob();
        addObject(bob, 500, 474);
    }
    
    public void checkTeleport()
    {
        Bob bob = (Bob) getObjects(Bob.class).get(image);

        int worldWidth = getWidth();
        int worldHeight = getHeight();

        if (bob.getX() <= 0)
        {
            bob.setLocation(worldWidth - 1, bob.getY());
        }
        else if (bob.getX() >= worldWidth)
        {
            bob.setLocation(1, bob.getY());
        }
        
        if (bob.getY() <= 0)
        {
            bob.setLocation(bob.getX(), worldHeight - 1);
        }
        else if (bob.getY() >= worldHeight)
        {
            bob.setLocation(bob.getX(), 1);
        }
    }
    
    public void act() {
        checkTeleport();
    }
}
