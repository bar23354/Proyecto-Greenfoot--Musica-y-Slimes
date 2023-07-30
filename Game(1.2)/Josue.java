import greenfoot.*;

public class Josue extends Actor {
    private String currentAnimation = "JDown"; // Default walking animation
    private int animationDelay = 20;
    private int currentFrame = 1;
    private String idleImage = "JDown1.png";

    private int attackDuration = 20; // The duration for which attack animation will be displayed
    private int attackTimer = 0; // Timer to keep track of the attack animation duration
    private int attackDamage = 1; // The amount of damage Josue can inflict on enemies when attacking

    private int health = 5;

    private boolean isMoving = false; // To track if the character is moving
    private boolean canAttack = true; // To track if the character can attack
    private boolean isAttacking = false; // To track if Josue is attacking

    private final int attackRange = 200; // The attack range in pixels
    private final int attackWidth = 200; // The attack width in pixels (rectangular width)

    public void act() {
        checkKeyPress();
        animateCharacter();
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            // Josue is killed when his health reaches 0 or below
            getWorld().removeObject(this);
        }
    }

    private void checkKeyPress() {
        int moveSpeed = 3;
        isMoving = false; // Reset the isMoving flag at the start of the method

        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("W")) {
            setLocation(getX(), getY() - moveSpeed);
            isMoving = true;
            currentAnimation = "JUp";
        } else if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("A")) {
            setLocation(getX() - moveSpeed, getY());
            isMoving = true;
            currentAnimation = "JLeft";
        } else if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("S")) {
            setLocation(getX(), getY() + moveSpeed);
            isMoving = true;
            currentAnimation = "JDown";
        } else if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("D")) {
            setLocation(getX() + moveSpeed, getY());
            isMoving = true;
            currentAnimation = "JRight";
        }

        if (Greenfoot.isKeyDown("space")) {
            if (!isMoving && canAttack && attackTimer == 0) {
                attackTimer = attackDuration; // Set the attack duration timer to display the attack animation
                int hitboxOffsetX = 0;
                int hitboxOffsetY = 0;
                if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("W")) {
                    currentAnimation = "JUpAttack";
                    hitboxOffsetY = -40;
                } else if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("A")) {
                    currentAnimation = "JLeftAttack";
                    hitboxOffsetX = -40;
                } else if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("S")) {
                    currentAnimation = "JDownAttack";
                    hitboxOffsetY = 40;
                } else if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("D")) {
                    currentAnimation = "JRightAttack";
                    hitboxOffsetX = 40;
                }
                Hitbox hitbox = new Hitbox(getX() + hitboxOffsetX, getY() + hitboxOffsetY);
                getWorld().addObject(hitbox, getX() + hitboxOffsetX, getY() + hitboxOffsetY);
                canAttack = false; // Set the flag to prevent immediate attacks
                isAttacking = true; // Set the flag to indicate Josue is attacking
            }
        } else {
            canAttack = true; // Reset the flag so the character can attack again
            isAttacking = false; // Reset the flag when Josue stops attacking
        }
    }

    private int walkingFrame = 1;
    private int attackFrame = 1;
    private int delayCounter = 0;

    private void animateCharacter() {
        int frameCount = 2; // Assuming 2 frames for walking and attack animations

        if (attackTimer > 0) {
            // Attack animation
            String attackAnimation = currentAnimation + "Attack" + attackFrame + ".png";
            GreenfootImage frameImage = new GreenfootImage(attackAnimation);
            setImage(frameImage);

            attackTimer--;

            // Reset the animation when attackTimer reaches 0
            if (attackTimer == 0) {
                currentAnimation = currentAnimation.replace("Attack", "");
                setImage(idleImage);
                attackFrame = 1; // Reset the attack frame to 1 for the next attack
            } else if (attackTimer % (attackDuration / frameCount) == 0) {
                // Update the attackFrame to display the next frame of the attack animation
                attackFrame++;
            }
        } else {
            // Walking animation
            delayCounter++;
            if (delayCounter >= animationDelay) {
                walkingFrame++;
                delayCounter = 0; // Reset the counter
            }

            if (walkingFrame > frameCount) {
                walkingFrame = 1;
            }

            String walkingAnimation = currentAnimation + walkingFrame + ".png";
            GreenfootImage frameImage = new GreenfootImage(walkingAnimation);
            setImage(frameImage);
        }
    }

    public boolean isAttacking() {
        return isAttacking;
    }
}


