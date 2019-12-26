package andrewoid.neuralnetwork.MNISTReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IdxReader
{

    public static String inputImagePath;
    public static String inputLabelPath;
    public static String outputPath;

    public IdxReader(String inputImagePath, String inputLabelPath, String outputPath)
    {
        this.inputImagePath = inputImagePath;
        this.inputLabelPath = inputLabelPath;
        this.outputPath = outputPath;
    }

    public void loadFromCompressedFilesToOutputDir() {
        FileInputStream inImage = null;
        FileInputStream inLabel = null;

        if(!pathExist(outputPath)) { createOutputDirectories(outputPath); }
        else {
            /* Simplistic check -- If anything is in here, don't want to reload*/
            if(new File(outputPath + "0").list().length > 0)
            {
                return;
            }
        }

        int[] hashMap = new int[10];

        try
        {
            inImage = new FileInputStream(inputImagePath);
            inLabel = new FileInputStream(inputLabelPath);

            int magicNumberImages = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfImages = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfRows  = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());
            int numberOfColumns = (inImage.read() << 24) | (inImage.read() << 16) | (inImage.read() << 8) | (inImage.read());

            int magicNumberLabels = (inLabel.read() << 24) | (inLabel.read() << 16) | (inLabel.read() << 8) | (inLabel.read());
            int numberOfLabels = (inLabel.read() << 24) | (inLabel.read() << 16) | (inLabel.read() << 8) | (inLabel.read());

            BufferedImage image = new BufferedImage(numberOfColumns, numberOfRows, BufferedImage.TYPE_INT_ARGB);
            int numberOfPixels = numberOfRows * numberOfColumns;
            int[] imgPixels = new int[numberOfPixels];

            for(int i = 0; i < numberOfImages; i++) {

                if(i % 100 == 0) {System.out.println("Number of images extracted: " + i);}

                for(int p = 0; p < numberOfPixels; p++) {
                    int gray = 255 - inImage.read();
                    imgPixels[p] = 0xFF000000 | (gray<<16) | (gray<<8) | gray;
                }

                image.setRGB(0, 0, numberOfColumns, numberOfRows, imgPixels, 0, numberOfColumns);

                int label = inLabel.read();

                hashMap[label]++;
                File outputfile = new File(outputPath + "/" + label + "/" + hashMap[label] + ".png");

                ImageIO.write(image, "png", outputfile);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inImage != null) {
                try {
                    inImage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inLabel != null) {
                try {
                    inLabel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createOutputDirectories(String outputPath)
    {
        File outputDir = new File(outputPath);
        outputDir.mkdir();
        for(int ix = 0; ix < 10; ++ix)
        {
            new File(outputPath + "" + ix).mkdir();
        }
    }

    private boolean pathExist(String outpath)
    {
        return new File(outputPath).exists();
    }

}
