package backend.model.Properties;

import backend.RGBColor;
import backend.model.figures.Figure;

public class DrawProperties {
    private double shadowOffset = 0.0;
    private Figure shadow = null;
    private RGBColor color1 = null;
    private RGBColor color2 = null;
    private boolean beveledState = false;

    public DrawProperties(RGBColor color1, RGBColor color2, double shadowOffset, boolean beveledState) {
        this.color1 = color1;
        this.color2 = color2;
        this.shadowOffset = shadowOffset;
        this.beveledState = beveledState;
    }

    public void setColor1(RGBColor color) {
        this.color1 = color;
    }

    public RGBColor getColor1() {
        return this.color1;
    }

    public void setColor2(RGBColor color) {
        this.color2 = color;
    }

    public RGBColor getColor2() {
        return this.color2;
    }

    public void setShadowOffset(double shadowOffset) {
        this.shadowOffset = shadowOffset;
    }

    public double getShadowOffset() {
        return this.shadowOffset;
    }

    public void setShadow(Figure shadow) {
        this.shadow = shadow;
    }

    public Figure getShadow() {
        return this.shadow;
    }

    public void setBeveledState(boolean beveledState) {
        this.beveledState = beveledState;
    }

    public boolean getBeveledState() {
        return this.beveledState;
    }
}
