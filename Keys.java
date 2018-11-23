import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Keys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Keys extends Tile
{
    //private GreenfootImage redKey = new GreenfootImage("hud_keyRed.png");
    public String color;
    public Keys(String image, int width, int height) {
        super(image, width, height);
        int begin = 3;
        int end = image.indexOf(".");
        color = image.substring(begin,end);
    }

    /**
     * Act - do whatever the Keys wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Hero.class)) {
            getWorld().removeObject(this);  
        }
    }

    public String getKeyColor() {
        return color;
    }
}
