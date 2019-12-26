package ayeletbuchen;

import javax.swing.*;
import java.awt.*;

public class DigitFrame extends JFrame {

    final static int WIDTH = 825;
    final static int HEIGHT = 800;

    public DigitFrame() {
        setTitle("Neural Network");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel(new BorderLayout());
        root.add(new Digit(), BorderLayout.CENTER);

        setContentPane(root);
    }
}
