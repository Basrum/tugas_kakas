import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class Background extends World
{
    private Label score_;
    private Shark player_;
    private int fish_;
    private int speed_;
    /**
     * 
     */
    public Background()
    {
        super(900, 600, 1);
        fish_=0;
        setSpeed (50);
    
        
        Kapal_Selam s = new Kapal_Selam ();
        addObject(s, 450, s.getImage().getHeight()/2);
        player_ = new Shark();
        addObject(player_,450,250);
  
        
        score_= new Label(100,30);
        score_.setFontsize(24);
        score_.setText("Score : 0");
        int scoreX = getWidth() - score_.getImage().getWidth()/2-5;
        int scoreY = score_.getImage().getHeight()/2+5;
        addObject(score_, scoreX, scoreY);
        
       populate(10);
    }

        
    public void act()
    {
        score_.setText("Score: " + player_.getfishCount());
     if(player_.getWorld() == null)
        {
        Label gameOver = new Label (400,100);
        gameOver.setColor(Color.RED);
        gameOver.setFontsize(48);
        gameOver.setText("Game Over");
        addObject(gameOver, getWidth()/2, getHeight()/2);
        MyWorld.music.stop();
        Greenfoot.stop();
        
    }
    if (player_.getfishCount() == maxScore())
    {
          Label nextLevel = new Label (400,100);
        nextLevel.setColor(Color.RED);
        nextLevel.setFontsize(48);
        nextLevel.setText("Next Level");
        addObject(nextLevel, getWidth()/2, getHeight()/2);
        Greenfoot.delay(100);
        removeObject(nextLevel);
        populate(fish_ + 5);
        int nextSpd = speed_ + 2;
       setSpeed(nextSpd);
       
       Leve1 next = new Leve1();
       Greenfoot.setWorld(next);
       
 
    }
 else if (player_.getfishCount() == maxScore()+20)
    {
          Label nextLevel = new Label (400,100);
        nextLevel.setColor(Color.RED);
        nextLevel.setFontsize(48);
        nextLevel.setText("Next Level");
        addObject(nextLevel, getWidth()/2, getHeight()/2);
        Greenfoot.delay(100);
      removeObject(nextLevel);
        populate(fish_ + 5);
        int nextSpd = speed_ + 2;
       setSpeed(nextSpd);
       
       Leve2 next = new Leve2();
       Greenfoot.setWorld(next);
 
    }
    
}
   public Location getSafefishLocation(double distance)
    {
        int playerX = player_.getX();
        int playerY = player_.getY();
        int randX = (int) (Math.random()*701)+100;
        int randY = (int) (Math.random ()*301)+100;
        double howFar = Math.sqrt (Math.pow(playerX-randX,5)+ Math.pow(playerY-randY,5));
        while(howFar<distance)
        {
            randX = (int) (Math.random()*701)+100;
            randY = (int) (Math.random()*301)+100;
            howFar = Math.sqrt(Math.pow(playerX-randX,5)+Math.pow(playerY-randY,5));
        }
        return new Location(randX,randY);
    }
    public void populate(int fish)
    {
     int fishCount = 10;
       for ( int fishAdded = 0; fishAdded < fish; fishAdded++)
        {
           fish f = new fish();
           double distance = player_.getImage().getWidth()*1.5;
           Location safe = getSafefishLocation(distance);
           addObject(f,safe.getX(), safe.getY());
        }
        fish_+= fish;
    }
    public int maxScore()
    {
        return fish_;
        
    }
   
    public void setSpeed (int speed)
    {
       
        if(speed> 100)
            speed = 100;
       else if (speed <1)
       speed_ = 1;
       else
        speed_ = speed;
        Greenfoot.setSpeed(speed_);
    }
    public int getSpeed()
    {
    return speed_;
    }
    
        
}
