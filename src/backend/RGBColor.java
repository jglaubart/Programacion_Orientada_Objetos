package backend;

public class RGBColor implements Cloneable{
    private double red, green, blue, opacity;
    private static int RGB_GRAY = 128;
    private static int RGB_TRANSPARENT = 0;

    public RGBColor(double red, double green, double blue, double opacity) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.opacity = opacity;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getOpacity() {
        return opacity;
    }

    @Override
    public RGBColor clone() {
        try {
            return (RGBColor) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Object cannot be cloned");
        }
    }

    public static final RGBColor GRAY = new RGBColor(RGB_GRAY, RGB_GRAY, RGB_GRAY, 1);
    public static final RGBColor TRANSPARENT = new RGBColor(RGB_TRANSPARENT, RGB_TRANSPARENT, RGB_TRANSPARENT, RGB_TRANSPARENT);
}
