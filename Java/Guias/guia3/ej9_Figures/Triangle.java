package Guias.guia3.ej9_Figures;

public class Triangle extends Figure {
    private final Point p1, p2, p3;

    Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }


    @Override
    public double area(){
        double semiPerimiter = perimeter() / 2;
        return Math.sqrt(semiPerimiter * (semiPerimiter - firstSide())
                * (semiPerimiter - secondSide()) * (semiPerimiter - thirdSide()));
    }

    @Override
    public double perimeter(){
        return firstSide() + secondSide() + thirdSide();
    }

    public double firstSide(){
        return p1.distanceTo(p2);
    }

    public double secondSide(){
        return p1.distanceTo(p3);
    }

    public double thirdSide(){
        return p2.distanceTo(p3);
    }

    @Override
    public String toString(){
        return "Triangle [ %s , %s , %s]".formatted(p1, p2, p3);
    }
}
