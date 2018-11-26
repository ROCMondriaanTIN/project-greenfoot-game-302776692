import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerups extends Tile
{
    public String colorPowerup;
    public Powerups(String image, int width, int height) {
        super(image, width, height);
        int begin = 3;
        int end = image.indexOf(".");
        colorPowerup = image.substring(begin,end);
    }
    /**
     * Act - do whatever the Powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);  
        }
    } 
    
    public String getPowerupColor() {
        return colorPowerup;
    }
}
