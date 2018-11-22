import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Keys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Keys extends Tile
{
    private GreenfootImage redKey = new GreenfootImage("hud_keyRed.png");
    public Keys(String image, int width, int height) {
        super(image, width, height);
    }
    /**
     * Act - do whatever the Keys wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Hero.class)) {
            if(getImage() == redKey) {
                getWorld().removeObject(this);  
                Hero.redKeyCheck = true;
            }
        }
    }    
}
