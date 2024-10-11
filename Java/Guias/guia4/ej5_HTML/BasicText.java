package Guias.guia4.ej5_HTML;

public abstract class BasicText implements HTMLText {

    @Override
    public String toString() {
        return source();      // todas las clases deben poder ver cual es la fuente
    }
}
