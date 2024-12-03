package backend.model.builders;

import backend.model.*;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);
}
