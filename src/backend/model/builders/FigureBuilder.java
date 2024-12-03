package backend.model.builders;

import backend.model.figures.Figure;
import backend.model.Points.Point;

public interface FigureBuilder {
    Figure buildFigure(Point startPoint, Point endPoint);
}
