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
    
    boolean real;
    double y = 0;
    boolean onGround = true;
    int cycles; 
    boolean keynotpressed; 
    boolean jumpdelay;
    SimpleTimer jumpTimer = new SimpleTimer();
    
    public Bob()
    {
       image.scale(image.getWidth() / 4, image.getHeight()/4); 
       setImage(image);
       this.real = real;
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
