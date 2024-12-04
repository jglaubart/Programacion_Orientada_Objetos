package backend.model.figures;

import backend.model.Drawer;
import backend.model.FiguresPair;

public class Rectangle extends Figure {
    private Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    protected double getWidth() {
        return topLeft.getX() - bottomRight.getX();
    }

    protected double getHeight() {
        return topLeft.getY() - bottomRight.getY();
    }

    protected Point getCenterPoint(){
        return new Point((topLeft.getX() + bottomRight.getX()) / 2, (topLeft.getY() + bottomRight.getY()) / 2);
    }

    @Override
    public String toString() {
        return String.format("Rectángulo [ %s , %s ]", topLeft, bottomRight);
    }
    
    @Override
    public boolean belongs(Point eventPoint){
        return eventPoint.getX() > this.getTopLeft().getX() && eventPoint.getX() < this.getBottomRight().getX() &&
                eventPoint.getY() > this.getTopLeft().getY() && eventPoint.getY() < this.getBottomRight().getY();
    }

    @Override
    public void move(double dx, double dy) {
        topLeft.move(dx, dy);
        bottomRight.move(dx, dy);
    }

    @Override
    public void draw(Drawer drawer) {
        drawer.drawRectangle(topLeft, bottomRight);
    }

    @Override
    public void rotate() {
        double height = getHeight();
        double width = getWidth();
        Point center = getCenterPoint();
        topLeft = new Point(center.getX() - height / 2, center.getY() - width / 2);
        bottomRight = new Point(center.getX() + height / 2, center.getY() + width / 2);
    }

    @Override
    public void flipX() {
        double dx = getWidth();
        topLeft.move(dx,0);
        bottomRight.move(dx,0);
    }

    @Override
    public void flipY() {
        double dy = getHeight();
        topLeft.move(0,dy);
        bottomRight.move(0,dy);
    }

    @Override
    public Rectangle duplicate() {
        Point newTopLeft = new Point(getTopLeft().getX() + POS_OFF_SET, getTopLeft().getY() - POS_OFF_SET);
        Point newBottomRight = new Point(getBottomRight().getX() + POS_OFF_SET, getBottomRight().getY() - POS_OFF_SET);
        return new Rectangle(newTopLeft, newBottomRight);
    }

    @Override
    public FiguresPair<Figure, Figure> divide() {
        double dHeight = getHeight() / 4;
        double newBottomRightY = getCenterPoint().getY() - dHeight;
        double newTopLeftY = getCenterPoint().getY() + dHeight;
        Rectangle leftRectangle = new Rectangle(new Point(getTopLeft().getX(), newTopLeftY), new Point(getCenterPoint().getX(), newBottomRightY));
        Rectangle rightRectangle = new Rectangle(new Point(getCenterPoint().getX(), newTopLeftY), new Point(getBottomRight().getX(), newBottomRightY));
        return new FiguresPair<>(leftRectangle, rightRectangle);
    }
}

