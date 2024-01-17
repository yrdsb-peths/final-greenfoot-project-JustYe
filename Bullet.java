import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int xVelocity;
    private int yVelocity;

    public Bullet(int xVelocity, int yVelocity)
    {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        
        GreenfootImage image = new GreenfootImage("Bullet.png");
        setImage(image);
    }

    public void act() 
    {
        move();
        checkCollision();
    }

    public void move()
    {
        setLocation(getX() + xVelocity, getY() + yVelocity);
    }

    public void checkCollision()
    {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
