import greenfoot.*;

public class VideoPlayer extends Actor {
    private int currentFrame = 1;
    private int totalFrames = 40; // Replace 40 with the total number of image frames you have
    private int frameDelay = 30; // Adjust this value to control the delay (30 acts = 0.5 seconds)
    private GreenfootImage[] frames; // Array to store the frames

    public VideoPlayer() {
        // Initialize the frames array
        frames = new GreenfootImage[totalFrames];
        for (int i = 0; i < totalFrames; i++) {
            frames[i] = new GreenfootImage("images/Video/Diapositiva" + (i + 1) + ".PNG");
            frames[i].scale(800, 600); // Set the size of each frame to match the world size
        }
        setImage(frames[0]); // Set the initial image
    }

    public void act() {
        if (currentFrame <= totalFrames) {
            if (frameDelay == 0) {
                setImage(frames[currentFrame - 1]);
                currentFrame++;
                frameDelay = 30; // Reset the frame delay (30 acts = 0.5 seconds)
            } else {
                frameDelay--;
            }
        } else {
            // Switch to the next world after the "video" ends
            Greenfoot.setWorld(new MyWorld());
        }
    }
}


