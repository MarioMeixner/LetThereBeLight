import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class Render extends Canvas implements Runnable {
    private boolean isRunning;
    private ArrayList<Star> stars;
    private FallingStar fS;

    public Render() {
        super();

        this.isRunning = false;

        this.setSize(new Dimension(1500, 800));

        this.stars = new ArrayList<>();
        this.fS = new FallingStar(this);

        this.letThereBeLight();
    }

    @Override
    public void run() {
        long lastTimeCycle = System.nanoTime();
        long lastTimeOutput = System.currentTimeMillis();
        double unprocessedTicks = 0;
        double nsPerTick = Math.pow(10, 9) / 60;
        int FPS = 0;
        int ticks = 0;

        while (this.isRunning) {
            long nowTimeCycle = System.nanoTime();
            unprocessedTicks += (nowTimeCycle - lastTimeCycle) / nsPerTick;
            lastTimeCycle = nowTimeCycle;

            while (unprocessedTicks >= 1) {
                ticks++;
                unprocessedTicks--;
                this.fS.update();
            }

            FPS++;
            this.render();

            Random rnd = new Random();
            int a = Math.abs(rnd.nextInt(6500 + 2000) - 2000);
            if (a < 6500 && a >= 2000) {
                // if (System.currentTimeMillis() - lastTimeOutput > 1000)
                if (System.currentTimeMillis() - lastTimeOutput > a) {
                    this.fS = new FallingStar(this);
//                    System.out.println("FPS: " + FPS + ", ticks: " + ticks);
                    lastTimeOutput += a;
                    FPS = 0;
                    ticks = 0;
                }
            }
        }
    }

    private void render() {
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = buffer.getDrawGraphics();
        g.setColor(new Color(12, 13, 18));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        for (Star s: this.stars) {
            s.render(g);
        }
        fS.render(g);

        g.dispose();
        buffer.show();
    }

    public void start() {
        this.isRunning = true;
        Thread t = new Thread(this);
        t.start();
    }

    public void letThereBeLight() {
        for (int i = 0; i < 1000; i++)
            this.stars.add(new Star(this));
    }
}
