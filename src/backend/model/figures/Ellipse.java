package backend.model.figures;

import backend.model.interfaces.Drawer;
import backend.model.FiguresPair;

public class Ellipse extends Figure {

    protected final Point centerPoint;
    protected double axisX, axisY;

    public Ellipse(Point centerPoint, double axisX, double axisY) {
        this.centerPoint = centerPoint;
        this.axisX = axisX;
        this.axisY = axisY;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, DMayor: %.2f, DMenor: %.2f]", centerPoint, axisX, axisY);
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public double getWidth() {
        return axisX;
    }

    public double getHeight() {
        return axisY;
    }

    @Override
    public void move(double dx, double dy) {
        centerPoint.move(dx, dy);
    }

    @Override
    public boolean belongs(Point eventPoint) {
        return ((Math.pow(eventPoint.getX() - this.getCenterPoint().getX(), 2) / Math.pow(this.getWidth(), 2)) +
                (Math.pow(eventPoint.getY() - this.getCenterPoint().getY(), 2) / Math.pow(this.getHeight(), 2))) <= 0.30;
    }
    @Override
    public void draw(Drawer drawer) {
        drawer.drawEllipse(this.getCenterPoint(), this.getWidth(), this.getHeight());
    }

    @Override
    public void rotate() {
        double auxAxis = axisX;
        axisX = axisY;
        axisY = auxAxis;
    }

    @Override
    public void flipX() {
        centerPoint.move(axisX, 0);
    }

    @Override
    public void flipY() {
        centerPoint.move(0, axisY);
    }

    @Override
    public Ellipse duplicate() {
        return new Ellipse(new Point(getCenterPoint().getX() + POS_OFF_SET, getCenterPoint().getY() + POS_OFF_SET), axisX, axisY);
    }

    @Override
    public FiguresPair<Figure, Figure> divide() {
        double newWidth = getWidth() / 2;
        double newHeight = getHeight() / 2;
        Point leftCenter = new Point(getCenterPoint().getX() - newWidth, getCenterPoint().getY());
        Point rightCenter = new Point(getCenterPoint().getX() + newWidth, getCenterPoint().getY());
        Figure left = new Ellipse(leftCenter, newWidth, newHeight);
        Figure right = new Ellipse(rightCenter, newWidth, newHeight);
        return new FiguresPair<>(left, right);
    }
}