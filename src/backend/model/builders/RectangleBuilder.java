package backend.model.builders;

import backend.model.figures.Figure;
import backend.model.Points.Point;
import backend.model.figures.Rectangle;

public class RectangleBuilder implements FigureBuilder{
    public Figure buildFigure(Point startPoint, Point endPoint) {
        return new Rectangle(startPoint, endPoint);
    }
}
