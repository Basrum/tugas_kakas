import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
   public Label(int w, int h)
   {
       GreenfootImage img = new GreenfootImage(w,h);
       setImage(img);
    }
    
    public void setText(String text)
    {
        GreenfootImage img = getImage();
        img.clear();
        img.drawString(text,0,img.getHeight());
        
    }
    
    public void setColor(Color c)
    {
        GreenfootImage img = getImage();
        img.setColor(c);
    }
    
    public void setFontStyle(int style)
    {
        GreenfootImage img = getImage();
        Font oldFont = img.getFont();
        Font newFont = new Font (oldFont.getFontName(),style, oldFont.getSize());
        img.setFont(newFont);
    }
    
     public void setFontFace(String face)
    {
        GreenfootImage img = getImage();
        Font oldFont = img.getFont();
        Font newFont = new Font (face, oldFont.getStyle(), oldFont.getSize());
        img.setFont(newFont);
    }
        
      
     public void setFontsize(int size)
    {
        GreenfootImage img = getImage();
        Font oldFont = img.getFont();
        Font newFont = new Font (oldFont.getFontName(), oldFont.getStyle(),size);
        img.setFont(newFont);
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
