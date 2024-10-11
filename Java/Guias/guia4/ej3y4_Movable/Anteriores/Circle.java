package Guias.guia4.ej3y4_Movable.Anteriores;

public class Circle extends Ellipse {
    public Circle(Point center, double radius){
        super(center, 2*radius, 2*radius);   //asigno a ambos ejes el diametro del circulo
    }

    @Override
    public String toString(){
        return "Circle:\n\tCenter: %s\n\tRadius: %.2f".formatted(centerPoint, mayAxis/2);
    }
}
