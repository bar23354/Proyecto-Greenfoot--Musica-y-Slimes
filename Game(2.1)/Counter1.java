import greenfoot.*;

public class Counter1 extends Actor {
    private String prefix;
    private int value;

    public Counter1(String prefix) {
        this.prefix = prefix;
        this.value = 0;
        updateImage();
    }

    public void add(int amount) {
        value += amount;
        updateImage();
    }

    public void updateImage() {
    setImage(new GreenfootImage(prefix + value, 24, Color.WHITE, Color.BLACK)); // Change transparent color to black
    }
}

