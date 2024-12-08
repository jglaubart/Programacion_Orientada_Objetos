package backend.model.builders;

import backend.RGBColor;
import backend.model.Properties.DrawProperties;
import backend.model.ShadowType;
import backend.model.figures.Figure;
import backend.model.figures.Point;
import backend.model.interfaces.Drawer;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);

    default Figure buildFigure(Point startPoint, Point endPoint, DrawProperties properties, Drawer drawer){
        Figure figure = buildFigure(startPoint, endPoint);
        figure.setDrawProperties(properties);
        figure.setDrawer(drawer);
        if(properties.getShadowType() != ShadowType.NONE){
            double offset = properties.getShadowOffset();
            Figure shadow = figure.duplicate(offset);
            shadow.getDrawProperties().setColor1(properties.getShadowColor(drawer));
            shadow.getDrawProperties().setColor2(null);
            shadow.getDrawProperties().setBeveledState(false);
            shadow.getDrawProperties().setShadowType(ShadowType.NONE);
            properties.setShadow(shadow);
        }

        return figure;
    }
}
