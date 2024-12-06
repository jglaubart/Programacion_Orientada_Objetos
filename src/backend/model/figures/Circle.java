package backend.model.figures;

import backend.model.Properties.DrawProperties;
import backend.model.interfaces.Drawer;

public class Circle extends Ellipse {

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius, radius);
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", getCenterPoint(), getRadius());
    }

    public double getRadius() {
        return getHeight();
    }

    @Override
    public boolean belongs(Point eventPoint){
        return Math.sqrt(Math.pow(this.getCenterPoint().getX() - eventPoint.getX(), 2) +
                Math.pow(this.getCenterPoint().getY() - eventPoint.getY(), 2)) < this.getRadius();
    }

    @Override
    public void draw(Drawer drawer) {
        super.draw(drawer);
        drawer.drawCircle(this.getCenterPoint(), this.getRadius() * 2);
    }
}
