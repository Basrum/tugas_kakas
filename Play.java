import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Play extends Button
{

    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.playSound("SoundA.mp3");
            Greenfoot.setWorld(new Background());
        }
    }    
}
