import greenfoot.*;
import java.util.List;

public class Hitbox extends Actor {
    private int width;
    private int height;

    // Constructor that accepts x, y, width, and height as arguments
    public Hitbox(int x, int y, int width, int height) {
        setLocation(x, y);
        this.width = width;
        this.height = height;
        GreenfootImage image = new GreenfootImage(width, height);
        setImage(image);
    }

    // Public method to get a list of YellowSlime objects within the hitbox range
    public List<YellowSlime> getSlimesInRange() {
        return getObjectsInRange(width / 2, YellowSlime.class);
    }
}





