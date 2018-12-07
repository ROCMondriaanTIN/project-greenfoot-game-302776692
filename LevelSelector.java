import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelector extends World
{

    // Declareren van CollisionEngine
    private CollisionEngine ce;

    // Declareren van TileEngine
    private TileEngine te;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public LevelSelector() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("Backgrounds/level_select.png");
        int[][] map = { 
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,275,-1,276,-1,277,-1,278,-1,279,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {280,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,280},
                {8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8},
            };
                
                // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
                TileEngine te = new TileEngine(this, 70, 70, map);
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
        Enemy enemy1 = new Enemy();
        

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 1200, 2700);

        addObject(hero, 100, 600);
        

        //Alle HUDs voor de interface
        
        

        // Force act zodat de camera op de juist plek staat.
        
        camera.act();
        hero.act();
        ce.addCollidingMover(hero);
        
        
    }

    @Override
    public void act() {
        ce.update();
    }
    
    private void resetStaticVariables() {
        
        Hero.movementEnabled = true;
        

    }
    
}
