package characters;

import visual.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCharacter implements Unit, Drawable {

    private static final int DIMENSION = 50;
    private float x;
    private float y;
    private BufferedImage image;

    public GameCharacter(float x, float y, Image image) {
        this.x = x;
        this.y = y;
        this.image = createResizedImage(image);
//        this.image = (BufferedImage) image;
    }

    @Override
    public Rectangle getArea() {
        return new Rectangle((int) x, (int) y, DIMENSION, DIMENSION);
    }

    @Override
    public boolean hasCollided(Unit u) {
        return u.getArea().intersects(this.getArea());
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) x, (int) y, null);
    }

    public void walk(float x, float y) {
        this.x += x;
        this.y += y;
    }

    private BufferedImage createResizedImage(Image originalImage) {
        BufferedImage resizedImage = new BufferedImage(DIMENSION, DIMENSION, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, DIMENSION, DIMENSION, null);
        g.dispose();
        return resizedImage;
    }
}
