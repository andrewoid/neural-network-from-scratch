package andrewoid.neuralnetwork.drawablenumber;

import andrewoid.neuralnetwork.Network;
import andrewoid.neuralnetwork.NetworkFactory;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;

public class DrawableNumberFrame extends JFrame {

    private Network network = null;
    private DrawingComponent drawingComponent;
    private DrawableEvaluation evaluation;

    public DrawableNumberFrame() {
        try {
            network = new NetworkFactory().loadFromJSON("network.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JPanel outputPanel = new JPanel();
        JLabel outputLabel = new JLabel("Here is Your Number");
        evaluation = new DrawableEvaluation(network, outputLabel);
        drawingComponent = new DrawingComponent(evaluation);

        setTitle("Draw a Number");
        setSize(780, 680);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        JButton clearButton = new JButton("Clear");
        root.add(clearButton, BorderLayout.SOUTH);

        JPanel drawablePanel = new JPanel();
        drawablePanel.setLayout(new BorderLayout());
        drawablePanel.setBackground(Color.PINK);
        JLabel drawableLabel = new JLabel("Draw Your Number Here");
        drawableLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        drawablePanel.add(drawableLabel, BorderLayout.NORTH);
        drawablePanel.add(drawingComponent, BorderLayout.CENTER);

        outputPanel.setBackground(Color.YELLOW);
        outputLabel.setFont(new Font("Sans Serif", Font.BOLD, 16));
        outputPanel.add(outputLabel);

        root.add(drawablePanel, BorderLayout.CENTER);
        root.add(outputPanel, BorderLayout.EAST);

        clearButton.addActionListener(e -> drawingComponent.clearImage());

        setContentPane(root);
        root.setVisible(true);
    }
}
