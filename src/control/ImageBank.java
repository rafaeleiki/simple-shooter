package control;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageBank {

    private static HashMap<String, Image> images;

    static {
        images = new HashMap<>();
    }

    public static Image getImage(String filename) {
        Image image;

        if (images.containsKey(filename)) {
            image = images.get(filename);
        } else {
            image = readImageFromFile(filename);
        }

        return image;
    }

    private static Image readImageFromFile(String filename) {
        File imageFile = new File(filename);
        Image image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

}
