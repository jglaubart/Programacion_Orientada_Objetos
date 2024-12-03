package backend.model.builders;

import backend.model.*;

public class CircleBuilder implements FigureBuilder {

    @Override
    public Figure buildFigure(Point startPoint, Point endPoint) {
        return new Circle(startPoint, Math.abs(endPoint.getX() - startPoint.getX()));
    }
}
