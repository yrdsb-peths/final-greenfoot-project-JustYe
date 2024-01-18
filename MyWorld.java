import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    int score = 0;
    Label scoreLabel;
    public ScoreBoard scoreboard;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,380,1);
        
        Bob bob = new Bob();
        addObject(bob, 300, 354);
        
        scoreboard = new ScoreBoard();
        addObject(scoreboard, 80, 20);

        Monster squid = new Monster(scoreboard);
        addObject(squid, 300, 50);
    }
    
    public ScoreBoard getScoreboard() {
        return scoreboard;
    }
    
    public void checkTeleport()
    {
        Bob bob = (Bob) getObjects(Bob.class).get(0);

        int worldWidth = getWidth();
        int worldHeight = getHeight();

        if (bob.getX() <= 0)
        {
            bob.setLocation(worldWidth - 1, bob.getY());
        }
        else if (bob.getX() >= worldWidth-1)
        {
            bob.setLocation(1, bob.getY());
        }
    }
    
    public void act() {
        checkTeleport();
        
        if(Greenfoot.isKeyDown("r")){
            TitleScreen title = new TitleScreen();
            Greenfoot.setWorld(title);
        }
    }
    
    public void displayWinLabel() {
        Label winLabel = new Label("You Win!", 60);
        addObject(winLabel, getWidth() / 2, getHeight() / 2);
        Label gameOverLabel = new Label("R to replay", 60);
        addObject(gameOverLabel,300, 320);
    }

    public void gameOver(){
        Label gameOverLabel = new Label("Game Over (R to reset)", 60);
        addObject(gameOverLabel, 300, 200);
        removeObjects(getObjects(Bullet.class));
        
        scoreboard.score = 0;
        scoreboard.updateImage();
    }   
    
    public void removeMonster() {
        List<Monster> monsters = getObjects(Monster.class);
        for (Monster monster : monsters) {
            removeObject(monster);
        }
    }
}
