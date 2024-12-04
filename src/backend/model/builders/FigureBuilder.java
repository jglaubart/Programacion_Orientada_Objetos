package backend.model.builders;

import backend.RGBColor;
import backend.model.Properties.DrawProperties;
import backend.model.Properties.ShadowType;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);

    default Figure buildFigure(Point startPoint, Point endPoint, RGBColor defaultColor, RGBColor secondaryColor, ShadowType shadowType, boolean BeveledState){
        Figure figure = buildFigure(startPoint, endPoint);
        DrawProperties properties = new DrawProperties(defaultColor, secondaryColor, shadowType, BeveledState);
        figure.setDrawProperties(properties);
        return figure;
    }
}
