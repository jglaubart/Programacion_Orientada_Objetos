package frontend.drawableFigures;

import backend.model.figures.Rectangle;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class DrawableRectangle {
    private final Rectangle rectangle;

    public DrawableRectangle(Rectangle rectangle, Color color) {
        super(color);
        this.rectangle = rectangle;
    }

    @Override
    public void draw(GraphicsContext gc) {
        double topLeftX = rectangle.getTopLeft().getX();
        double topLeftY = rectangle.getTopLeft().getY();
        double bottomRightX = rectangle.getBottomRight().getX();
        double bottomRightY = rectangle.getBottomRight().getY();

        gc.fillRect(topLeftX, topLeftY, Math.abs(topLeftX - bottomRightX), Math.abs(topLeftY - bottomRightY));
        gc.strokeRect(topLeftX, topLeftY, Math.abs(topLeftX - bottomRightX), Math.abs(topLeftY - bottomRightY));
    }
}
