package backend.model.figures;

import backend.DrawProperties;

public class Ellipse extends Figure {

    private double axisX, axisY;

    public Ellipse(Point centerPoint, double axisX, double axisY) {
        this.setCenterPoint(centerPoint);
        this.setTopLeft(new Point(centerPoint.getX() - axisX / 2, centerPoint.getY() - axisY / 2));
        this.setBottomRight(new Point(centerPoint.getX() + axisX / 2, centerPoint.getY() + axisY / 2));
        this.axisX = axisX;
        this.axisY = axisY;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, DMayor: %.2f, DMenor: %.2f]", getCenterPoint(), axisX, axisY);
    }

    protected double getWidth() {
        return axisX;
    }

    protected double getHeight() {
        return axisY;
    }

    @Override
    public boolean belongs(Point eventPoint) {
        return ((Math.pow(eventPoint.getX() - this.getCenterPoint().getX(), 2) / Math.pow(this.getWidth(), 2)) +
                (Math.pow(eventPoint.getY() - this.getCenterPoint().getY(), 2) / Math.pow(this.getHeight(), 2))) <= 0.30;
    }
    @Override
    protected void drawFigureGeometry(Point topLeft, Point bottomRight) {
        Point centerPoint = new Point((topLeft.getX() + bottomRight.getX()) / 2, (topLeft.getY() + bottomRight.getY()) / 2);
        double axisX = Math.abs(topLeft.getX() - bottomRight.getX());
        double axisY = Math.abs(topLeft.getY() - bottomRight.getY());
        getDrawer().drawEllipse(centerPoint, axisX, axisY);
    }

    @Override
    protected void drawBeveledFigure(){
        getDrawer().drawBeveledEllipse(this.getCenterPoint(), this.getWidth(), this.getHeight());
    }

    @Override
    protected void fillGradient() {
        DrawProperties properties = this.getDrawProperties();
        getDrawer().fillRadialGradient(properties.getColor1(), properties.getColor2());
    }

    @Override
    public void setTopLeft(Point topLeft) {
        super.setTopLeft(topLeft);
        if(this.getBottomRight() == null) return;
        this.axisX = Math.abs(topLeft.getX() - this.getBottomRight().getX());
        this.axisY = Math.abs(topLeft.getY() - this.getBottomRight().getY());
    }

    @Override
    public void setBottomRight(Point bottomRight) {
        super.setBottomRight(bottomRight);
        if(this.getTopLeft() == null) return;
        this.axisX = Math.abs(this.getTopLeft().getX() - bottomRight.getX());
        this.axisY = Math.abs(this.getTopLeft().getY() - bottomRight.getY());
    }
}