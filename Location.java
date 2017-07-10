/**
 * Write a description of class Location here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Location  
{
    // instance variables - replace the example below with your own
    private int x_;
    private int y_;
    /**
     * Constructor for objects of class Location
     */
    public Location(int x, int y)
    {
        x_ = x;
        y_ = y;
    }
    public int getX()
    {
        return x_;
    }
    public int getY()
    {
        return y_;
    }
    public void setX(int x)
    {
        x_ = x;
    }
    public void setY(int y)
    {
        y_ = y;
    }
}
