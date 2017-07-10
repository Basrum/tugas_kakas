import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class rocket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rocket extends Actor implements Killabel
{
    /**
     * Act - do whatever the rocket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int distance = 1;
        World w = getWorld();
        if (canMove(distance))
        { if (collides())
            {
                destroy();
            }
            move(distance);
           
        }
        else
        {
           w.removeObject(this); 
        }
        
    } 
    
    public boolean collides()
    {
        Actor a = getOneIntersectingObject(Killabel.class);
        return a != null;
    }
    
    public void destroy()
    {
      List<Killabel> list = getIntersectingObjects(Killabel.class);
       int size = list.size();
       for (int n = 0; n < size ; n++)
       {
           list.get(n).die();
        }
    }
    
    public boolean canMove(int distance)
    {
      int y = getY();
      World  w = getWorld();
      return y+ distance < w.getHeight();
    }
    
    public void move (int distance)
    {
        //rocket gerak ke bawah 
        int x = getX();
        int y = getY();
        
        setLocation(x,y+distance);
    }
    public void die()
    {
        getWorld().removeObject(this);
    }
}