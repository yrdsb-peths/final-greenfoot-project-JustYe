import greenfoot.*;  

/**
 * Write a description of class Bob here."
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bob extends Actor
{
    /**
     * Act - do whatever the Bob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = new GreenfootImage("SQUARE.png");
    
    public Bob()
    {
       image.scale(image.getWidth() / 4, image.getHeight()/4); 
       setImage(image);
    }
    
    public void act()
    {
        checkKeys();
    }
    public void checkKeys()
    {
        if(Greenfoot.isKeyDown("a"))
        {
            move(-5);
        }
        else if(Greenfoot.isKeyDown("d"))
        {
            move(5);
        }
    }
}
