package backend.model.figures;

import backend.RGBColor;
import backend.model.Drawer;
import backend.model.Properties.DrawProperties;
import backend.model.Properties.ShadowType;
import backend.model.interfaces.Transformable;

public abstract class Figure implements Movable, Transformable {

    private DrawProperties drawProperties;

    public void setDrawProperties(DrawProperties drawProperties) {
        this.drawProperties = drawProperties;
    }

    public DrawProperties getDrawProperties() {
        return drawProperties;
    }

    public abstract boolean belongs(Point eventPoint);

    public abstract void draw(Drawer drawer);

    protected abstract Point getCenterPoint();

    protected abstract double getWidth();

    protected abstract double getHeight();

    //protected abstract drawShadow(ShadowType shadow, RGBColor color, int offset);
}
