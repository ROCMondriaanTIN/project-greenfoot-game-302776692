import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Tile
{
    public static boolean door1;

    public static final GreenfootImage openImage = new GreenfootImage("door_openMid.png");
    public Buttons(String image, int width, int height) {
        super(image, width, height);
    }

    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        isTouchingButton();
    }   

    public void isTouchingButton() {
        if(isTouching(Hero.class)) {
            if(getColom() == 33 && getRow() == 20){               
                Hero.tileEngine.removeTileAt(21, 42); 
            } else if(getColom() == 33 && getRow() == 31) {
                Hero.tileEngine.removeTileAt(21, 42); 
            }
            setImage("buttonRed_pressed.png");
        } 
    }
}
