package frontend.drawableFigures;

import backend.model.figures.Ellipse;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;

public class DrawableEllipse extends DrawableFigure {
    private final Ellipse ellipse;

    public DrawableEllipse(Ellipse ellipse, Color color) {
        super(color);
        this.ellipse = ellipse;
    }

    @Override
    public void draw(GraphicsContext gc){
        double leftLimitX = ellipse.getCenterPoint().getX() - (ellipse.getsMayorAxis() / 2);
        double topLimitY = ellipse.getCenterPoint().getY() - (ellipse.getsMinorAxis() / 2);

        gc.strokeOval(leftLimitX, topLimitY, ellipse.getsMayorAxis(), ellipse.getsMinorAxis());
        gc.fillOval(leftLimitX, topLimitY, ellipse.getsMayorAxis(), ellipse.getsMinorAxis());
    }

}

