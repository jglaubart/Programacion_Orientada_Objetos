package backend.model.figures;

public abstract class Figure {

    public abstract void move(double deltaX, double deltaY);

    public void changePosition(Point startPoint, Point endPoint) {
        this.move(endPoint.getX() - startPoint.getX(), endPoint.getY() - startPoint.getY());
    }

}
