package Guias.guia4.ej3y4_Movable;

import Guias.guia4.ej3y4_Movable.Anteriores.Rectangle;

public class MovableRectangle extends Rectangle implements MovableFigure {

    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        super(topLeft, bottomRight);
    }

    @Override
    public MovablePoint[] getPoints() {
        return new MovablePoint[] {(MovablePoint) topLeft, (MovablePoint) bottomRight};
    }
}