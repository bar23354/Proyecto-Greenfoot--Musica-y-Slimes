import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gamemode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gamemode extends World
{
    FlechaMini flechamini = new FlechaMini();
    private int opcion = 0;
    private int numOptions = 2; // Total number of options in the menu
    private boolean keyProcessed = false; // Flag to track if key has been processed
    /**
     * Constructor for objects of class Gamemode.
     * 
     */
    public Gamemode()
    {    
        super(800, 600, 1);
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        JosuePortrait josuePortrait = new JosuePortrait();
        addObject(josuePortrait,222,175);
        NataliaPortrait nataliaPortrait = new NataliaPortrait();
        addObject(nataliaPortrait,556,371);
        jugador jugador = new jugador();
        addObject(jugador,224,350);
        jugadores jugadores = new jugadores();
        addObject(jugadores,560,552);
        nataliaPortrait.setLocation(572,330);
        jugadores.setLocation(565,502);
        addObject(flechamini, 40, 350);
    }
    
    public void act()
    {
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
                    case 0: //1
                        Greenfoot.setWorld(new Lore());
                        break;
                    case 1: //2
                        Greenfoot.setWorld(new Lore());
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

        if (opcion == 0) { // Option 1 (jugador)
            flechamini.setLocation(40, 350);
        } else if (opcion == 1) { // Option 2 (jugadores)
            flechamini.setLocation(350, 500);
        }
    }
}
