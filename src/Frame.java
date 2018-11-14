import javax.swing.JFrame;

public class Frame {

    private static final String TITLE = "STARGAZING";
    private static final int WIDTH = 1500;
    private static final int HEIGHT = 800;


    public static void main(String[] args) {

        JFrame frame = new JFrame(TITLE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        Render layer = new Render();
        frame.add(layer);
        layer.start();
    }
}
