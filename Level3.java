
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Level3 extends World {

    private CollisionEngine ce;

    /**
     * Constructor for objects of class World2.
     *
     */
    public Level3() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("Backgrounds/bg_level3.png");
        
        resetStaticVariables();

        int[][] map1 = {
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,210,191,191,191,191,191,191,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,169,-1,-1,-1,-1,169,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,169,-1,-1,-1,169,-1,-1,-1,-1,169,-1,-1,169,-1,-1,-1,-1,-1,130,130,130},
                {130,-1,-1,169,-1,-1,169,-1,-1,130,130,-1,169,-1,-1,169,-1,-1,-1,-1,147,147,-1,-1,-1,147,147,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,-1,-1,-1,-1,99,130,130,130},
                {130,-1,-1,-1,-1,-1,-1,102,100,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,-1,-1,-1,130,130,-1,-1,191,-1,-1,191,-1,-1,191,-1,-1,-1,-1,-1,191,-1,191,-1,-1,-1,130,70,130},
                {130,94,-1,-1,-1,-1,-1,-1,-1,130,130,-1,-1,-1,-1,200,-1,-1,-1,-1,130,130,-1,-1,-1,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,-1,-1,-1,-1,-1,-1,-1,130,69,130},
                {130,93,-1,147,147,147,147,147,147,130,130,147,147,147,147,147,147,147,147,147,130,130,147,147,147,130,130,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,147,130},
                {130,93,-1,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,186,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,93,-1,-1,186,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,93,-1,-1,186,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,93,-1,-1,186,191,191,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,93,-1,-1,186,191,191,-1,186,-1,-1,191,-1,186,-1,-1,191,-1,186,-1,-1,191,-1,186,-1,-1,191,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,93,-1,-1,186,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,186,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,209,211,130},
                {130,93,-1,-1,232,-1,-1,-1,232,-1,-1,-1,-1,232,-1,-1,-1,-1,232,-1,-1,-1,-1,232,-1,-1,-1,-1,232,-1,-1, -1,94,147,147,94,-1,-1,5,-1,-1,-1,147,147,147,147,147,147,147,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130},
                {130,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,-1,-1,208,130,130,-1,-1,-1,-1,-1,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,191,191,191,130,130,101,-1,-1,-1,-1,130},
                {130,200,213,206,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,130,130,93,-1,-1,-1,191,191,200,130,130,-1,-1,-1,-1,94,130},
                {130,147,147,147,147,224,224,130,130,130,224,224,224,224,130,130,130,224,224,224,224,130,130,130,224,224,224,130,130,130,224,224,130,130,130,147,147,224,224,147,147,147,130,147,147,147,147,147,93,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,93,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,93,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,93,130},
                {130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,93,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130,130,130,-1,-1,169,-1,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,93,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130,130,-1,-1,191,130,-1,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,-1,-1,93,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,130,130,130,-1,-1,191,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,-1,147,147,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,130,130,130,-1,-1,130,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,-1,130,-1,-1,-1,130},
                {130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,130,130,130,212,130,130,130,130,226,-1,-1,169,-1,-1,169,-1,-1,169,-1,-1,169,-1,-1,169,-1,-1,-1,191,-1,130,-1,-1,-1,-1,-1,130},
                {130,147,147,147,-1,136,-1,136,-1,147,147,147,147,147,130,130,130,130,130,130,130,130,136,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,-1,130,-1,-1,-1,-1,-1,-1,-1,130},
                {130,130,130,130,-1,-1,-1,-1,-1,130,130,130,130,130,130,130,130,130,130,130,130,-1,-1,-1,209,200,-1,-1,-1,-1,-1,191,-1,-1,-1,-1,-1,-1,-1,226,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,130,130,130,-1,-1,-1,-1,-1,130,130,130, -1, -1, -1, -1, -1, -1, -1,-1,-1,-1,-1,140,147,147,147,147,-1,-1,-1,136,-1,-1,-1,147,-1,-1,-1,147,-1,-1,-1,-1,-1,-1,-1,-1,-1,130},
                {130,130,130,130,-1,-1,-1,-1,-1,130,130,130,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,140,130,130,130,130,130,-1,-1,-1,-1,-1,-1,-1,130,-1,-1,-1,130,97,97,97,97,97,97,97,97,97,130},
                {130,130,130,130,-1,-1,191,-1,191,-1,-1,-1,-1,169,-1,-1,169,-1,-1,169,-1,140,130,130,130,130,130,130,97,97,97,97,97,97,97,130,-1,-1,147,130,95,95,95,95,95,95,95,95,95,130},
                {130,130,130,130,-1,-1,136,-1,136,147,147,147,-1,191,-1,-1,-1,191,191,-1,140,130,130,130,130,130,130,130,95,95,95,95,95,95,95,130,-1,-1,130,130,95,95,95,95,95,95,95,95,95,130},
                {130,130,130,130,97,97,97,97,97,130,130,130,147,147,147,-1,-1,147,-1,140,130,130,130,130,130,130,130,130,95,95,95,95,95,95,95,130,-1,130,130,130,95,95,95,95,95,95,95,95,95,130},
                {130,130,130,130,95,95,95,95,95,130,130,130,130,130,130,224,224,130,147,130,130,130,130,130,130,130,130,130,95,95,95,95,95,95,95,130,-1,-1,181,130,95,95,95,95,95,95,95,95,95,130},
                {130,130,130,130,95,95,95,95,95,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,130,95,95,95,95,95,95,95,130,130,130,130,130,95,95,95,95,95,95,95,95,95,130},

            };
        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 70, 70, map1);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        
        Camera camera = new Camera(te);        
        Hud redKeyHud = new Hud();
        Hud greenKeyHud = new Hud();
        Hud yellowKeyHud = new Hud();
        Hud blueKeyHud = new Hud();
        Health health1 = new Health();
        Health health2 = new Health();
        Health health3 = new Health();
        ce = new CollisionEngine(te, camera);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero(redKeyHud, greenKeyHud, yellowKeyHud, blueKeyHud, health1, health2, health3, te, ce);
        SlimeEnemy slime1 = new SlimeEnemy();
        SlimeEnemy slime2 = new SlimeEnemy();
        SlimeEnemy slime3 = new SlimeEnemy();
        FlyEnemy fly1 = new FlyEnemy();
        FlyEnemy fly2 = new FlyEnemy();
        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        addObject(camera, 1200, 2700);
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        
        addObject(hero, 100, 2835);
        addObject(slime1, 1650, 895);
        addObject(slime2, 2350, 895);
        addObject(slime3, 3050, 895);
        addObject(fly1, 2000, 695);
        addObject(fly2, 2700, 825);

        //Alle HUDs voor de interface
        addObject(redKeyHud, 800, 30);
        addObject(greenKeyHud, 850, 30);
        addObject(yellowKeyHud, 900, 30);
        addObject(blueKeyHud, 950, 30);
        addObject(health1, 50, 30);
        addObject(health2, 110, 30);
        addObject(health3, 170, 30);

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        camera.act();
        hero.act();
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }

    @Override
    public void act() {
        ce.update();  
    }

    private void resetStaticVariables() {
        //Alle Hero static variabelen
        Hero.speedPowerup = 0.1;
        Hero.jumpPowerups = 0;
        Hero.totalHealth = 3;
        Hero.coins = 0;
        Hero.redKeyCheck = false;
        Hero.blueKeyCheck = false;
        Hero.greenKeyCheck = false;
        Hero.yellowKeyCheck = false;

        //Alle checkpoint static variabelen
        Checkpoints.checkpointX = 100;
        Checkpoints.checkpointY = 2835;
        Hero.score = 0;

    }

}
