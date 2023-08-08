import greenfoot.*;

public class MyWorld extends World {
    private int killCount = 0;

    public MyWorld() {
        super(800, 600, 1);
        prepare();
        showKillCount(); // Display initial kill count
    }

    private void prepare() {
        Josue josue = new Josue();
        addObject(josue, 352, 94);
        Natalia natalia = new Natalia();
        addObject(natalia, 402, 93);
        natalia.setLocation(403, 96);
        josue.setLocation(365, 95);
        natalia.setLocation(395, 92);
        for (int i = 0; i < 5; i++) {
            addObject(new YellowSlime(this), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
    }

    public void updateKillCount() {
        killCount++;
        showKillCount(); // Update and display the kill count
        if (killCount >= 12) {
            GreenfootImage textImage = new GreenfootImage("All Jellies dead!", 24, Color.RED, new Color(0, 0, 0, 0));
            getBackground().drawImage(textImage, 100, getHeight() - 30);
        }
    }

    public void showKillCount() {
        showText("Kill Count: " + killCount, 100, getHeight() - 30);
    }

    public void increaseKillCountByOne() {
        updateKillCount();
    }
}
