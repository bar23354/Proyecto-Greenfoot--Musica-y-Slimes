import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lore extends World
{

    /**
     * Constructor for objects of class Lore.
     * 
     */
    public Lore()
    {    
        super(800, 600, 1);
        Greenfoot.setSpeed(50); // Adjust the speed as needed
        addObject(new VideoPlayer(), getWidth() / 2, getHeight() / 2);    
    }
}
