package backend.model.Properties;

import backend.RGBColor;
import backend.model.figures.Figure;

public enum ShadowType {
    NONE(0.0),
    NORMAL(10.0),
    INVERSE(-10.0);

    private final double offset;

    ShadowType(double offset) {
        this.offset = offset;
    }

    public double getOffset() {
        return offset;
    }
}
