package backend.model.Properties;

import backend.model.figures.Figure;

public enum ShadowType {
    NONE("No"),
    SIMPLE("Simple"),
    COLORED("Coloreada"),
    SIMPLE_INVERSE("Simple Inversa"),
    COLORED_INVERSE("Coloreada Inversa");

    private final String name;
    // public abstract drawShadow();

    ShadowType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name();
    }
}
