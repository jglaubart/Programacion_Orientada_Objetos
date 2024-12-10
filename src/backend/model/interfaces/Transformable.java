package backend.model.interfaces;

import backend.model.figures.FiguresPair;
import backend.model.figures.Figure;

/**
 * Toda clase que implemente la interfaz Transformable se puede
 * utilizar para realizar rotaciones, espejados, replicas y divisiones
 * geometricas.
 */
public interface Transformable<T> {
    /**
     * Rota un objeto
     */
    void rotate();

    /**
     * Espeja un objeto horizontalmente
     */
    void reflectHorizontal();

    /**
     * Espeja un objeto verticalmente
     */
    void reflectVertical();

    /**
     * Crea una replica de un objeto
     */
    T duplicate(double offset);

    /**
     * Divide un objeto en dos distintos
     */
    FiguresPair<Figure, Figure> divide();
}
