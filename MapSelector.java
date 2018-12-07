import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MapSelector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapSelector extends Tile
{
    private int buttonInt = 0;
    public String level;
    public static int nummer;
    private int nummer2;
    private boolean activated;
    public MapSelector(String image,int width,int heigth, TileType type) {
        super(image,width,heigth, type);
        int begin = image.indexOf("_") + 1;
        int end = image.indexOf(".");
        level = image.substring(begin,end);
        
        if(image != "Levels/level.png") {
           buttonInt = Integer.parseInt(level);
           nummer2 = nummer;
           nummer ++;
        }
        else{
            nummer2 = -1;
        }
    }
    /**
     * Act - do whatever the MapSelector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        completedLevels();
    }    
    
    public void levelSelector() {
        switch(level) {
            case "1":
            Greenfoot.setWorld(new TutorialWorld());
            break;
            case "2":
            if(Hero.levelsCompleted > 0) {
                Greenfoot.setWorld(new Level4());
                break;
            }
            case "3":
            if(Hero.levelsCompleted > 1) {
                Greenfoot.setWorld(new Level4());
                break;
            }
            case "4":
            if(Hero.levelsCompleted > 2) {
                Greenfoot.setWorld(new Level4());
                break;
            }
            case "5":
            if(Hero.levelsCompleted > 3) {
                Greenfoot.setWorld(new Level4());
                break;
            }
        }
    }
   
    public void completedLevels() {
        if((Hero.levelsCompleted >= nummer2 && !activated && nummer2 >= 0) || buttonInt >= 10){
            getWorld().addObject(new MenuCompleted(), x,y);
            
        }
    }
}
