package backend.model.interfaces;

import backend.model.FiguresPair;
import backend.model.figures.Figure;

public interface Transformable {
    void rotate();
    void reflectHorizontal();
    void reflectVertical();
    Figure duplicate();
    FiguresPair<Figure, Figure> divide();
}
