import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireballs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireballs extends Tile
{
    public Fireballs(String image, int width, int heigth){
        super(image, width, heigth);
    }
    /**
     * Act - do whatever the Fireballs wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        turn(5);
    }    
}
