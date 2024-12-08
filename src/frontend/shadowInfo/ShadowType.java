package frontend.shadowInfo;

public enum ShadowType {
    NONE("No"),
    SIMPLE("Simple"),
    COLORED("Coloreada"),
    SIMPLE_INVERSE("Simple Inversa"),
    COLORED_INVERSE("Coloreada Inversa");


    private final String name;


    ShadowType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name();
    }
}
