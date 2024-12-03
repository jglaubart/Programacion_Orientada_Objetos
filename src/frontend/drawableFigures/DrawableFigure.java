package frontend.drawableFigures;

import backend.model.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public abstract class DrawableFigure {
    private final Color color;

    public DrawableFigure(Color color) {
        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);
}
