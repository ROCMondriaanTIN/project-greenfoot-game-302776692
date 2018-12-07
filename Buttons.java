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
    public Buttons(String image, int width, int height, TileType type) {
        super(image, width, height, type);
    }

    /**
     * Act - do whatever the Buttons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        tutorialButtons();
        level1Buttons();
    }   

    public void level1Buttons() {
        if(isTouching(Hero.class)) {
            if(getWorld() instanceof Level1) {
                if(getColom() == 33 && getRow() == 20){               
                    Hero.tileEngine.removeTileAt(19, 29); 
                } else if(getColom() == 33 && getRow() == 31) {
                    Hero.tileEngine.removeTileAt(21, 42); 
                }
                setImage("buttonRed_pressed.png");
            }            
        } 
    }
    
    public void tutorialButtons() {
        if(isTouching(Hero.class)) {
            if(getWorld() instanceof TutorialWorld) {
                if(getColom() == 25 && getRow() == 45){               
                    Hero.tileEngine.removeTileAt(26, 45); 
                }
                if(getColom() == 2 && getRow() == 34) {
                    getWorld().addObject(new LevelComplete(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                    Hero.movementEnabled = false;
                }
                setImage("buttonBlue_pressed.png");
            }             
        }
    }
}
