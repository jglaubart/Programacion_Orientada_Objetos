package Guias.guia4.ej3y4_Movable;

import Guias.guia4.ej3y4_Movable.Anteriores.Circle;

public class MovableCircle extends Circle implements MovableFigure {
    public MovableCircle(MovablePoint center, double radius) {
        super(center, radius);
    }

    @Override
    public MovablePoint[] getPoints() {
        return new MovablePoint[] {(MovablePoint) centerPoint};
    }
}
