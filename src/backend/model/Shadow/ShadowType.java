package backend.model.Shadow;

/**
 * Define los distintos tipos de sombra posibles para una figura
 */
public enum ShadowType {
    NONE("Ninguna"),
    SIMPLE("Simple"),
    COLORED("Coloreada"),
    SIMPLE_INVERSE("Simple Inversa"),
    COLORED_INVERSE("Coloreada Inversa");

    private final String name;

     ShadowType(String name){
        this.name = name;
    }

    public String getName(){
         return name;
    }
    @Override
    public String toString(){
        return name;
    }
}
