package andrewoid.neuralnetwork.drawablenumber;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class DrawingComponent extends JComponent {

    private BufferedImage buffImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
    BufferedImage resize = new BufferedImage(28, 28, BufferedImage.TYPE_INT_ARGB);
    private Point startPoint;
    private Point endPoint;
    private Shape line;

    public DrawingComponent() {
        MouseInputAdapter mouseInputAdapter = new MouseInputAdapter() {
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
            }

            public void mouseDragged(MouseEvent e) {
                endPoint = e.getPoint();
                line = new Line2D.Double(startPoint, endPoint);
                startPoint = endPoint;
                drawLines();
            }
        };

        addMouseListener(mouseInputAdapter);
        addMouseMotionListener(mouseInputAdapter);
    }

    public void drawLines() {
        Graphics2D g = (Graphics2D) buffImage.getGraphics();
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(30));
        g.draw(line);
        repaint();
    }

    public void clearImage() {
        Graphics2D g2d = (Graphics2D) buffImage.getGraphics();
        g2d.setBackground(new Color(0, 0, 0, 0));
        g2d.clearRect(buffImage.getMinX(), buffImage.getMinY(), buffImage.getWidth(), buffImage.getHeight());
        g2d = (Graphics2D) resize.getGraphics();
        g2d.setBackground(new Color(0, 0, 0, 0));
        g2d.clearRect(resize.getMinX(), resize.getMinY(), resize.getWidth(), resize.getHeight());
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (buffImage != null) {
            graphics.drawImage(buffImage, 0, 0, null);
            resizeImage();
            graphics.drawImage(resize, getWidth()-28,0, null);
        }
    }

    private Image getImage() {
        return buffImage;
    }

    public Image resizeImage (){
        resize.getGraphics().drawImage(buffImage,0,0,28,28,null);
        return resize;
    }


}
