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
    double a = 0.5;
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
        else if(Greenfoot.isKeyDown("w"))
        {
            jump();
        }
    }
    public void jump()
    {
        for(int i = 0; i < 50; i++)
        {
            setLocation(getX(),getY()-1);
            
        }
        for(int i = 0; i < 50; i++)
        {
            setLocation(getX(),getY()+1);
            
        }
    }
}
