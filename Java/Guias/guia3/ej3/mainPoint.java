package Guias.guia3.ej3;

public class mainPoint {
    public static void main(String[] args) {

        Point p1a = new Point(2, 1);
        Point p1b = new Point(2, 1);
        System.out.println(p1a == p1b);   //SON DISTINTOS OBJETOS

        Point p2a= new Point(2, 1);
        Point p2b = new Point(2, 1);
        System.out.println(p2a.equals(p2b)); // LA CLASE NO TIENE DEFINIDO EL METODO EQUALS POR LO QUE AGARRA EL DE OBJECT Y ES FALSO

//        Point p3a = new Point(2, 1);
//        Point p3b = new Point(2, 1);
//        System.out.println(p3a.getX().equals(p3b.getX()) && p3a.getY().equals(p3b.getY()));   NO COMPILA


        Point p4 = new Point(2, 1);
        System.out.println(p4 instanceof Object); // TODO ES OBJETO SUBCLASE DE OBJECT

//        Point p5 = new Point();    NO COMPILA, FALTAN PARAMETROS
//        System.out.println(p5);

//        Point[] points6 = new Point[10];
//        for (Point point : points6) {
//            System.out.println(point.getX() + ", " + point.getY());    ERROR DE EJECUCION, NO ESTAN INICIALIZADOS LOS VALORES DE LOS POINTS
//        }

        Point p7 = new Point(2, 1);
        System.out.println(p7);  //IMPRIME EL STRING DEVUELTO POR EL ToString

    }
}
