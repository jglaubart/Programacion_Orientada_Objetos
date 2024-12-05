package backend.model.interfaces;

import backend.model.figures.Point;

public interface Movable {
    abstract void move(double dx, double dy);

    default void changePosition(Point startPoint, Point endPoint) {
        this.move(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }
}
