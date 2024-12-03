package backend.model.figures;

public abstract class Figure implements Movable {

    public abstract boolean belongs(Point eventPoint);
}
