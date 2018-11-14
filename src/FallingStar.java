import java.awt.*;
import java.util.Random;

public class FallingStar {

    private int xPosition;
    private int yPosition;

    private Vector directionVector;

    private static final int HEIGHT = 2;
    private static final int WIDTH = 2;
    private Random rnd;

    public FallingStar(Render r) {
        this.rnd = new Random();
        int x = rnd.nextInt(r.getWidth()) + 1000;
        int y = Math.abs(rnd.nextInt(r.getHeight()) - 100);
        this.xPosition = rnd.nextInt(x);
        this.yPosition = rnd.nextInt(y);

        int speed = 17;
        this.directionVector = new Vector(speed, speed);
    }

    public void render(Graphics g) {
        g.setColor(new Color(200, 201, 207));
        g.fillRect(this.xPosition, this.yPosition, WIDTH, HEIGHT);
    }

    public void update() {
        this.xPosition += this.directionVector.getX();
        this.yPosition += this.directionVector.getY();
    }
}