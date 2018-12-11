
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class FlyEnemy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    GreenfootImage fly1 = new GreenfootImage("Enemies/flyFly1.png");
    GreenfootImage fly2 = new GreenfootImage("Enemies/flyFly2.png");
    public FlyEnemy() {
        super();
        setImage(fly1);
        getImage().mirrorHorizontally();
        walkRange = 140;
        firstAct = true;
        speed = 1;
    }

    @Override
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
            getImage().mirrorHorizontally();
        }

    }
}
