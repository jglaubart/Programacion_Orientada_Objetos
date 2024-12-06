package backend.model.Properties;

public enum ShadowType {
    NONE("Ninguna", 0.0),
    SIMPLE("Simple", 10.0),
    COLORED("Coloreada", 10.0),
    SIMPLE_INVERSE("Simple Inversa", -10),
    COLOR_INVERSE("Coloreada Inversa", -10.0);

    private final String name;
    private final double offset;

    ShadowType(String name, double offset) {
        this.name = name;
        this.offset = offset;
    }

    public double getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return name;
    }
}
