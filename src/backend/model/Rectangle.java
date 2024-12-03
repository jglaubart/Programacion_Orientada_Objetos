package backend.model;

public class Rectangle extends Figure {

    protected final Point topLeft, bottomRight;

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

    @Override
    public String toString() {
        return String.format("Rectángulo [ %s , %s ]", topLeft, bottomRight);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        topLeft.move(deltaX, deltaY);
        bottomRight.move(deltaX, deltaY);
    }

    public static Rectangle build(Point startPoint, Point endPoint){
        return new Rectangle(startPoint, endPoint);
    }
}

