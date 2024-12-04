package backend.model.figures;

import backend.RGBColor;
import backend.model.Drawer;
import backend.model.Properties.DrawProperties;
import backend.model.interfaces.Transformable;

public abstract class Figure implements Movable, Transformable {
    static final double POS_OFF_SET = 1;
    static final double NEG_OFF_SET = -POS_OFF_SET;

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
