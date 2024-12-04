package backend.model.builders;

import backend.model.figures.Ellipse;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public class EllipseBuilder implements FigureBuilder {

    @Override
    public Figure buildFigure(Point startPoint, Point endPoint) {
        double sMayorAxis = Math.abs(startPoint.getX() - endPoint.getX());
        double sMinorAxis = Math.abs(startPoint.getY() - endPoint.getY());
        Point centerPoint = new Point((startPoint.getX() + sMayorAxis / 2), (startPoint.getY() + sMinorAxis / 2));
        return new Ellipse(centerPoint, sMayorAxis, sMinorAxis);
    }
}
