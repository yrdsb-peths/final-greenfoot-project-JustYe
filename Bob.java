import greenfoot.*;  

/**
 * Write a description of class Bob here."
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bob extends Actor
{
    GreenfootSound bulletDmg = new GreenfootSound("dmg.mp3");
    /**
     * Act - do whatever the Bob wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];
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
        for(int i = 0; i < idleRight.length; i++){
            idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i  + ".png");
        }
        for(int i = 0; i < idleLeft.length; i++){
            idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i  + ".png");
            idleLeft[i].mirrorHorizontally();
        }
        animationTimer.mark();
    }
    int imageIndex = 0;
    public void animateBob() {
        if(animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark();
        if(facing.equals("right")){
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else{
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
    }
    
    public void act() 
    {
        int moveVelocity = 4;
        if(Greenfoot.isKeyDown("shift")){
            moveVelocity *= 2;
        }
        if(Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")){
            move(-moveVelocity);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")){
            move(moveVelocity);
            facing = "right";
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
        
        hitBullet();   
        animateBob();
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
    
    public void hitBullet() {
        Bullet bullet = (Bullet) getOneIntersectingObject(Bullet.class);
        if (bullet != null) {
            MyWorld world = (MyWorld) getWorld();
            world.getScoreboard().decrementScore(5);
            getWorld().removeObject(bullet);
            bulletDmg.play();
        }
    }
}
