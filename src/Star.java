import java.awt.*;
import java.util.Random;

public class Star {
    private int xPosition;
    private int yPosition;
    private int diameter;
    private Random rnd;

    public Star(Render l) {
        this.rnd = new Random();

        if (this.rnd.nextFloat() > 0.99) {
            this.diameter = 3;
        } else if (this.rnd.nextFloat() > 0.85 && this.rnd.nextFloat() <= 0.99) {
            this.diameter = 2;
        } else {
            this.diameter = 1;
        }

        this.xPosition = rnd.nextInt(l.getWidth());
        this.yPosition = rnd.nextInt(l.getHeight());
    }

    public void render(Graphics g) {
        switch (this.diameter) {
            case 3:
                g.setColor(new Color(255,255,255));
                break;
            case 2:
                g.setColor(new Color(124, 125, 133));
                break;
            case 1:
                g.setColor(new Color(68, 68, 80));
                break;
        }
        g.fillOval(this.xPosition, this.yPosition, this.diameter, this.diameter);
    }
}
