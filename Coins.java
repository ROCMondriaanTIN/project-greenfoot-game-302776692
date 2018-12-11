import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coins extends Tile
{
    
    public Coins(String image, int width, int height) {
        super(image, width, height);
    }
    /**
     * Act - do whatever the Coins wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        setImage("coinGold.png");
        if(isTouching(Hero.class)){
            getWorld().removeObject(this);
            Hero.score += 10;
            Hero.coins += 1;
        }
        
    }    
}
