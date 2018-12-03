
import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    

    //Deze 3 zijn voor de movement + animations
    private boolean facingLeft;
    private boolean mirror;
    private int teller = 0;

    //Deze 4 zijn voor de key interface en de locks
    public static boolean redKeyCheck;
    public static boolean blueKeyCheck;
    public static boolean yellowKeyCheck;
    public static boolean greenKeyCheck;


    //Deze 3 zijn voor de powerups en score
    public static double bonusVelocityY;
    public static double bonusVelocityX;
    public static int jumpPowerups = 0;
    public static int speedPowerup = 0;
    public static int healthPowerup = 0;
    public static int score;
    
    //Deze 3 zijn voor de health
    public boolean isHit;    
    private int hitTeller = 0;
    public static int totalHealth = 3 + healthPowerup;
     

    //Deze zijn voor de interface
    private Health health1;
    private Health health2;
    private Health health3;
    private Hud redKeyHud;
    private Hud greenKeyHud;
    private Hud yellowKeyHud;
    private Hud blueKeyHud;
    public static TileEngine tileEngine;

    

    //Arrays
    GreenfootImage[] walkArray = new GreenfootImage[14];
    ArrayList <String> keyColor = new ArrayList<String>();
    ArrayList <String> powerupColor = new ArrayList<String>();

    public Hero(Hud redKeyHud, Hud greenKeyHud, Hud yellowKeyHud, Hud blueKeyHud, Health health1, Health health2, Health health3, TileEngine tileEngine) {
        super();        
        gravity = 9.8;
        acc = 0.3;
        drag = 0.8;
        this.redKeyHud = redKeyHud;
        this.greenKeyHud = greenKeyHud;
        this.yellowKeyHud = yellowKeyHud;
        this.blueKeyHud = blueKeyHud;
        this.health1 = health1;
        this.health2 = health2;
        this.health3 = health3;      
        this.tileEngine = tileEngine;
        
        
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
       int newColom = getX() / 70;
       int newRow = getY() / 70;


        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }   
        handleMovement();
        checkKey();
        Health();
        KeysInterface();
        applyVelocity();
        Score();
        isHit();
        getPowerup();
        setCheckpoints();
        Doors();
        getWorld().showText("Colom: " + newColom + ", Row: " + newRow, 500, 30);     
        getWorld().showText("X: " + getX() + ", Y: " + getY(), 500, 45);  
    }

    public void handleMovement() {
        if(Greenfoot.isKeyDown("k")) {
            tileEngine.removeTileAt(33, 20);
        }
        if(Greenfoot.isKeyDown("h")) {
            tileEngine.addTileAt(new Springboards("springboardDown.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT),33, 20);
        }
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround()){ 
            setImage("p1_front.png");
        }
        if(!onGround()) {
            setImage(walkArray[13]);
        }
        if (Greenfoot.isKeyDown("space")) {
            velocityY = -20;
        }
        if (Greenfoot.isKeyDown("a")) {
            if(onGround()) {
                walkAnimatie();
            }
            mirrorHero();
            facingLeft = true;
            velocityX = -2 - bonusVelocityX;
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
                velocityY = -10 + Springboards.springboardVelocity + (bonusVelocityY * jumpPowerups);
            } else {
                velocityY = -10 + (bonusVelocityY * jumpPowerups);
            }
        }
    }
            
    public void Doors() {
        //int colom = BasicTile.getColom();
        Doors door = (Doors)getOneIntersectingObject(Doors.class);
        if(isTouching(Doors.class)) {
            if(Greenfoot.isKeyDown("s")) {
                /*if(door.getColom() == 33 && door.getRow() == 44){
                    setLocation(2630, 3116); 
                }*/
                if(getX() >= 4200 && getX() <= 4300 && getY() >= 1700 && getY() <= 1800){
                    setLocation(3323, 3186); 
                }
                else if(getX() >= 3200 && getX() <= 3400 && getY() >= 3100 && getY() <= 3200){
                    setLocation(2715, 3115);
                }
            }
        }
    }

    public void Health() {
        if(totalHealth > 3) {            
            health1.checkHealth(new GreenfootImage("hud_heartFull.png"), 50, 30);
            health2.checkHealth(new GreenfootImage("hud_heartFull.png"), 110, 30);
            health3.checkHealth(new GreenfootImage("hud_heartFull.png"), 170, 30);
            getWorld().showText(" + " + healthPowerup, 215, 30);
        } else if(totalHealth == 3) {
            health1.checkHealth(new GreenfootImage("hud_heartFull.png"), 50, 30);
            health2.checkHealth(new GreenfootImage("hud_heartFull.png"), 110, 30);
            health3.checkHealth(new GreenfootImage("hud_heartFull.png"), 170, 30);
            getWorld().showText("", 215, 30);
        } else if(totalHealth == 2) {
            health3.checkHealth(new GreenfootImage("hud_heartEmpty.png"), 170, 30);
        } else if(totalHealth == 1) {
            health2.checkHealth(new GreenfootImage("hud_heartEmpty.png"), 110, 30);
        } else if(totalHealth <= 0) {
            health1.checkHealth(new GreenfootImage("hud_heartEmpty.png"), 50, 30);
            getWorld().addObject(new GameOver(), getWorld().getWidth()/2, getWorld().getHeight()/2);
            setImage("invisible.png");
            Greenfoot.stop();          
        }
        if(isTouching(DangerousTiles.class)){
            if(Checkpoints.checkpointX > 0 && Checkpoints.checkpointY > 0) {
                setLocation(Checkpoints.checkpointX, Checkpoints.checkpointY);
            } else {
                setLocation(1120, 2695);
            }
            totalHealth = totalHealth - 1;            
        }
        if(isTouching(Enemy.class)) {
            if(isHit == false) {
                if(Checkpoints.checkpointX > 1 && Checkpoints.checkpointY > 1) {
                    isHit = true;
                    totalHealth = totalHealth - 1;
                    setLocation(Checkpoints.checkpointX, Checkpoints.checkpointY); 
                } else {
                    isHit = true;
                    setLocation(1120, 2695);
                    totalHealth = totalHealth - 1;
                } 
            } 
        }
    }

    public void isHit() {       
        if(isHit == true) {
            if(hitTeller == 10) {
                isHit = false;
                hitTeller = 0;                
            }
            hitTeller++;
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
        getWorld().showText("Score: " + score, 300, 30);
        if(isTouching(Keys.class)) {
            score = score + 50;
        }
    }

    public void getPowerup() {
        boolean isEmpty = powerupColor.isEmpty();
        for(Powerups powerup : getIntersectingObjects(Powerups.class)) {
            if(powerup != null) {
                if(!powerupColor.contains(powerup.getPowerupColor())) {
                    powerupColor.add(powerup.getPowerupColor());
                }
            }
        }
        if(!isEmpty) {
            for(int i = 0; i < powerupColor.size(); i++) {
                if(powerupColor.get(i).equals("Blue")) { 
                    bonusVelocityY = -2;
                    powerupColor.remove(i);
                    jumpPowerups = jumpPowerups + 1;
                    continue;
                }
                if(powerupColor.get(i).equals("Red")) { 
                    healthPowerup += 1;
                    powerupColor.remove(i);
                    continue;
                }
                if(powerupColor.get(i).equals("Yellow")) { 
                    bonusVelocityX = 1;
                    powerupColor.remove(i);
                    continue;
                }
            }
        }
    }

    public void checkKey() {
        boolean empty = keyColor.isEmpty();
        for(Keys key : getIntersectingObjects(Keys.class)) {
            if(key != null) {
                if(!keyColor.contains(key.getKeyColor())) {
                    keyColor.add(key.getKeyColor());
                }
            }
        }        
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
    }

    public void setCheckpoints() {
        for (Actor hero : getIntersectingObjects(Checkpoints.class)) {
            if (hero != null) {
                Checkpoints.checkpointX = getX();
                Checkpoints.checkpointY = getY();             
                break;
            }
        }
    }
}
