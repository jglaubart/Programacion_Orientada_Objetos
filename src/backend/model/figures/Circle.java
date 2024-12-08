package backend.model.figures;

import backend.model.Properties.DrawProperties;
import backend.model.interfaces.Drawer;

public class Circle extends Ellipse {

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius * 2, radius * 2);
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", getCenterPoint(), getRadius());
    }

    public double getRadius() {
        return getHeight() / 2;
    }

    @Override
    public boolean belongs(Point eventPoint){
        return Math.sqrt(Math.pow(this.getCenterPoint().getX() - eventPoint.getX(), 2) +
                Math.pow(this.getCenterPoint().getY() - eventPoint.getY(), 2)) < this.getRadius();
    }
}
