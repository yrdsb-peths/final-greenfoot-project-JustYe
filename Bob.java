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
    GreenfootImage image = new GreenfootImage("idle1.png");
    
    GreenfootImage[] idleRight = new GreenfootImage[5];
    GreenfootImage[] idleLeft = new GreenfootImage[5];
    
    String facing = "right";
    SimpleTimer animationTimer = new SimpleTimer();
    
    boolean real;
    double y = 0;
    boolean onGround = true;
    int cycles; 
    boolean keynotpressed; 
    boolean jumpdelay;
    SimpleTimer jumpTimer = new SimpleTimer();
    
    public Bob()
    {
        for(int i = 1; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/mario/idle" + i + ".png");
            idleRight[i].scale(50,50);
        }
        
        for(int i = 1; i < idleLeft.length; i++)
        {
           idleLeft[i] = new GreenfootImage("images/mario/idle" + i + ".png");
           idleLeft[i].mirrorHorizontally();
           idleLeft[i].scale(50,50); 
        }
        
        animationTimer.mark();
        setImage(idleRight[0]);
    }

    public void act() 
    {
        int moveVelocity = 4;
        if(Greenfoot.isKeyDown("shift")){
            moveVelocity *= 2;
        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            move(-moveVelocity);
        }
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            move(moveVelocity);
        }
        jump();
        if (this.real) {
            y += 0.4;
            setLocation(getX(), (int) ((double) getY() + y));
            if (getY() > 354) {
                setLocation(getX(), 354);
                this.onGround = true;
            }
        }
    }
    int imageIndex = 0;
    public void animateBob()
    {
        if(animationTimer.millisElapsed() < 180)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            if(!Greenfoot.isKeyDown("d"))
            {
                setImage(idleRight[0]);
                return;
            }
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else if(facing.equals("left"))
        {
            if(!Greenfoot.isKeyDown("a"))
            {
                setImage(idleRight[0]);
                return;
            }
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void jump(){
        if(Greenfoot.isKeyDown("w") && !keynotpressed && !jumpdelay){
            setLocation(getX(), getY() - 10);
            cycles += 10;  
            if(cycles >= 120){ 
            keynotpressed = true;
            }
        }
        
        if(!Greenfoot.isKeyDown("w") && cycles > 0){
            keynotpressed = true;
        }

        if(getY() < 354 && cycles != 0 && (keynotpressed || !Greenfoot.isKeyDown("w"))){
            setLocation(getX(), getY() + 5);
            cycles -= 5;
            if(cycles <= 0){
                keynotpressed = false;
                jumpdelay = true;
                jumpTimer.mark();
            }
        }
        if(jumpTimer.millisElapsed() > 200){
        jumpdelay = false;
        }
    }
}
