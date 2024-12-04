package backend.model.figures;

import backend.RGBColor;
import backend.model.Drawer;
import backend.model.interfaces.Transformable;

public abstract class Figure implements Movable, Transformable {
    static final int OFF_SET = 1;
    private RGBColor color;

    public abstract boolean belongs(Point eventPoint);

    public abstract void draw(Drawer drawer);

    public void setColor(RGBColor color) {
        this.color = color;
    }

    public RGBColor getColor() {
        return this.color;
    }

    protected abstract Point getCenterPoint();

    protected abstract double getWidth();

    protected abstract double getHeight();
}
