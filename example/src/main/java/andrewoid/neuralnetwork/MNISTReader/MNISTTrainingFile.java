package andrewoid.neuralnetwork.MNISTReader;

import java.io.File;

public class MNISTTrainingFile
{
    private File file;
    private int value;

    public MNISTTrainingFile(File file, int value)
    {
      this.file = file;
      this.value = value;
    }

    public File getFile()
    {
        return file;
    }

    public int getValue()
    {
        return value;
    }
}
