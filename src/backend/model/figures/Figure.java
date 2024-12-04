package backend.model.figures;

import backend.model.Drawer;

public abstract class Figure implements Movable {

    public abstract boolean belongs(Point eventPoint);

    public abstract void draw(Drawer drawer);
}
