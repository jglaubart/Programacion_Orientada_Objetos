package backend.model.builders;

import backend.model.*;

public class EllipseBuilder implements FigureBuilder {

    @Override
    public Figure buildFigure(Point startPoint, Point endPoint) {
        return new Ellipse(startPoint, Math.abs(endPoint.getX() - startPoint.getX()), Math.abs(endPoint.getY() - startPoint.getY()));
    }
}
