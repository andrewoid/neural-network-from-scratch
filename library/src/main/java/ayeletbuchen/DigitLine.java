package ayeletbuchen;

import javax.swing.*;
import java.awt.*;

public class DigitLine extends JLabel {

    private int status;
    private final int OFF = 0;
    private final int ON = 1;
    private final Color OFF_COLOR = Color.BLACK;
    private final Color ON_COLOR = Color.GREEN;
    private int id;

    public DigitLine(int id, int width, int height) {
        this.id = id;
        status = OFF;
        setBackground(OFF_COLOR);
        setSize(width,height);
        setOpaque(true);
    }

    public void changeStatus() {
        if (status == OFF) {
            status = ON;
            setBackground(ON_COLOR);
        } else {
            status = OFF;
            setBackground(OFF_COLOR);
        }
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }
}
