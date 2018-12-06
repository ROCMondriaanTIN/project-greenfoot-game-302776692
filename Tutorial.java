import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Tutorial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tutorial extends Hud
{
    public Tutorial() {
        setImage("invisible.png");
    }
    public void act() {        
        if(getWorld() instanceof TutorialWorld) {
            TutorialLevel();
        }
    }
    
    public void TutorialLevel() {
        List <Hero> hero = getWorld().getObjects(Hero.class);
        if(hero.get(0).worldX > 90 && hero.get(0).worldX < 300 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Je kunt springen door op W te drukken", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 500 && hero.get(0).worldX < 700 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("De blauwe gem zorgt ervoor dat je hoger kan springen.", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 1000 && hero.get(0).worldX < 1300 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Als je bommen, Spikes en monsters raakt, verlies je een leven. ", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 1500 && hero.get(0).worldX < 1700 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Buttons helpen je door de level heen te komen door een andere object weg te halen.", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 1900 && hero.get(0).worldX < 2300 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Door op springveren te springen, spring je hoger over obstakels heen.", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 2400 && hero.get(0).worldX < 2600 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Als je op S drukt bij open deuren, ga je naar de verbonden deur op een andere positie.", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 2800 && hero.get(0).worldX < 3000 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Je kan sloten open maken met de zelfde kleur sleutel", 30, Color.RED, null);
            setImage(image);
        }
        if(hero.get(0).worldX > 3300 && hero.get(0).worldX < 3500 && hero.get(0).worldY > 3000) {
            GreenfootImage image = new GreenfootImage("Druk op W om op ladders te klimmen.", 30, Color.RED, null);
            setImage(image);
        }
    }
  
}
