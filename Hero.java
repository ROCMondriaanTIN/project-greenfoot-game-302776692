
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
    public static double bonusVelocityY;
    public static double bonusVelocityX;
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
    GreenfootImage[] walkArray = new GreenfootImage[14];

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
        walkArray[13] = new GreenfootImage("p1_jump.png");

        setImage(walkArray[12]);
    }

    @Override
    public void act() {
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        getWorld().showText(getX() + ", " + getY(), 500, 30); 
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround()){ 
            setImage("p1_stand.png");
            mirrorHero();
        }
        if(!onGround()){
           setImage("p1_jump.png");
           mirrorHero();
        }
        
        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                return;
            }
        }

        if(isTouching(DangerousTiles.class)){
            if(Checkpoints.checkpointX > 0 && Checkpoints.checkpointY > 0) {
                setLocation(Checkpoints.checkpointX, Checkpoints.checkpointY);
            } else {
                setLocation(1120, 2695);
            }
        }
        handleInput();
        applyVelocity();
    }

    public void handleInput() {
        if(Greenfoot.isKeyDown("h")) {
            bonusVelocityY = -10;
        }
        if (Greenfoot.isKeyDown("w") && onGround()) {
            if(isTouching(Springboards.class)) { 
                velocityY = -10 + Springboards.springboardVelocity + bonusVelocityY;
                mirrorHero();
            } else {
                velocityY = -10 + bonusVelocityY;
                mirrorHero();
            }
        }
        if (Greenfoot.isKeyDown("space")) {
            velocityY = -10;
        }
        if (Greenfoot.isKeyDown("a")) {
            if(onGround()) {
                walkAnimatie();
            }
            mirrorHero();
            facingLeft = true;
            velocityX = -2;
        } else if (Greenfoot.isKeyDown("d")) {
            if(onGround()) {
                walkAnimatie();
            }
            facingLeft = false;
                mirrorHero();
            velocityX = 2 + bonusVelocityX;
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
