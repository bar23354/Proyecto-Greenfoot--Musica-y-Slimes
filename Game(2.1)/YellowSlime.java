import greenfoot.*;

/*
 * Codigo generado por ChatGPT
 * "Genera una clase Java llamada 'YellowSlime' que extienda 'Actor' en el contexto de un juego en Greenfoot. 
 * El slime debe tener variables para su salud, velocidad de movimiento y daño de ataque. 
 * Debe moverse de manera aleatoria de izquierda a derecha en un área determinada. 
 * Implementa la lógica para detectar colisiones con los personajes 'Josue' y 'Natalia'. 
 * Si el slime es atacado por 'Josue' o 'Natalia' mientras está en rango cercano, debe ser eliminado y el contador de 
 * eliminaciones en la clase 'MyWorld' debe incrementarse. Además, el slime debe infligir daño a 'Josue' y 'Natalia' 
 * si entra en contacto con ellos. Utiliza imágenes diferentes para representar el slime en diferentes direcciones. 
 * Asegúrate de que el movimiento cambie de dirección después de un cierto número de pasos."
 */

public class YellowSlime extends Actor {
    private int health = 3;
    private int movementSpeed = 1;
    private int movementCounter = 0;
    private int movementThreshold = 50;
    private boolean isMovingRight = true;
    private GreenfootImage slimeImage1 = new GreenfootImage("YSlime1.png");
    private GreenfootImage slimeImage2 = new GreenfootImage("YSlime2.png");
    private int attackDamage = 1;
    private MyWorld world; // Reference to MyWorld instance

    public YellowSlime(MyWorld world) {
        this.world = world;
        setImage(slimeImage1); // Set initial image
    }

    public void act() {
        moveRandomly();
        checkCollisionWithJosue();
        checkCollisionWithNatalia();
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
            isMovingRight = !isMovingRight; // Reverse the movement direction
            movementCounter = 0; // Reset the counter
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
                world.killCounter.add(1); // Increment the kill count in MyWorld
            } else {
                // Attack Josue when he touches the slime
                josueObject.takeDamage(attackDamage);
            }
        }
    }

    private void checkCollisionWithNatalia() {
        Actor natalia = getOneIntersectingObject(Natalia.class);
        if (natalia != null) {
            // Check if Natalia is currently attacking and the slime is in close range
            Natalia nataliaObject = (Natalia) natalia;
            if (nataliaObject.isAttacking() && getDistance(getX(), getY(), natalia.getX(), natalia.getY()) <= 40) {
                // Slime is killed when Natalia attacks it in close range
                getWorld().removeObject(this);
                world.killCounter.add(1); // Increment the kill count in MyWorld
            } else {
                // Attack Natalia when she touches the slime
                nataliaObject.takeDamage(attackDamage);
            }
        }
    }

    private double getDistance(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

