package edu.project4.Image;

import java.awt.image.BufferedImage;

public class ImageDrawer {
    public static final int BITS_REPRESENTING_RED = 16;
    public static final int BITS_REPRESENTING_GREEN = 8;

    private ImageDrawer() {
    }

    public static BufferedImage createImage(Pixel[][] pixels, int xRes, int yRes) {
        BufferedImage image = new BufferedImage(xRes, yRes, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < xRes; i++) {
            for (int j = 0; j < yRes; j++) {
                Pixel pixel = pixels[i][j];
                int rgb = (pixel.getRed() << BITS_REPRESENTING_RED)
                    | (pixel.getGreen() << BITS_REPRESENTING_GREEN)
                    | pixel.getBlue();
                image.setRGB(i, j, rgb);
            }
        }
        return image;
    }
}
