import greenfoot.*;

public class YellowSlime extends Actor {
    private int health = 3; // The initial health of the slime
    private int movementSpeed = 1;
    private int movementCounter = 0;
    private int movementThreshold = 50;
    private boolean isMovingRight = true;
    private GreenfootImage slimeImage1 = new GreenfootImage("YSlime1.png");
    private GreenfootImage slimeImage2 = new GreenfootImage("YSlime2.png");
    private int attackDamage = 1;

    public void act() {
        moveRandomly();
        checkCollisionWithJosue();
    }

    private void moveRandomly() {
        if (isMovingRight) {
            setImage(slimeImage1);
            move(movementSpeed);
        } else {
            setImage(slimeImage2);
            move(-movementSpeed);
        }

        movementCounter++;
        if (movementCounter >= movementThreshold) {
            isMovingRight = Greenfoot.getRandomNumber(2) == 0; // Randomly change direction
            movementCounter = 0;
        }
    }

    private void checkCollisionWithJosue() {
        Actor josue = getOneIntersectingObject(Josue.class);
        if (josue != null) {
            // Check if Josue is currently attacking and the slime is in close range
            Josue josueObject = (Josue) josue;
            if (josueObject.isAttacking() && getDistance(getX(), getY(), josue.getX(), josue.getY()) <= 40) {
                // Slime is killed when Josue attacks it in close range
                getWorld().removeObject(this);
            } else {
                // Attack Josue when he touches the slime
                josueObject.takeDamage(attackDamage);
            }
        }
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            // Slime is killed when its health reaches 0 or below
            getWorld().removeObject(this);
        }
    }
}






