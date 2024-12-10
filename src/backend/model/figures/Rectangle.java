package backend.model.figures;

import backend.DrawProperties;

public class Rectangle extends Figure {

    public Rectangle(Point topLeft, Point bottomRight) {
        this.setTopLeft(topLeft);
        this.setBottomRight(bottomRight);
        this.setCenterPoint(new Point((topLeft.getX() + bottomRight.getX()) / 2, (topLeft.getY() + bottomRight.getY()) / 2));
    }

    @Override
    protected double getWidth() {
        return Math.abs(getTopLeft().getX() - getBottomRight().getX());
    }

    @Override
    protected double getHeight() {
        return Math.abs(getTopLeft().getY() - getBottomRight().getY());
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
    protected void drawFigureGeometry(Point topLeft, Point bottomRight) {
        getDrawer().drawRectangle(topLeft, bottomRight);
    }

    @Override
    protected void drawBeveledFigure() {
        getDrawer().drawBeveledRectangle(getTopLeft(), getBottomRight());
    }

    @Override
    protected void fillGradient() {
        DrawProperties properties = this.getDrawProperties();
        getDrawer().fillLinearGradient(properties.getColor1(), properties.getColor2());
    }
}

