package Guias.guia4.ej3y4_Movable;

public interface MovableFigure extends Movable {

    MovablePoint[] getPoints();   //devuelve los puntos de la figura original

    @Override
    default void moveNorth(double d){
        for (MovablePoint p : getPoints()) {
            p.moveNorth(d);
        }
    }

    @Override
    default void moveSouth(double d){
        for (MovablePoint p : getPoints()) {
            p.moveSouth(d);
        }
    }

    @Override
    default void moveWest(double d){
        for (MovablePoint p : getPoints()) {
            p.moveWest(d);
        }
    }

    @Override
    default void moveEast(double d){
        for (MovablePoint p : getPoints()) {
            p.moveEast(d);
        }
    }
}
