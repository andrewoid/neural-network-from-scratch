package andrewoid.neuralnetwork.MNISTReader;

public class ReaderLoading {
    public static final String inputImagePath = "train-images-idx3-ubyte";
    public static final String inputLabelPath = "train-labels-idx1-ubyte";
    public static final String outputPath = "MNISTOutputFiles/";

    public static void  main(String[] args)
    {
        IdxReader reader = new IdxReader(inputImagePath,inputLabelPath,outputPath);
        reader.loadFromCompressedFilesToOutputDir();
    }
}
