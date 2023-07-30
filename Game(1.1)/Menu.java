import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    Flecha flecha = new Flecha();
    private int opcion = 0;
    private int numOptions = 3; // Total number of options in the menu
    private boolean keyProcessed = false; // Flag to track if key has been processed
    private static GreenfootSound music;

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        if (music == null) {
            music = new GreenfootSound("NamePlease.mp3");
        }
        arreglarMundo();
    }
    
    
    
    private void arreglarMundo()
    {
        addObject(new Jugar(), 400, 200);
        addObject(new Creditos(), 400, 300);
        addObject(new Salir(), 400, 400);
        addObject(flecha, 100, 200);
    }
    
    
    public void act()
    {
        if (!music.isPlaying()) {
        music.playLoop();
        }
        if (!keyProcessed)
        {
            if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up"))
            {
                opcion--;
                if (opcion < 0)
                    opcion = numOptions - 1;
                
                keyProcessed = true;
            }
            
            if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down"))
            {
                opcion++;
                if (opcion >= numOptions)
                    opcion = 0;
                
                keyProcessed = true;
            }
            
            if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter"))
            {
                switch (opcion)
                {
                    case 0: //jugar
                        removeObject(flecha);
                        removeObject(new Jugar());
                        removeObject(new Creditos());
                        removeObject(new Salir());
                        
                        // Add the background object after removing others
                        Greenfoot.setWorld(new Gamemode());
                    case 1: //credits
                        // Handle the credits action here
                        break;
                    case 2: //salir
                        Greenfoot.stop();
                        break;
                }
                
                keyProcessed = true;
            }
        }
        
        // Reset the flag when no keys are pressed
        if (!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("up") &&
            !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("down") &&
            !Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("enter"))
        {
            keyProcessed = false;
        }

        flecha.setLocation(100, 200 + (opcion * 100));
    }
}

