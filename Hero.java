
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private GreenfootImage stand;
    private GreenfootImage walk1;
    private GreenfootImage walk2;
    private GreenfootImage walk3;
    private GreenfootImage walk4;
    private GreenfootImage walk5;
    private GreenfootImage walk6;
    private GreenfootImage walk7;
    private GreenfootImage walk8;
    private GreenfootImage walk9;
    private GreenfootImage walk10;
    private GreenfootImage walk11;


    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        stand = new GreenfootImage("p1.png");
        walk1 = new GreenfootImage("p1_walk01.png");
        walk2 = new GreenfootImage("p1_walk02.png");
        walk3 = new GreenfootImage("p1_walk03.png");
        walk4 = new GreenfootImage("p1_walk04.png");
        walk5 = new GreenfootImage("p1_walk05.png");
        walk6 = new GreenfootImage("p1_walk06.png");
        walk7 = new GreenfootImage("p1_walk07.png");
        walk8 = new GreenfootImage("p1_walk08.png");
        walk9 = new GreenfootImage("p1_walk09.png");
        walk10 = new GreenfootImage("p1_walk10.png");
        walk11 = new GreenfootImage("p1_walk11.png");

        
        setImage("p1.png");
    }

    @Override
    public void act() {
        handleInput();

        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        
        getWorld().showText(getX() + ", " + getY(), 500, 30); 

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                break;
            }
        }
        
        
        


    }
    public void handleInput() {
        if (Greenfoot.isKeyDown("w") && velocityY == 0) {
            velocityY = -10;
        }

        if (Greenfoot.isKeyDown("a")) {

            if(getImage() == stand){
                setImage(walk1);
            } else if (getImage() == walk1){
                setImage(walk2);
            } else if (getImage() == walk2){
                setImage(walk3);
            } else if (getImage() == walk3){
                setImage(walk4);
            } else if (getImage() == walk4){
                setImage(walk5);
            } else if (getImage() == walk5){
                setImage(walk6);
            } else if (getImage() == walk6){
                setImage(walk7);
            } else if (getImage() == walk7){
                setImage(walk8);
            } else if (getImage() == walk8){
                setImage(walk9);
            } else if (getImage() == walk9){
                setImage(walk10);
            } else if (getImage() == walk10){
                setImage(walk11);
            } else {
                setImage(walk1);
            }

            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            if(getImage() == stand){
                setImage(walk1);
            } else if (getImage() == walk1){
                setImage(walk2);
            } else if (getImage() == walk2){
                setImage(walk3);
            } else if (getImage() == walk3){
                setImage(walk4);
            } else if (getImage() == walk4){
                setImage(walk5);
            } else if (getImage() == walk5){
                setImage(walk6);
            } else if (getImage() == walk6){
                setImage(walk7);
            } else if (getImage() == walk7){
                setImage(walk8);
            } else if (getImage() == walk8){
                setImage(walk9);
            } else if (getImage() == walk9){
                setImage(walk10);
            } else if (getImage() == walk10){
                setImage(walk11);
            } else {
                setImage(walk1);
            }

            velocityX = 2;
        }
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

    
}
