package andrewoid.neuralnetwork.digit_ui;

import andrewoid.neutralnetwork.Network;
import andrewoid.neutralnetwork.NetworkFactory;

public class DigitInteraction {

    public static void main(String[] args) {
        Network network = new NetworkFactory().loadFromJSON("network.json");
        new DigitFrame(network).setVisible(true);
    }
}
