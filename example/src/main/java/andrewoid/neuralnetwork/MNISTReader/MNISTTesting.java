package andrewoid.neuralnetwork.MNISTReader;

import andrewoid.neuralnetwork.Network;
import andrewoid.neuralnetwork.NetworkFactory;
import andrewoid.neuralnetwork.Neuron;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class MNISTTesting {
    private static final String testingInputImagePath = "t10k-images-idx3-ubyte";
    private static final String testingInputLabelPath = "t10k-labels-idx1-ubyte";

    public static void main(String args[])
    {
        Network network = null;
        try {
            network = new NetworkFactory().loadFromJSON("mnist.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        IdxReader reader = new IdxReader(testingInputImagePath, testingInputLabelPath,"");

        Iterator<MNISTTrainingFile> iterator = reader.iterator();
        int totalImages = 0;
        int correctEvaluation = 0;
        Neuron[] outputs;
        while(iterator.hasNext())
        {
            totalImages++;
            MNISTTrainingFile next = iterator.next();
            outputs =  network.evaluate(next.getImgPixelsAsDoubles());

            int mostAccurateIndex = 0;
            for (int i = 1; i < outputs.length; i++) {
                if (outputs[i].getValue() > outputs[mostAccurateIndex].getValue()) {
                    mostAccurateIndex = i;
                }
            }

            if (mostAccurateIndex == next.getLabel()) {
                correctEvaluation++;
            }
        }
        System.out.printf("total images: %d\ncorrect images: %d\nsuccess rate: %.2f%%", totalImages, correctEvaluation, ((double) correctEvaluation)/((double) totalImages) * 100);
    }

}
