package backend.model.builders;

import backend.model.*;

public class RectangleBuilder {

    public Figure buildFigure(Point startPoint, Point endPoint) {
        return new Rectangle(startPoint, endPoint);
    }
}
