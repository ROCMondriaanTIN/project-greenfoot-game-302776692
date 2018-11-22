import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buttons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buttons extends Tile
{
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
            setImage("buttonRed_pressed.png");
        } 
    }
}
