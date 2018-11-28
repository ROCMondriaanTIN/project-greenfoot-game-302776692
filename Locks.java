import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Locks here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Locks extends Tile
{
    public Locks(String image, int width, int height) {
        super(image, width, height);
    }
    /**
     * Act - do whatever the Locks wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Hero.class)){
            if(Hero.redKeyCheck == true) {
                setImage("invisible.png");
                this.isSolid = false;                
            }
        }
    }    
}
