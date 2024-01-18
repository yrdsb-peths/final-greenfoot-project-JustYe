import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Actor
{
    /**
     * Act - do whatever the Monster wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 2;
    GifImage monsterGif;
    public SimpleTimer shootTimer;
    public ScoreBoard scoreboard;
    
    public Monster(ScoreBoard scoreboard)
    {
        monsterGif = new GifImage("monster.gif");
        shootTimer = new SimpleTimer();
        GreenfootImage image = monsterGif.getCurrentImage();
        setImage(image);
        this.scoreboard = scoreboard;
    }
    
    public void act() 
    {
        hover();
        shoot();
        updateAnimation();
    }

    public void hover()
    {
        if (Greenfoot.getRandomNumber(100) < 3) {
            speed *= -1; 
        }

        setLocation(getX() + speed, getY());

        if (getX() <= 0 || getX() >= getWorld().getWidth()) {
            speed *= -1;
        }
    }
    public void shoot()
    {
        int gatlingGunFrequency = 150;
        int bulletSpeed = 12;
        
        if (!scoreboard.gameOver && shootTimer.millisElapsed() > gatlingGunFrequency) {
            if (shootTimer.millisElapsed() > gatlingGunFrequency) {
                Bob bob = (Bob) getWorld().getObjects(Bob.class).get(0);
                if (bob != null) {
                    double angle = Math.atan2(bob.getY() - getY(), bob.getX() - getX());
                    int xVelocity = (int) (bulletSpeed * Math.cos(angle));
                    int yVelocity = (int) (bulletSpeed * Math.sin(angle));
    
                    getWorld().addObject(new Bullet(xVelocity, yVelocity), getX(), getY());
                    shootTimer.mark();
                }
            }
        }
    }
    public void updateAnimation()
    {
        GreenfootImage image = monsterGif.getCurrentImage();
        setImage(image);
    }
}
