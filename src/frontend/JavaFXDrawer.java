package frontend;

import backend.RGBColor;
import backend.model.interfaces.Drawer;
import backend.model.figures.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.*;
import javafx.scene.shape.ArcType;

import java.util.Set;

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
    public void drawRectangle(Point topLeft, Point bottomRight) {

        gc.strokeRect(topLeft.getX(), topLeft.getY(), Math.abs(topLeft.getX() - bottomRight.getX()), Math.abs(topLeft.getY() - bottomRight.getY()));
        gc.fillRect(topLeft.getX(), topLeft.getY(), Math.abs(topLeft.getX() - bottomRight.getX()), Math.abs(topLeft.getY() - bottomRight.getY()));
    }

    @Override
    public void fillColor(RGBColor color) {
        gc.setFill(ColorConverter.toJavaFXColor(color));
    }

    @Override
    public void fillLinearGradient(RGBColor color1, RGBColor color2) {
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, ColorConverter.toJavaFXColor(color1)),
                new Stop(1, ColorConverter.toJavaFXColor(color2)));
        gc.setFill(linearGradient);
    }

    @Override
    public void fillRadialGradient(RGBColor color1, RGBColor color2) {
        RadialGradient radialGradient = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, ColorConverter.toJavaFXColor(color1)),
                new Stop(1, ColorConverter.toJavaFXColor(color2)));
        gc.setFill(radialGradient);
    }

    @Override
    public void drawBeveledRectangle(Point topLeft, Point bottomRight) {
        Paint normalLineColor = gc.getStroke();
        double normalLineWidth = gc.getLineWidth();

        double x = topLeft.getX();
        double y = topLeft.getY();
        double width = Math.abs(x - bottomRight.getX());
        double height = Math.abs(y - bottomRight.getY());
        gc.setLineWidth(10);
        gc.setStroke(Color.LIGHTGRAY);
        gc.strokeLine(x, y, x + width, y);
        gc.strokeLine(x, y, x, y + height);
        gc.setStroke(Color.BLACK);
        gc.strokeLine(x + width, y, x + width, y + height);
        gc.strokeLine(x, y + height, x + width, y + height);

        gc.setStroke(normalLineColor);
        gc.setLineWidth(normalLineWidth);
    }

    @Override
    public void drawBeveledEllipse(Point centerPoint, double axisX, double axisY) {
        Paint normalLineColor = gc.getStroke();
        double normalLineWidth = gc.getLineWidth();

        double arcX = centerPoint.getX() - axisX / 2;
        double arcY = centerPoint.getY() - axisY / 2;
        gc.setLineWidth(10);
        gc.setStroke(Color.LIGHTGRAY);
        gc.strokeArc(arcX, arcY, axisX, axisY, 45, 180, ArcType.OPEN);
        gc.setStroke(Color.BLACK);
        gc.strokeArc(arcX, arcY, axisX, axisY, 225, 180, ArcType.OPEN);

        gc.setStroke(normalLineColor);
        gc.setLineWidth(normalLineWidth);
    }
}
