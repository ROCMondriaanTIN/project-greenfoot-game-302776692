
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
    public static int levelsCompleted = 0;

    //Deze 3 zijn voor de movement + animations
    private boolean facingLeft;
    private boolean mirror;
    private int teller = 0;
    public static boolean movementEnabled = true;

    //Deze 4 zijn voor de key interface en de locks
    public static boolean redKeyCheck;
    public static boolean blueKeyCheck;
    public static boolean yellowKeyCheck;
    public static boolean greenKeyCheck;

    //Deze 7 zijn voor de powerups en score
    public static double bonusVelocityY = 2;
    public static double bonusVelocityX = 1;
    public static double jumpPowerups = 0;
    public static double speedPowerup = 0;
    public static int healthPowerup = 0;
    public int extraHealth = totalHealth - 3;
    public static int score;
    public static int coins;

    //Deze 3 zijn voor de health
    public boolean isHit;    
    private int hitTeller = 0;
    public static int totalHealth = 3;

    //Deze zijn voor de interface
    private Health health1;
    private Health health2;
    private Health health3;
    private Hud redKeyHud;
    private Hud greenKeyHud;
    private Hud yellowKeyHud;
    private Hud blueKeyHud;
    public static TileEngine tileEngine;
    private CollisionEngine collisionEngine;

    //Arrays
    GreenfootImage[] walkArray = new GreenfootImage[14];
    ArrayList <String> keyColor = new ArrayList<String>();
    ArrayList <String> powerupColor = new ArrayList<String>();

    public Hero(CollisionEngine collisionEngine) {
        super();
        gravity = 9.8;
        acc = 0.3;
        drag = 0.8;
        this.collisionEngine = collisionEngine;
        setImage("p1_stand.png");
    }

    public Hero(Hud redKeyHud, Hud greenKeyHud, Hud yellowKeyHud, Hud blueKeyHud, Health health1, Health health2, Health health3, TileEngine tileEngine, CollisionEngine collisionEngine) {
        super();        
        gravity = 9.8;
        acc = 0.28;
        drag = 0.8;
        this.redKeyHud = redKeyHud;
        this.greenKeyHud = greenKeyHud;
        this.yellowKeyHud = yellowKeyHud;
        this.blueKeyHud = blueKeyHud;
        this.health1 = health1;
        this.health2 = health2;
        this.health3 = health3;      
        this.tileEngine = tileEngine;
        this.collisionEngine = collisionEngine;

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
        LocksTutorial();
        LocksLevel2();
        LocksLevel3();
        LocksWorld4();
        LocksWorld5();
        levelHandler();
    }
    
    public void handleMovement() {
        if(velocityX >= -0.3 && velocityX <= 0.3 && onGround()){ 
            setImage("p1_front.png");
        }
        if(!onGround()) {
            setImage(walkArray[13]);
        }
        if (Greenfoot.isKeyDown("a") && movementEnabled == true) {
            if(onGround()) {
                walkAnimatie();
            }
            mirrorHero();
            facingLeft = true;
            velocityX = -2 - (bonusVelocityX * speedPowerup);
        } else if (Greenfoot.isKeyDown("d") && movementEnabled == true) {
            if(onGround()) {
                walkAnimatie();
            }
            mirrorHero();
            facingLeft = false;
            velocityX = 2 + (bonusVelocityX * speedPowerup);
        }
        if (Greenfoot.isKeyDown("w") && movementEnabled == true) {
            if(onGround()) {
                if(isTouching(Springboards.class)) { 
                    velocityY = -10 + Springboards.springboardVelocity - (bonusVelocityY * jumpPowerups);
                } else {
                    velocityY = -10 - (bonusVelocityY * jumpPowerups);
                }
            }
            if(isTouching(ClimbObject.class)) {
                velocityY = -5;
            }
        }
        if(Greenfoot.isKeyDown("space") && movementEnabled == false) {
            Greenfoot.setWorld(new Introduction());
        }
    }

    public void Doors() {        
        Doors door = (Doors)getOneIntersectingObject(Doors.class);
        if(this.getWorld().getClass() != Introduction.class) {
            if(isTouching(Doors.class)) {
                if(Greenfoot.isKeyDown("s")) {                    
                    if(getWorld() instanceof TutorialWorld) {
                        setLocation(2900, 3327); 
                    } 
                    if(getWorld() instanceof Level2) {
                        if(coins >= 10) {
                            if(levelsCompleted <= 1) {
                                levelsCompleted = 2;
                            }
                            getWorld().addObject(new LevelComplete(), getWorld().getWidth()/2, getWorld().getHeight()/2);                       
                        }
                    }
                    if(getWorld() instanceof Level3) {
                        if(coins >= 42) {
                            if(levelsCompleted <= 2) {
                                levelsCompleted = 3;
                            }
                            getWorld().addObject(new LevelComplete(), getWorld().getWidth()/2, getWorld().getHeight()/2);                       
                        }
                    }
                    if(getWorld() instanceof Level4) {
                        if(coins >= 70) {
                            if(levelsCompleted <= 3) {
                                levelsCompleted = 4;
                            }
                            getWorld().addObject(new LevelComplete(), getWorld().getWidth()/2, getWorld().getHeight()/2);                       
                        }
                    }                    
                    if(getWorld() instanceof Level5) {
                        if(coins >= 90) {
                            getWorld().addObject(new LevelComplete(), getWorld().getWidth()/2, getWorld().getHeight()/2);
                        }
                    }
                }
            }
        }
    }

    public void Health() {
        if(this.getWorld().getClass() != Introduction.class) {

            if(totalHealth > 3) {            
                health1.checkHealth(new GreenfootImage("hud_heartFull.png"), 50, 30);
                health2.checkHealth(new GreenfootImage("hud_heartFull.png"), 110, 30);
                health3.checkHealth(new GreenfootImage("hud_heartFull.png"), 170, 30);
                getWorld().showText(" + " + (totalHealth - 3), 215, 30);
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
            if(isTouching(DangerousTiles.class) || isTouching(Fireballs.class)){
                if(Checkpoints.checkpointX > 0 && Checkpoints.checkpointY > 0) {
                    setLocation(Checkpoints.checkpointX, Checkpoints.checkpointY);
                } else {
                    setLocation(1120, 2695);
                }
                totalHealth = totalHealth - 1;            
            }
            if(isTouching(SlimeEnemy.class) || isTouching(FlyEnemy.class)) {
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
        if(this.getWorld().getClass() == TutorialWorld.class) {
             getWorld().showText("Coins: " + coins + "/9", 300, 50);
         }
         if(this.getWorld().getClass() == Level2.class) {
             getWorld().showText("Coins: " + coins + "/10", 300, 50);
         }
         if(this.getWorld().getClass() == Level3.class) {
             getWorld().showText("Coins: " + coins + "/42", 300, 50);
         }
         if(this.getWorld().getClass() == Level5.class) {
             getWorld().showText("Coins: " + coins + "/90", 300, 50);
         }
        
        if(isTouching(Keys.class)) {
            score = score + 50;
        }
    }

    public void getPowerup() {
        boolean isEmpty = powerupColor.isEmpty();
        if(this.getWorld().getClass() != Introduction.class) {
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
                        powerupColor.remove(i);
                        jumpPowerups = jumpPowerups + 1;
                        continue;
                    }
                    if(powerupColor.get(i).equals("Red")) { 
                        totalHealth += 1;
                        powerupColor.remove(i);
                        continue;
                    }
                    if(powerupColor.get(i).equals("Yellow")) { 
                        speedPowerup += 1;
                        powerupColor.remove(i);
                        continue;
                    }
                }
            }
        }
    }

    public void LocksTutorial() {
        if(this.getWorld().getClass() == TutorialWorld.class) {
            List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);
            for(Tile tile : tiles) {
                if(tile != null) {
                    if(isTouching(Locks.class)) {
                        if(tile.type == TileType.RED && redKeyCheck == true) {                       
                            tileEngine.removeTileAt(46, 46);
                            tileEngine.removeTileAt(47, 47);
                        }                    
                    }
                }
            }
        }
    }
    
    public void LocksLevel2() {
        if(this.getWorld().getClass() == Level2.class) {
            List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);
            for(Tile tile : tiles) {
                if(tile != null) {
                    if(isTouching(Locks.class)) {
                        if(tile.type == TileType.RED && redKeyCheck == true) {                       
                            tileEngine.removeTileAt(32, 44);
                            tileEngine.removeTileAt(33, 44);
                            tileEngine.removeTileAt(34, 44);
                            tileEngine.removeTileAt(35, 44);
                            tileEngine.removeTileAt(36, 44);
                        }    
                        if(tile.type == TileType.GREEN && greenKeyCheck == true) {                       
                            tileEngine.removeTileAt(46, 40);
                            tileEngine.removeTileAt(39, 42);                            
                        }  
                        if(tile.type == TileType.BLUE && blueKeyCheck == true) {                       
                            tileEngine.removeTileAt(47, 43);
                            tileEngine.removeTileAt(38, 42);                            
                        } 
                    }
                }
            }
        }
    }
    
    public void LocksLevel3() {
        if(this.getWorld().getClass() == Level3.class) {
            List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);
            for(Tile tile : tiles) {
                if(tile != null) {
                    if(isTouching(Locks.class)) {
                        if(tile.type == TileType.RED && redKeyCheck == true) {                       
                            tileEngine.removeTileAt(44, 29);
                            tileEngine.removeTileAt(42, 30);
                        }   
                        if(tile.type == TileType.GREEN && greenKeyCheck == true) {                       
                            tileEngine.removeTileAt(9, 12);
                            tileEngine.removeTileAt(8, 11);
                        }
                        if(tile.type == TileType.YELLOW && yellowKeyCheck == true) {                       
                            tileEngine.removeTileAt(10, 12);
                            tileEngine.removeTileAt(7, 11);
                        }
                        if(tile.type == TileType.BLUE && blueKeyCheck == true) {                       
                            tileEngine.removeTileAt(46, 10);
                            tileEngine.removeTileAt(47, 12);
                        }
                    }
                }
            }
        }
    }

    public void LocksWorld4() {
        if(this.getWorld().getClass() == Level4.class) {
            List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);
            for(Tile tile : tiles) {
                if(tile != null) {
                    if(isTouching(Locks.class)) {
                        if(tile.type == TileType.BLUE && blueKeyCheck == true) {                       
                            tileEngine.removeTileAt(2, 48);
                            tileEngine.removeTileAt(2, 47);
                            tileEngine.removeTileAt(29, 23);
                        } else if(tile.type == TileType.GREEN && greenKeyCheck == true){
                            tileEngine.removeTileAt(3, 48);
                            tileEngine.removeTileAt(3, 47);
                            tileEngine.removeTileAt(26, 23);
                        } else if(tile.type == TileType.RED && redKeyCheck == true){
                            tileEngine.removeTileAt(4, 48);
                            tileEngine.removeTileAt(4, 47);
                            tileEngine.removeTileAt(27, 23);
                        } else if(tile.type == TileType.YELLOW && yellowKeyCheck == true){
                            tileEngine.removeTileAt(28, 23);
                            tileEngine.removeTileAt(1, 48);
                            tileEngine.removeTileAt(1, 47);
                            tileEngine.addTileAt(new Doors("door_openMid.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT), 1, 48);
                            tileEngine.addTileAt(new Doors("door_openTop.png", TileEngine.TILE_WIDTH, TileEngine.TILE_HEIGHT), 1, 47);
                        }                      
                    }
                }
            }
        }
    }
    
    public void LocksWorld5() {
        if(this.getWorld().getClass() == Level5.class) {
            List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);
            for(Tile tile : tiles) {
                if(tile != null) {
                    if(isTouching(Locks.class)) {
                        if(tile.type == TileType.BLUE && blueKeyCheck == true) {                       
                            tileEngine.removeTileAt(1, 58);
                            tileEngine.removeTileAt(28, 33);
                            tileEngine.removeTileAt(28, 64);
                            tileEngine.removeTileAt(27, 64);
                        } else if(tile.type == TileType.GREEN && greenKeyCheck == true){
                            tileEngine.removeTileAt(2, 58);
                            tileEngine.removeTileAt(28, 35);
                            tileEngine.removeTileAt(51, 57);
                            tileEngine.removeTileAt(52, 57);
                        } else if(tile.type == TileType.RED && redKeyCheck == true){
                            tileEngine.removeTileAt(3, 58);
                            tileEngine.removeTileAt(28, 34);
                        } else if(tile.type == TileType.YELLOW && yellowKeyCheck == true){
                            tileEngine.removeTileAt(4, 58);
                            tileEngine.removeTileAt(28, 36);
                        }                      
                    }
                }
            }
        }

    }

    public void checkKey() {
        boolean empty = keyColor.isEmpty();
        if(this.getWorld().getClass() != Introduction.class) {
            for(Keys key : getIntersectingObjects(Keys.class)) {
                if(key != null) {
                    if(!keyColor.contains(key.getKeyColor())) {
                        keyColor.add(key.getKeyColor());
                        removeTouching(Keys.class); 
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
    }

    public void KeysInterface() {
        if(this.getWorld().getClass() != Introduction.class) {
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
    }

    public void setCheckpoints() {
        if(this.getWorld().getClass() != Introduction.class) {
            for (Actor hero : getIntersectingObjects(Checkpoints.class)) {
                if (hero != null) {
                    Checkpoints.checkpointX = getX();
                    Checkpoints.checkpointY = getY();             
                    break;
                }
            }
        }
    }

    public void levelHandler() {           
        List<Tile> tiles = collisionEngine.getCollidingTiles(this, true);
        
        if(this.getWorld().getClass() == Introduction.class) {
            for(Tile tile : tiles) {
                if(tile != null) {
                    if(isTouching(MapSelector.class)) {
                        if(tile.type == TileType.LEVEL1) {           
                            Greenfoot.setWorld(new TutorialWorld());
                        } else if(tile.type == TileType.LEVEL2){
                            if(levelsCompleted >= 1) {
                                Greenfoot.setWorld(new Level2());
                            }
                        } else if(tile.type == TileType.LEVEL3){
                            if(levelsCompleted >= 2) {
                                Greenfoot.setWorld(new Level3());
                            }
                        } else if(tile.type == TileType.LEVEL4){
                            if(levelsCompleted >= 3) {
                                Greenfoot.setWorld(new Level4());
                            }
                        } else if(tile.type == TileType.LEVEL5){
                            if(levelsCompleted >= 4) {
                                Greenfoot.setWorld(new Level5());
                            }
                        }    
                    }
                }
            }
        }
    }
}
