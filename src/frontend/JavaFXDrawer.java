package frontend;

import backend.model.Drawer;
import backend.model.figures.Point;
import javafx.scene.canvas.GraphicsContext;

public class JavaFXDrawer implements Drawer {
    private GraphicsContext gc;

    public JavaFXDrawer(GraphicsContext gc){
        this.gc = gc;
    }

    @Override
    public void drawEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis) {
        gc.strokeOval(centerPoint.getX() - sMayorAxis / 2, centerPoint.getY() - sMinorAxis / 2, sMayorAxis, sMinorAxis);
        gc.fillOval(centerPoint.getX() - sMayorAxis / 2, centerPoint.getY() - sMinorAxis / 2, sMayorAxis, sMinorAxis);
    }

    @Override
    public void drawCircle(Point centerPoint, double diameter) {
        this.drawEllipse(centerPoint, diameter, diameter);
    }

    @Override
    public void drawRectangle(Point topLeft, Point bottomRight) {
        gc.strokeRect(topLeft.getX(), topLeft.getY(), Math.abs(topLeft.getX() - bottomRight.getX()), Math.abs(topLeft.getY() - bottomRight.getY()));
        gc.fillRect(topLeft.getX(), topLeft.getY(), Math.abs(topLeft.getX() - bottomRight.getX()), Math.abs(topLeft.getY() - bottomRight.getY()));
    }
}
