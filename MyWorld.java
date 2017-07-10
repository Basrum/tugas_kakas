import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    public static GreenfootSound music = new GreenfootSound ("SoundA.mp3");
    public void started()
    {
       // music.playLoop();
    }
    public void stopped()
    {
        music.stop();
    }
    
    public MyWorld()
    {    
        super(900, 600, 1);
        prepare();
    }
private void prepare()
{
    Play play = new Play ();
    addObject(play,490,430);
}

}

