
import greenfoot.*;
import java.util.ArrayList;

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
    public boolean redKeyCheck;
    public boolean blueKeyCheck;
    public boolean yellowKeyCheck;
    public boolean greenKeyCheck;
    public static boolean buttonPressed;
    private int teller = 0;
    public static double bonusVelocityY;
    public static double bonusVelocityX;
    public static int score;
    private static Health health1;
    private static Health health2;
    private static Health health3;
    public static int totalHealth = 3;
    private Hud redKeyHud;
    private Hud greenKeyHud;
    private Hud yellowKeyHud;
    private Hud blueKeyHud;
    GreenfootImage[] walkArray = new GreenfootImage[14];
    ArrayList <String> keyColor = new ArrayList<String>();
    private GreenfootImage redKey = new GreenfootImage("hud_keyRed.png");

    public Hero(Hud redKeyHud, Hud greenKeyHud, Hud yellowKeyHud, Hud blueKeyHud, Health health1, Health health2, Health health3) {
        super();
        this.redKeyHud = redKeyHud;
        this.greenKeyHud = greenKeyHud;
        this.yellowKeyHud = yellowKeyHud;
        this.blueKeyHud = blueKeyHud;
        this.health1 = health1;
        this.health2 = health2;
        this.health3 = health3;
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

        setImage("p1_stand.png");
    }

    @Override
    public void act() {
        handleInput();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        if(!onGround()) {
            setImage(walkArray[13]);
        }
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround()){ 
            setImage("p1_front.png");
        }        
        for(Keys key : getIntersectingObjects(Keys.class)) {
            if(key != null) {
                //key.getKeyColor();
                if(!keyColor.contains(key.getKeyColor())) {
                    keyColor.add(key.getKeyColor());
                }
            }
        }
        checkKey();
        Health();
        KeysInterface();
        applyVelocity();
        getWorld().showText(getX() + ", " + getY(), 500, 30); 
        getWorld().showText("Score: " + score, 300, 30); 
    }

    public void handleInput() {
        if (Greenfoot.isKeyDown("space")) {
            velocityY = -10;
        }
        if (Greenfoot.isKeyDown("a")) {
            if(onGround()) {
                walkAnimatie();
            }
            mirrorHero();
            facingLeft = true;
            velocityX = -2 + bonusVelocityX;
        } else if (Greenfoot.isKeyDown("d")) {
            if(onGround()) {
                walkAnimatie();
            }
            mirrorHero();
            facingLeft = false;
            velocityX = 2 + bonusVelocityX;
        }
        if (Greenfoot.isKeyDown("w") && onGround()) {
            if(isTouching(Springboards.class)) { 
                velocityY = -10 + Springboards.springboardVelocity + bonusVelocityY;
            } else {
                velocityY = -10 + bonusVelocityY;
            }
        }

    }

    public void Health() {
        if(totalHealth == 3) {
            health1.checkHealth(new GreenfootImage("hud_heartFull.png"), 50, 30);
            health2.checkHealth(new GreenfootImage("hud_heartFull.png"), 110, 30);
            health3.checkHealth(new GreenfootImage("hud_heartFull.png"), 170, 30);
        } else if(totalHealth == 2) {
            health3.checkHealth(new GreenfootImage("hud_heartEmpty.png"), 170, 30);
        } else if(totalHealth == 1) {
            health2.checkHealth(new GreenfootImage("hud_heartEmpty.png"), 110, 30);
        } else if(totalHealth <= 0) {
            health1.checkHealth(new GreenfootImage("hud_heartEmpty.png"), 50, 30);
            getWorld().addObject(new GameOver(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            setImage("p1_gameOver.png");
            Greenfoot.stop();          
        }

        if(isTouching(DangerousTiles.class) ){
            //if(totalHealth > 0) {
            if(Checkpoints.checkpointX > 0 && Checkpoints.checkpointY > 0) {
                setLocation(Checkpoints.checkpointX, Checkpoints.checkpointY);
            } else {
                setLocation(1120, 2695);
            }
            //}
            totalHealth = totalHealth - 1;
        }
        if(isTouching(Enemy.class)) {

            if(Checkpoints.checkpointX > 0 && Checkpoints.checkpointY > 0) {
                setLocation(Checkpoints.checkpointX, Checkpoints.checkpointY);
                totalHealth -= 1;
            } else {
                setLocation(1120, 2695);
                totalHealth -= 1;
            }

        }
    }

    public void walkAnimatie() {
        setImage(walkArray[teller]);
        teller++;
        if(teller >= 13){
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

    public void Score() {
        if(isTouching(Keys.class)) {
            //score = score + 10;
        }

    }

    public void checkKey() {
        boolean empty = keyColor.isEmpty();
        if(!empty) {
            for(int i = 0; i < keyColor.size(); i++) {
                if(keyColor.get(i).equals("Red")){
                    redKeyCheck = true;
                    redKeyHud.addKey(new GreenfootImage("hud_keyRed.png"), 800, 30);
                    continue;
                }
                if(("Green").equals(keyColor.get(i))) {
                    greenKeyCheck = true;
                    greenKeyHud.addKey(new GreenfootImage("hud_keyGreen.png"), 850, 30);
                    continue;
                }
                if(("Blue").equals(keyColor.get(i))) {
                    blueKeyCheck = true;
                    blueKeyHud.addKey(new GreenfootImage("hud_keyBlue.png"), 950, 30);
                    continue;
                }
                if(("Yellow").equals(keyColor.get(i))) {
                    yellowKeyCheck = true;
                    yellowKeyHud.addKey(new GreenfootImage("hud_keyYellow.png"), 900, 30);
                    continue;
                }
            }
        }
    }

    public void KeysInterface() {
        checkKey();
        if(redKeyCheck == false) {
            redKeyHud.addKey(new GreenfootImage("hud_keyRed_disabled.png"), 800, 30);
        } 
        if(greenKeyCheck == false) {
            greenKeyHud.addKey(new GreenfootImage("hud_keyGreem_disabled.png"), 850, 30);
        } 
        if(yellowKeyCheck == false) {
            yellowKeyHud.addKey(new GreenfootImage("hud_keyYellow_disabled.png"), 900, 30);
        } 
        if(blueKeyCheck == false) {
            blueKeyHud.addKey(new GreenfootImage("hud_keyBlue_disabled.png"), 950, 30);
        } 
        if(redKeyCheck == true) {
            redKeyHud.addKey(new GreenfootImage("hud_keyRed.png"), 800, 30);

        } 


    }
}
