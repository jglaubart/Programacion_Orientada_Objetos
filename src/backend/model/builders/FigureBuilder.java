package backend.model.builders;

import backend.RGBColor;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);

    default Figure buildFigure(Point startPoint, Point endPoint, RGBColor defaultColor, RGBColor secondaryColor, boolean BeveledState){
        Figure figure = buildFigure(startPoint, endPoint);
        figure.setColor(defaultColor);

        return figure;
    }
}
