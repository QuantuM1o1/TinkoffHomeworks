package edu.project4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageToFile {
    public enum ImageFormat { JPEG, BMP, PNG }

    private final static Logger LOGGER = LogManager.getLogger();

    private ImageToFile() {
    }

    public static void saveImage(BufferedImage image, String filePath, ImageFormat format) {
        try {
            File output = new File(filePath);
            switch (format) {
                case JPEG:
                    ImageIO.write(image, "jpg", output);
                    break;
                case BMP:
                    ImageIO.write(image, "bmp", output);
                    break;
                case PNG:
                    ImageIO.write(image, "png", output);
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported image format: " + format);
            }
            LOGGER.info("Image saved successfully to: " + filePath);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't create file");
        }
    }
}
