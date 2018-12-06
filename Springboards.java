import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Springboards here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Springboards extends Tile
{
    public static int springboardVelocity = -5;
    public Springboards(String image, int width, int height) {
        super(image, width, height);
    }
    /**
     * Act - do whatever the Springboards wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Hero.class)){
            setImage("springboardDown.png");
            //System.out.println("is touching");
        } else {
            setImage("springboardUp.png");
            //System.out.println("is not touching");
        }
    }    
}
