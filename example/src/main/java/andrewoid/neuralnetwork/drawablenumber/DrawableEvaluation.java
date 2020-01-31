package andrewoid.neuralnetwork.drawablenumber;

import andrewoid.neuralnetwork.Network;
import andrewoid.neuralnetwork.Neuron;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class DrawableEvaluation {

    private Network network;
    private JLabel outputLabel;

    public DrawableEvaluation(Network network, JLabel outputLabel) {
        this.network = network;
        this.outputLabel = outputLabel;
    }

    public void evaluate(BufferedImage image) {
        double[] imageBytes = imageToBytes(image);
        Neuron[] outputs = network.evaluate(imageBytes);

        int mostAccurateIndex = 0;
        for (int i = 1; i < outputs.length; i++) {
            if (outputs[i].getValue() > outputs[mostAccurateIndex].getValue()) {
                mostAccurateIndex = i;
            }
        }

        outputLabel.setText(String.valueOf(mostAccurateIndex));
    }

    private double[] imageToBytes(BufferedImage image) {
        int height = image.getHeight();
        int width = image.getWidth();
        double[] pixelColors = new double[height * width];

        int index = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                pixelColors[index] = (double) image.getRGB(x, y);
                index++;
            }
        }
        return pixelColors;
    }
}
