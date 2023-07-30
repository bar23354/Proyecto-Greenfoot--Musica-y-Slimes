import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Josue josue = new Josue();
        addObject(josue,352,94);
        Natalia natalia = new Natalia();
        addObject(natalia,402,93);
        natalia.setLocation(403,96);
        josue.setLocation(365,95);
        natalia.setLocation(395,92);
        YellowSlime yellowSlime = new YellowSlime();
        addObject(yellowSlime,568,191);
        YellowSlime yellowSlime2 = new YellowSlime();
        addObject(yellowSlime2,169,295);
        YellowSlime yellowSlime3 = new YellowSlime();
        addObject(yellowSlime3,435,439);
    }
}
