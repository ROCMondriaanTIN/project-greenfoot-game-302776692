import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Powerup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Powerup extends Tile
{
    
    private GreenfootImage blueGem = new GreenfootImage("gemBlue.png");
    
    public Powerup(String image, int width, int height) {
        super(image, width, height);
    }
    /**
     * Act - do whatever the Powerup wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        blueGem = getImage();
        if(isTouching(Hero.class)){
            if (getImage() == blueGem){
                Hero.bonusVelocityY = -2;
            }
            getWorld().removeObject(this);
        }
    }    
}
