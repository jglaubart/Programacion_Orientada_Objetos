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

        return figure;
    }
}
