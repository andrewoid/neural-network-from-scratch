package ayeletbuchen;

import andrewoid.neutralnetwork.Network;
import andrewoid.neutralnetwork.Neuron;

import javax.swing.*;
import java.util.Arrays;

public class EvaluateButton extends JButton {

    private Network network;

    public EvaluateButton(Network network) {
        this.network = network;
        setText("Evaluate");
    }

    public void evaluate(double[] input) {
        // test the network on the input sets, printing out everything that evaluates to greater than 10%
            Neuron[] outputs = network.evaluate(input);
            System.out.print(Arrays.toString(input));
            System.out.print(" = ");
            for (int i = 0; i < outputs.length; i++) {
                double value = outputs[i].getValue();
                if (value > 0.10) {
                    System.out.print(i);
                    System.out.print(" ");
                }
            }
            System.out.println();
    }
}
