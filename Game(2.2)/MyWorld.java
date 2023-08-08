import greenfoot.*;

public class MyWorld extends World {
    public Counter killCounter;
    private int totalSlimes = 12;
    public MyWorld() {
        super(800, 600, 1);
        killCounter = new Counter("Conteo de Jellies: "); 
        prepare();
      }

    private void prepare() {
    Josue josue = new Josue(killCounter); // Pass the killCounter reference
    addObject(josue, 365, 95); // Set the location after adding

    Natalia natalia = new Natalia(killCounter); // Pass the killCounter reference
    addObject(natalia, 395, 92); // Set the location after adding

    addObject(killCounter, 150, getHeight() - 30);

    for (int i = 0; i < 12; i++) {
        addObject(new YellowSlime(this), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
    }
}

