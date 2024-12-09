package backend.model.interfaces;

import backend.DrawProperties;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);

    default Figure buildFigure(Point startPoint, Point endPoint, DrawProperties properties, Drawer drawer){
        Figure figure = buildFigure(startPoint, endPoint);
        figure.setDrawProperties(properties);
        figure.setDrawer(drawer);

        return figure;
    }
}
