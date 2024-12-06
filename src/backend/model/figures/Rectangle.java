package backend.model.figures;

import backend.model.Properties.DrawProperties;
import backend.model.interfaces.Drawer;
import backend.model.FiguresPair;

public class Rectangle extends Figure {

    public Rectangle(Point topLeft, Point bottomRight) {
        this.setTopLeft(topLeft);
        this.setBottomRight(bottomRight);
        this.setCenterPoint(new Point((topLeft.getX() + bottomRight.getX()) / 2, (topLeft.getY() + bottomRight.getY()) / 2));
    }

    @Override
    protected double getWidth() {
        return getTopLeft().getX() - getBottomRight().getX();
    }

    @Override
    protected double getHeight() {
        return getTopLeft().getY() - getBottomRight().getY();
    }

    @Override
    public String toString() {
        return String.format("Rectángulo [ %s , %s ]", getTopLeft(), getBottomRight());
    }
    
    @Override
    public boolean belongs(Point eventPoint){
        return eventPoint.getX() > this.getTopLeft().getX() && eventPoint.getX() < this.getBottomRight().getX() &&
                eventPoint.getY() > this.getTopLeft().getY() && eventPoint.getY() < this.getBottomRight().getY();
    }

    @Override
    public void draw(Drawer drawer) {
        super.draw(drawer);
        drawer.drawRectangle(getTopLeft(), getBottomRight());
    }

    @Override
    public void fillGradient(Drawer drawer) {
        DrawProperties properties = this.getDrawProperties();
        drawer.fillLinearGradient(properties.getColor1(), properties.getColor2());
    }

    @Override
    public FiguresPair<Figure, Figure> divide() {
        double dHeight = getHeight() / 4;
        double newBottomRightY = getCenterPoint().getY() - dHeight;
        double newTopLeftY = getCenterPoint().getY() + dHeight;
        return null;//lo termino después
    }
}

