package frontend;

import backend.RGBColor;

public class ColorConverter {
    private static final double RGB_RANGE = 255.0;
    public static javafx.scene.paint.Color toJavaFXColor(RGBColor color) {
        return new javafx.scene.paint.Color(color.getRed() / RGB_RANGE, color.getGreen() / RGB_RANGE, color.getBlue() / RGB_RANGE, color.getOpacity());
    }

    public static RGBColor toRGBColor(javafx.scene.paint.Color color) {
        return new RGBColor(color.getRed() * RGB_RANGE, color.getGreen() * RGB_RANGE, color.getBlue() * RGB_RANGE, color.getOpacity());
    }
}
