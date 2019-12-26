package ayeletbuchen;

import javax.swing.*;
import java.awt.*;

public class ResultScreen extends JLabel {

    public ResultScreen() {
        setForeground(Color.BLACK);
        setOpaque(true);
    }

    public void display(String result) {
        setText(result);
    }

    public void clear() {
        clear();
    }
}
