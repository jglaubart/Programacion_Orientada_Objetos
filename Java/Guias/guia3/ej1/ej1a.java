package Guias.guia3.ej1;

public class ej1a {
    public static void main(String[] args) {
        String s1, s2;
        s1 =  "hola";
        s2 = "hola";
        if (s1 == s2) {
            System.out.println("Son iguales");   //son iguales porque al ya existir una igual utiliza la misma dir de memoria
        } else {
            System.out.println("Son distintos");
        }
    }
}
