import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelComplete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelComplete extends Actor
{
    private int offset = 0;
    private GreenfootImage bgImage = new GreenfootImage("level_complete.png");
    
    public LevelComplete() {
        setImage("level_complete.png");     
        Hero.movementEnabled = false;
    }
}  