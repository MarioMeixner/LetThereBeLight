import java.util.Random;

public class Vector {
    private double x;
    private double y;
    private Random rnd;

    public Vector(int x, int y) {
        this.rnd = new Random();
        double[] directX;
        double[] directY;
        directX = new double[] {-2, -1.5, -1};
        directY = new double[] {0.3, 0.5, 1, 1.5, 2};
        this.x = directX[this.rnd.nextInt(3)] * x;
        this.y = directY[this.rnd.nextInt(5)] * y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
