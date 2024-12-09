package backend.model.builders;

import backend.model.figures.Circle;
import backend.model.figures.Figure;
import backend.model.figures.Point;
import backend.model.interfaces.FigureBuilder;

public class CircleBuilder implements FigureBuilder {

    @Override
    public Figure buildFigure(Point startPoint, Point endPoint) {
        return new Circle(startPoint, Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) + Math.pow(endPoint.getY() - startPoint.getY(), 2)));
    }
}
