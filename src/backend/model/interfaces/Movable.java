package backend.model.interfaces;

import backend.model.figures.Point;

/**
 * Una clase implementa a la interfaz Movable para
 * indicar que la clase es un objeto que se puede
 * mover en un plano 2D
 */
public interface Movable {

    /**
     * Mueve un objeto en un plano 2D
     */
    void move(double dx, double dy);

    /**
    * Mueve un objeto la distancia entre dos puntos
    * */
    default void moveFromTo(Point startPoint, Point endPoint) {
        this.move(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }
}
