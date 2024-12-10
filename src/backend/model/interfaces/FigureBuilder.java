package backend.model.interfaces;

import backend.DrawProperties;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public interface FigureBuilder {

    /**
     * Crea una nueva instancia de la figura correspondiente sólo con sus propiedades geométricas
     */
    Figure buildFigure(Point startPoint, Point endPoint);

    /**
     * Crea una nueva instanica de una figura y le asigna los atributos correspondientes
     */
    default Figure buildFigure(Point startPoint, Point endPoint, DrawProperties properties, Drawer drawer){
        Figure figure = buildFigure(startPoint, endPoint);
        figure.setDrawProperties(properties);
        figure.setDrawer(drawer);

        return figure;
    }
}
