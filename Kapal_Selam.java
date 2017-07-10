import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ListIterator;
/**
 * Write a description of class Kapal_Selam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kapal_Selam extends Actor
{

    public void act() 
    {
        // Add your action code here.
        if (canFire())
        {
        droprocket();
    }   
    moveTowardsShark();
    }

    public void moveTowardsShark()
    {
        World w = getWorld();
        List <Shark> sharks = w.getObjects(Shark.class);
        ListIterator<Shark> iter = sharks.listIterator();
        if(!iter.hasNext())
        {
            return;
        }
        Shark enemy = iter.next();
        int eX = enemy.getX();
        int y = getY();
        int x = getX();
        int angle = getRotation();
        int distance = (int) (Math.random()*5)+1;
        if(x< eX)
        {
         if (angle == 180)
         {
             turn();
              
            }
           move(distance);
        }
        else if (x > eX)
        {
            if (angle ==0)
            {
                turn();
               
            }
             move(distance);
        }
    }
    
    public void turn()
    {
        GreenfootImage img = getImage();
        img.mirrorVertically();
        setImage(img);
        turn(180);
    }
    
    public boolean canFire()
    {
        int oneIn = (int) (Math.random()*100)+1;
        return oneIn <=1;
    }
    
    public void droprocket()
    {
       rocket r = new rocket();
       World w = getWorld();
       int x = getX();
       int y = getY() + getImage().getHeight()/2 + r.getImage().getHeight()/2 + 5;
       w.addObject(r,x,y);
    }
}
