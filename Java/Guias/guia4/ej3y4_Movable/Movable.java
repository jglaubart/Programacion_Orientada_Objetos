package Guias.guia4.ej3y4_Movable;

public interface Movable {

    void moveNorth(double d);

    void moveSouth(double d);

    void moveWest(double d);

    void moveEast(double d);

    default void moveNorthEast(double dx, double dy){
        moveNorth(dx);
        moveEast(dy);
    }

    default void moveNorthWest(double dx, double dy){
        moveNorth(dx);
        moveWest(dy);
    }

    default void moveSouthEast(double dx, double dy){
        moveSouth(dx);
        moveEast(dy);
    }

    default void moveSouthWeast(double dx, double dy){
        moveSouth(dx);
        moveWest(dy);
    }

}

