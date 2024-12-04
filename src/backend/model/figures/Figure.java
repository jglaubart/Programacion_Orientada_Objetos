package backend.model.figures;

import backend.RGBColor;
import backend.model.Drawer;
import backend.model.Properties.ShadowType;
import backend.model.interfaces.Transformable;

public abstract class Figure implements Movable, Transformable {

    private ShadowType shadowType;

    private Figure shadow;

    //private DrawProperties;

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

    //protected abstract drawShadow(ShadowType shadow, RGBColor color, int offset);
}
