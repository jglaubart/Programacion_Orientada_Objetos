package backend.model.builders;

import backend.model.*;

public class SquareBuilder implements FigureBuilder {

    @Override
    public Figure buildFigure(Point startPoint, Point endPoint) {
        return new Square(startPoint, Math.abs(endPoint.getX() - startPoint.getX()));
    }
}
