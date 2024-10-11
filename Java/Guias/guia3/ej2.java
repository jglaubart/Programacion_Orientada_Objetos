package Guias.guia3;

public class ej2 {
    public static void main(String args[]) {
        String s = "hola";
        System.out.println(s instanceof String);
        System.out.println(s instanceof Object);
        System.out.println(s.getClass().equals(String.class));
        System.out.println(s.getClass().equals(Object.class));   // todo es una instancia de Object, pero no son de la misma clase
    }

}
