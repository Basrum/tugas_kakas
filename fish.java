import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fish here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fish extends Actor implements Killabel
{
    private int moves;
    private int dy;
    private int dx;
    private static final int THRESHOLD = 1000;
    
    public fish()
    {
        super();
        moves = 0;
        dy = (int) (Math.random()*3)-1;
        dx = 1;
    }
    
    public void act() 
    {
        // Add your action code here.
        World w = getWorld();
       
        if(canMOve(dx,dy))
        {
            move(dx,dy);
            moves++;
            if(moves>THRESHOLD)
            {
                moves = 0;
                dy = (int) (Math.random ()*3)-1;
            }
        }
        else
        {
            dx *= -1;
         turn(180);
         getImage().mirrorVertically();
        }
    }    
    
    public boolean canMOve(int dx, int dy)
    {
        int x = getX();
        int y = getY();
        World w = getWorld(); 
        return (x+dx>=0) && (x+dx<w.getWidth()) && (y+dy<w.getHeight()) && (y+dy>=0);
    }
    
    public void move (int dx, int dy)
    {
        int x = getX();
        int y = getY();
        
        setLocation(x+dx, y+dy);
    }
    
    public void die()
    { 
        Background b = (Background)getWorld();
        double distance = 150;
        Location safe = b.getSafefishLocation(distance);
        setLocation(safe.getX(), safe.getY());
    }
}
