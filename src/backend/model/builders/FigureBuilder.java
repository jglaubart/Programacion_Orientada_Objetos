package backend.model.builders;

import backend.RGBColor;
import backend.model.Properties.DrawProperties;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);

    default Figure buildFigure(Point startPoint, Point endPoint, RGBColor defaultColor, RGBColor secondaryColor, double offset, RGBColor shadowColor, boolean BeveledState){
        Figure figure = buildFigure(startPoint, endPoint);
        DrawProperties properties = new DrawProperties(defaultColor, secondaryColor, offset, BeveledState);
        figure.setDrawProperties(properties);
        if(offset != 0.0){
            Figure shadow = figure.duplicate(offset);
            shadow.getDrawProperties().setColor1(shadowColor);
            shadow.getDrawProperties().setColor2(null);
            shadow.getDrawProperties().setBeveledState(false);
            shadow.getDrawProperties().setShadowOffset(0.0);
            properties.setShadow(shadow);
        }

        return figure;
    }
}
