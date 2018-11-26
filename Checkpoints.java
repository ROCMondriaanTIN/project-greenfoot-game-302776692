
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class checkpoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoints extends Tile
{
    public Checkpoints(String image, int width, int height) {
        super(image, width, height);
    }
    public static int checkpointX;
    public static int checkpointY; 
    
    /**
     * Act - do whatever the checkpoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {        
        for (Actor flag : getIntersectingObjects(Hero.class)) {
            if (flag != null) {
                setImage("flagGreen2.png");               
                break;
            }
        }        
    }        
}
