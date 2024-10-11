package Guias.guia4.ej3y4_Movable;

import Guias.guia4.ej3y4_Movable.Anteriores.Triangle;

public class MovableTriangle extends Triangle implements MovableFigure {

    public MovableTriangle(MovablePoint p1, MovablePoint p2, MovablePoint p3) {
        super(p1, p2, p3);
    }

    public MovablePoint[] getPoints() {
        return new MovablePoint[] {(MovablePoint) firstPoint, (MovablePoint) secondPoint, (MovablePoint) thirdPoint };
    }
}
