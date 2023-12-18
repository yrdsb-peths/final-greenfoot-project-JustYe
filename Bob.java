import greenfoot.*;  

/**
 * Write a description of class Bob here.
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
    GreenfootImage[] idleRight = new GreenfootImage[7];
    GreenfootImage[] idleLeft = new GreenfootImage[7];
    String facing = "left";
    SimpleTimer animationTimer = new SimpleTimer();
    
    public Bob()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/TheHammer/hammercharge" + i + ".png");
            idleRight[i].mirrorHorizontally();
            idleRight[i].scale(300,300);
        }
        
        for(int i = 0; i < idleLeft.length; i++)
        {
           idleLeft[i] = new GreenfootImage("images/TheHammer/hammercharge" + i + ".png");
           idleLeft[i].scale(300,300); 
        }
        
        animationTimer.mark();
    }
    
    public void act()
    {
        checkKeys();
        animateBob();
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
    public void animateBob()
    {
        int imageIndex = 0;
        if(animationTimer.millisElapsed() < 400)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("left"))
        {
            if(!Greenfoot.isKeyDown("a"))
            {
                setImage(idleRight[0]);
                return;
            }
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
        else if(facing.equals("right"))
        {
            if(!Greenfoot.isKeyDown("d"))
            {
                setImage(idleRight[0]);
                return;
            }
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
    }
}
