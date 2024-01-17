import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Shooting Sim",50);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 380, 1); 

        addObject(titleLabel, getWidth()/2, getHeight()/2);
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }
    }
    
    public void prepare()
    {
        Bob thebuilder = new Bob();
        addObject(thebuilder, 300,98);
        Label label = new Label("Press 'a' and 'd' to move", 40);
        addObject(label,295,265);
        Label label2 = new Label("Press 'space' to Start", 30);
        addObject(label2,299,328);
    }
}
