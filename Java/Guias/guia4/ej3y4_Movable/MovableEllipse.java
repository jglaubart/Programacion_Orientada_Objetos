package Guias.guia4.ej3y4_Movable;

import Guias.guia4.ej3y4_Movable.Anteriores.Ellipse;

public class MovableEllipse extends Ellipse implements MovableFigure {

    public MovableEllipse(MovablePoint center, double may, double min ) {
        super(center, may, min);
    }

    @Override
    public MovablePoint[] getPoints() {
        return new MovablePoint[] {(MovablePoint) centerPoint};   //centerPoint esta en Ellipse que es la padre
    }
}
