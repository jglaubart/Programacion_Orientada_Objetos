package backend.model.builders;

import backend.model.figures.Ellipse;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public class EllipseBuilder implements FigureBuilder {

    @Override
    public Figure buildFigure(Point startPoint, Point endPoint) {
        double axisX = Math.abs(startPoint.getX() - endPoint.getX());
        double axisY = Math.abs(startPoint.getY() - endPoint.getY());
        Point centerPoint = new Point((startPoint.getX() + axisX / 2), (startPoint.getY() + axisY / 2));
        return new Ellipse(centerPoint, axisX, axisY);
    }
}
