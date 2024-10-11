package Guias.guia4.ej3y4_Movable.Anteriores;

public class Ellipse extends Figure {
    protected Point centerPoint;
    protected double mayAxis;
    protected double minAxis;

    public Ellipse(Point center, double may, double min){
        this.centerPoint = center;
        this.mayAxis = may;
        this.minAxis = min;
    }

    @Override
    public double area(){
        return Math.PI * (mayAxis/2) * (mayAxis/2);
    }

    @Override
    public double perimeter(){
        return Math.PI/2 * (mayAxis+minAxis);
    }

    public String toString(){
        return "Ellipse: \n\tcenter: %s\n\tMayAxis: %s\n\tMinAxis: %s\n".formatted(centerPoint, mayAxis, minAxis);
    }
}
