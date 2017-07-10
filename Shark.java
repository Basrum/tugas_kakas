import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Actor implements Killabel
{
    private  static final int KEY_MOVE = 5;
    public static int fishCount_;
    
    public Shark()
    {
        super();
        fishCount_=0;
    }
    public void act() 
    {
        // Add your action code he
          int nX = nextX();
          int nY = nextY();
          
          if(nX!=getX() || nY!=getY())
          {
          turnTowards(nX,nY);
          setLocation(nX,nY);
          
          if (foundfish())
          {
              eatfish();
            }
        }
    } 
    public int nextX()
    {
        int x = getX();
        int dx = 0 ;
        if (Greenfoot.isKeyDown("left"))
        {
            dx = -KEY_MOVE;
        }
        else if (Greenfoot.isKeyDown("right"))
        {
            dx = KEY_MOVE;
        }
        return x + dx;
    }
    
      public int nextY()
    {
        int y = getY();
        int dy = 0 ;
        if (Greenfoot.isKeyDown("up"))
        {
            dy = -KEY_MOVE;
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            dy = KEY_MOVE;
        }
        return y + dy;
    }
   
    
    public boolean foundfish()
    {
        Actor a = getOneIntersectingObject(fish.class);
        return a != null;
    }
    
    public void eatfish()
    {
        Actor a = getOneIntersectingObject(fish.class);
        World w = getWorld();
        w.removeObject(a);
        fishCount_++;
    }
        
    public int getfishCount()
    {
        return fishCount_;
    }
    public void die()
    {
        getWorld().removeObject(this);

    }
}
