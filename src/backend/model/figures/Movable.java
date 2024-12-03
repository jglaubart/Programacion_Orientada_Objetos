package backend.model.figures;

import backend.model.Points.Point;

public interface Movable {
    abstract void move(double deltaX, double deltaY);
    default void changePosition(Point startPoint, Point endPoint) {
        this.move(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }
}
