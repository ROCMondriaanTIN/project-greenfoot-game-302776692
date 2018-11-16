
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    boolean facingLeft;
    boolean mirror;
    private int teller = 0;
    private GreenfootImage walk0;
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
    GreenfootImage[] walkArray = new GreenfootImage[13];

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.3;
        drag = 0.8;
        walkArray[0] = new GreenfootImage("p1.png");
        walkArray[1] = new GreenfootImage("p1_walk01.png");
        walkArray[2] = new GreenfootImage("p1_walk02.png");
        walkArray[3] = new GreenfootImage("p1_walk03.png");
        walkArray[4] = new GreenfootImage("p1_walk04.png");
        walkArray[5] = new GreenfootImage("p1_walk05.png");
        walkArray[6] = new GreenfootImage("p1_walk06.png");
        walkArray[7] = new GreenfootImage("p1_walk07.png");
        walkArray[8] = new GreenfootImage("p1_walk08.png");
        walkArray[9] = new GreenfootImage("p1_walk09.png");
        walkArray[10] = new GreenfootImage("p1_walk10.png");
        walkArray[11] = new GreenfootImage("p1_walk11.png");
        walkArray[12] = new GreenfootImage("p1_stand.png");

        setImage(walkArray[0]);
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
                return;
            }
        }

        if(isTouching(DangerousTiles.class)){
            setLocation(1120, 2695);
        }

    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("w") && velocityY == 0) {
            velocityY = -10;
        }
        if (Greenfoot.isKeyDown("space")) {
            velocityY = -10;
        }
        if (Greenfoot.isKeyDown("a")) {
            mirrorHero();
            facingLeft = true;
            walkAnimatie();
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            facingLeft = false;
            mirrorHero();
            walkAnimatie();
            velocityX = 2;

        }
    }

    public void walkAnimatie() {
        setImage(walkArray[teller]);
        teller++;
        if(teller >= 11){
            teller = 0;
        }  
    }

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }

    public void mirrorImage() {
        for(int i = 0; i < walkArray.length; i++){
            walkArray[i].mirrorHorizontally();
        }
    }

    public void mirrorHero() {
        if(facingLeft == false && mirror == true){
            mirrorImage();
            mirror = false;
        }
        if(facingLeft == true && mirror == false){
            mirrorImage();
            mirror = true;
        }
    }
}
