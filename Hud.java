import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hud extends Actor
{
    public Hud() {
        super();
    }
     
    public void addKey(GreenfootImage image, int width, int heigth) {
        setImage(image);
        getImage().drawImage(image, width, heigth);
    }
}
