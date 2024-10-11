package Guias.guia4.ej3y4_Movable;

import Guias.guia4.ej3y4_Movable.Anteriores.Point;

public class MovablePoint extends Point implements Movable {
    public MovablePoint(int x, int y) {
        super(x, y);
    }
    @Override
    public void moveNorth(double d) {
        y += d;
    }

    @Override
    public void moveSouth(double d) {
        y -= d;
    }

    @Override
    public void moveWest(double d) {
        x -= d;
    }

    @Override
    public void moveEast(double d) {
        x += d;
    }
}
