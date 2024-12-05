package backend.model.figures;

import backend.model.attributes.Attribute;
import backend.model.interfaces.Drawer;
import backend.model.Properties.DrawProperties;
import backend.model.interfaces.Movable;
import backend.model.interfaces.Transformable;

import java.util.HashSet;
import java.util.Set;

public abstract class Figure implements Movable, Transformable {

    private final Set<Attribute> attributes = new HashSet<>();

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
