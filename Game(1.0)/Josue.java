import greenfoot.*;

public class Josue extends Actor {
    private String currentAnimation = "";
    private int animationDelay = 10;
    private int currentFrame = 1;
    private String idleImage = "JDown1.png";

    private int cooldownTimer = 0;
    private int cooldownDelay = 120;

    public void act() {
        checkKeyPress();
        cooldownTimer--;
    }

    private void checkKeyPress() {
        int moveSpeed = 18;
        boolean isMoving = false;

        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("W")) {
            setLocation(getX(), getY() - moveSpeed);
            isMoving = true;
            currentAnimation = "JUp";
        }
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("A")) {
            setLocation(getX() - moveSpeed, getY());
            isMoving = true;
            currentAnimation = "JLeft";
        }
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("S")) {
            setLocation(getX(), getY() + moveSpeed);
            isMoving = true;
            currentAnimation = "JDown";
        }
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("D")) {
            setLocation(getX() + moveSpeed, getY());
            isMoving = true;
            currentAnimation = "JRight";
        }

        if (isMoving) {
            animateCharacter();
        } else {
            setImage(idleImage);
        }
    }

    private void animateCharacter() {
        int frameCount = 2;

        if (currentFrame > frameCount) {
            currentFrame = 1;
        }

        GreenfootImage frameImage = new GreenfootImage(currentAnimation + currentFrame + ".png");
        setImage(frameImage);

        if (getWorld() != null) {
            getWorld().repaint();
            Greenfoot.delay(animationDelay);

            currentFrame++;
        }
    }
}
