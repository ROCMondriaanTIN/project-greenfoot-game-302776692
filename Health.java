import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends Actor
{
   public Health() {
        super();
   }
     
    public void checkHealth(GreenfootImage image, int width, int heigth) {
        setImage(image);
        getImage().drawImage(image, width, heigth);
    }   
}
