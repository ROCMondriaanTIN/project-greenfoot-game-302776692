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
            if(getColom() == 32 && getRow() == 44) {
            if(Hero.redKeyCheck == true) {
                Hero.tileEngine.removeTileAt(32, 44);               
            }
        } else if(getColom() == 46 && getRow() == 44) {
            if(Hero.blueKeyCheck == true) {
                Hero.tileEngine.addTileAt(32, 44); 
            }
        }
        }
    }    
}
