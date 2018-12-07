
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class Level4 extends World {

    private CollisionEngine ce;

    /**
     * Constructor for objects of class World2.
     *
     */
    public Level4() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("Backgrounds/bg_level4.png");
        resetStaticVariables();

        int[][] map = {
                {6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,191,191,191,191,191,191,191,191,191,191,6,-1,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,191,191,208,191,191,191,191,191,191,191,6,-1,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,213,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,13,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,191,191,191,191,191,191,191,191,191,200,6,-1,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,-1,-1,8,8,-1,-1,-1,8,8,8,-1,-1,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,6,-1,-1,191,-1,186,191,191,191,186,-1,191,-1,186,-1,-1,212,6},
                {6,-1,26,-1,191,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,6,6,6,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,94,5,5,5,186,5,5,5,186,5,5,5,186,-1,5,5,6},
                {6,-1,-1,-1,26,-1,191,-1,-1,-1,-1,-1,-1,26,-1,-1,26,-1,-1,-1,-1,-1,6,6,226,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,93,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,26,-1,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,173,-1,-1,6,6,6,226,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,93,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,6,6,6,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,-1,-1,6,93,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,191,-1,226,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,-1,-1,6,93,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,191,-1,173,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,93,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,191,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,191,-1,-1,-1,-1,-1,-1,226,6,93,-1,191,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,226,-1,191,6,6,6,-1,-1,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,6,5,5,5,5,186,191,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,173,-1,191,6,6,6,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,-1,-1,-1,-1,186,5,5,5,186,-1,-1,191,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,191,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,186,-1,-1,-1,186,5,5,5,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,226,6,6,6,226,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,191,191,-1,-1,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,173,6,6,6,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,-1,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,5,5,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,173,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,5,5,5,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,-1,-1,271,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,271,-1,-1,-1,-1,-1,-1,226,-1,173,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,186,-1,-1,-1,6},
                {6,8,8,8,8,8,8,8,8,8,8,-1,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,1,-1,-1,-1,1,-1,-1,-1,1,-1,-1,-1,6},
                {6,6,6,6,6,6,6,6,6,6,6,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,1,1,1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,26,26,-1,-1,26,-1,-1,26,26,26,26,26,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,191,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,-1,191,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,1,1,-1,191,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,1,1,1,1,-1,-1,-1,-1,191,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,1,1,1,1,-1,-1,6,-1,173,-1,173,-1,-1,191,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,193,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,1,1,1,1,1,1,-1,-1,105,-1,-1,-1,-1,-1,1,1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,193,-1,-1,-1,-1,-1,-1,-1,-1,191,191,-1,-1,-1,-1,-1,191,191,-1,-1,-1,-1,-1,6,6,1,1,1,1,1,1,-1,-1,107,-1,-1,-1,-1,-1,1,1,6},
                {6,210,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,193,-1,-1,-1,191,191,-1,-1,-1,191,191,-1,-1,-1,-1,-1,191,191,-1,-1,-1,70,-1,6,6,1,1,1,1,1,1,-1,-1,107,-1,-1,-1,1,1,1,1,6},
                {6,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,193,220,215,220,191,191,-1,220,-1,220,-1,215,220,220,220,-1,-1,215,-1,-1,-1,69,-1,6,6,1,1,1,1,1,1,-1,-1,107,-1,-1,1,1,1,1,1,6},
                {6,-1,26,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,6,6,8,8,8,8,8,8,8,-1,107,-1,8,8,8,8,8,8,6},
                {6,-1,-1,-1,26,26,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,-1,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,26,26,26,26,-1,26,26,-1,26,26,26,26,-1,26,26,26,26,26,-1,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,211,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,191,191,191,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,26,94,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,5,5,5,5,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,93,6,6,-1,191,-1,186,-1,-1,186,-1,107,-1,200,5,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,93,6,6,-1,5,-1,186,-1,-1,186,-1,107,-1,5,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,93,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,26,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,93,6,6,-1,-1,191,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,191,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,93,6,6,-1,5,5,186,5,191,186,-1,107,-1,-1,-1,-1,-1,-1,5,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,191,191,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,191,186,200,93,6,6,208,-1,-1,186,-1,5,186,5,107,-1,191,-1,-1,191,-1,-1,6},
                {6,206,-1,-1,191,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,200,226,6,6,94,5,5,186,5,5,186,5,5,186,5,186,5,186,5,5,186,5,5,186,5,5,6,6,5,-1,-1,186,-1,-1,186,-1,107,-1,5,-1,-1,5,-1,-1,6},
                {6,94,26,26,26,26,26,26,26,26,26,26,26,26,-1,-1,26,26,26,26,26,26,26,26,26,26,26,6,6,93,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,191,-1,-1,-1,6},
                {6,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,93,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,191,191,186,-1,-1,186,-1,-1,6,6,191,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,5,-1,-1,191,6},
                {6,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,93,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,191,191,186,-1,-1,186,-1,-1,6,6,5,5,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,5,6},
                {6,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,93,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,191,-1,-1,6},
                {6,93,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,191,-1,-1,-1,-1,-1,13,-1,-1,-1,-1,-1,191,-1,-1,6,6,93,-1,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,5,-1,-1,6},
                {6,26,26,26,26,26,26,26,26,26,26,26,26,26,26,26,26,26,26,94,26,26,26,26,26,26,26,6,6,93,-1,-1,186,-1,-1,186,-1,191,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,-1,-1,-1,-1,-1,-1,-1,6,6,26,26,-1,186,-1,-1,186,-1,-1,186,-1,186,-1,186,-1,-1,186,-1,-1,186,-1,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,1,-1,-1,1,-1,-1,1,-1,186,-1,186,-1,-1,1,-1,-1,186,209,-1,6,6,-1,-1,-1,186,-1,-1,186,-1,107,-1,-1,-1,-1,-1,-1,191,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,186,-1,-1,-1,-1,-1,1,-1,-1,6,6,-1,-1,-1,232,-1,-1,232,26,26,26,-1,-1,-1,-1,-1,5,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,191,6,6,200,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,99,100,101,102,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,8,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,93,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,6,6,173,173,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,5,5,5,5,-1,226,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,6,6,173,173,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,-1,-1,-1,-1,5,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,6,6,6,6,173,173,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,226,-1,-1,-1,-1,-1,220,220,220,-1,5,-1,-1,5,-1,-1,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,5,6,6,6,6,6,173,173,226,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,8,8,8,8,-1,-1,8,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,5,-1,-1,6,6,6,6,6,6,173,173,6,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,6,6,6,6,-1,-1,6,6,6,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,226,-1,200,6,6,226,215,-1,5,-1,-1,5,-1,-1,5,-1,191,191,-1,5,-1,-1,-1,6,6,6,6,6,6,173,173,6,6,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,6,6,6,6,11,11,6,6,6,224,224,224,224,224,224,224,224,224,224,224,224,224,-1,5,-1,5,6,6,8,8,-1,-1,-1,-1,-1,-1,-1,-1,-1,8,8,11,11,11,11,11,6,6,6,6,6,6,173,173,6,6,6,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,6,6,6,6,10,10,6,6,6,28,28,28,28,28,28,28,28,28,28,28,28,28,-1,-1,-1,-1,6,6,6,6,174,174,174,174,174,174,174,174,174,6,6,10,10,10,10,10,6,6,6,6,6,6,173,173,6,6,6,6,5,-1,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,6,6,6,6,10,10,6,6,6,28,28,28,28,28,28,28,28,28,28,28,28,28,5,191,-1,-1,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,10,10,10,10,10,6,6,6,6,6,6,173,173,6,6,6,6,6,5,-1,-1,-1,-1,-1,-1,-1,-1,6},
                {6,6,6,6,6,10,10,6,6,6,28,28,28,28,28,28,28,28,28,28,28,28,28,191,191,191,174,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,10,10,10,10,10,6,6,6,6,6,6,173,173,6,6,6,6,6,6,5,-1,-1,-1,-1,-1,-1,-1,6},
                {6,6,6,6,6,10,10,6,6,6,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,28,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,10,10,10,10,10,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6},

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
        Enemy enemy2 = new Enemy();

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 1200, 2700);

        addObject(hero, 100, 4300);
        addObject(enemy1, 1646, 3700);
        addObject(enemy2, 900, 3700);
        
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
        
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }

    @Override
    public void act() {
        ce.update();  
    }

    private void resetStaticVariables() {
        //Alle Hero static variabelen
        Hero.speedPowerup = 0.5;
        Hero.jumpPowerups = 0;
        Hero.totalHealth = 3;
        Hero.redKeyCheck = false;
        Hero.blueKeyCheck = false;
        Hero.greenKeyCheck = false;
        Hero.yellowKeyCheck = false;
        Hero.movementEnabled = true;
        
        //Alle checkpoint static variabelen
        Checkpoints.checkpointX = 100;
        Checkpoints.checkpointY = 4300;
        Hero.score = 0;

    }

}
