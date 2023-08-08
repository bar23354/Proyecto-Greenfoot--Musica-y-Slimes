import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootSound;

public class Menu extends World {
    FlechaMini flechamini = new FlechaMini();
    private int opcion = 0;
    private int numOptions = 3; // Total number of options in the menu
    private boolean keyProcessed = false; // Flag to track if key has been processed
    private static GreenfootSound music;

    public Menu() {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        if (music == null) {
            music = new GreenfootSound("NamePlease.mp3");
        }
        arreglarMundo();
    }

    private void arreglarMundo() {
        addObject(flechamini, 200, 300);
    }

    public void act() {
        if (!music.isPlaying()) {
            music.playLoop();
        }
        if (!keyProcessed) {
            if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
                opcion--;
                if (opcion < 0)
                    opcion = numOptions - 1;

                keyProcessed = true;
            }

            if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
                opcion++;
                if (opcion >= numOptions)
                    opcion = 0;

                keyProcessed = true;
            }

            if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) {
                switch (opcion) {
                    case 0: //jugar
                        removeObject(flechamini);
                        
                        // Add the background object after removing others
                        Greenfoot.setWorld(new Gamemode());
                        break; // Add the missing 'break' statement
                    case 1: //credits
                        Greenfoot.setWorld(new Gracias());
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
            !Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("enter")) {
            keyProcessed = false;
        }

        flechamini.setLocation(200, 300 + (opcion * 90));
    }
}
