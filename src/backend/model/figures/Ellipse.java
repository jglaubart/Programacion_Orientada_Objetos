package backend.model.figures;

import backend.model.Properties.DrawProperties;
import backend.model.builders.FigureBuilder;
import backend.model.interfaces.Drawer;
import backend.model.FiguresPair;

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

    public double getWidth() {
        return axisX;
    }

    public double getHeight() {
        return axisY;
    }

    @Override
    public boolean belongs(Point eventPoint) {
        return ((Math.pow(eventPoint.getX() - this.getCenterPoint().getX(), 2) / Math.pow(this.getWidth(), 2)) +
                (Math.pow(eventPoint.getY() - this.getCenterPoint().getY(), 2) / Math.pow(this.getHeight(), 2))) <= 0.30;
    }
    @Override
    public void draw(Drawer drawer) {
        super.draw(drawer);
        if(this.getDrawProperties().getBeveledState()){
            drawer.drawBeveledEllipse(this.getCenterPoint(), this.getWidth(), this.getHeight());
        }
        drawer.drawEllipse(this.getCenterPoint(), this.getWidth(), this.getHeight());
    }

    @Override
    public void fillGradient(Drawer drawer) {
        DrawProperties properties = this.getDrawProperties();
        drawer.fillRadialGradient(properties.getColor1(), properties.getColor2());
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