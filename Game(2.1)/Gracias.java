import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gracias extends World {
    private int delayCounter = 0; // Delay counter to wait for a few acts before transitioning

    public Gracias() {
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
    }

    public void act() {
        if (delayCounter > 0) {
            delayCounter--;
            return; // Do nothing until the delay is over
        }

        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Menu());

            delayCounter = 5; // Set a delay of 5 acts before transitioning again
        }
    }
}

