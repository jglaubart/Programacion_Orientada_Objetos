package Guias.guia3.ej9_Figures;

public class Circle extends Ellipse{
    Circle(Point center, double radius){
        super(center, 2*radius, 2*radius);   //asigno a ambos ejes el diametro del circulo
    }

    @Override
    public String toString(){
        return "Circle:\n\tCenter: %s\n\tRadius: %.2f".formatted(centerPoint, mayAxis/2);
    }
}
