package frontend;

import backend.model.interfaces.Drawer;
import backend.model.figures.Point;
import javafx.scene.canvas.GraphicsContext;

public class JavaFXDrawer implements Drawer {
    private GraphicsContext gc;

    public JavaFXDrawer(GraphicsContext gc){
        this.gc = gc;
    }

    @Override
    public void drawEllipse(Point centerPoint, double axisX, double axisY) {
        gc.strokeOval(centerPoint.getX() - axisX / 2, centerPoint.getY() - axisY / 2, axisX, axisY);
        gc.fillOval(centerPoint.getX() - axisX / 2, centerPoint.getY() - axisY / 2, axisX, axisY);
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
