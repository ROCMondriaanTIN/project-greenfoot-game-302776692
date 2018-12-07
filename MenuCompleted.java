import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MenuCompleted here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuCompleted extends Hud
{
    public MenuCompleted() {
        setImage("invisible.png");
    }
    /**
     * Act - do whatever the MenuCompleted wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkMouse();
    }    
    
    public void checkMouse() {
        List <MapSelector> levels = getIntersectingObjects(MapSelector.class);
        
        if(Greenfoot.mouseClicked(this)) {
            levels.get(0).levelSelector();            
        }
    }
}
