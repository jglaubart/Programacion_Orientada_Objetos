package backend.model.interfaces;

import backend.model.figures.FiguresPair;
import backend.model.figures.Figure;

public interface Transformable<T> {
    void rotate();
    void reflectHorizontal();
    void reflectVertical();
    T duplicate(double offset);
    FiguresPair<Figure, Figure> divide();
}
