package Guias.guia3.ej9_Figures;

public class Rectangle extends Figure {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight){
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public double base(){
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }
     public double height(){
        return Math.abs(topLeft.getY() - bottomRight.getY());
     }

     public double area(){
        return base() * height();
     }

     public double perimeter(){
        return 2*(base() + height());
     }


     @Override
     public String toString(){
        return "Rectangle [ %s , %s]".formatted(topLeft, bottomRight);
     }
}
