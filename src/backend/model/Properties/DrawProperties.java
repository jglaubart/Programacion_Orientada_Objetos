package backend.model.Properties;

import backend.RGBColor;

public class DrawProperties {
    private ShadowType shadowType = ShadowType.NONE;
    private RGBColor color1 = null;
    private RGBColor color2 = null;
    private boolean beveledState = false;

    public DrawProperties(RGBColor color1, RGBColor color2, ShadowType shadowType, boolean beveledState) {
        this.color1 = color1;
        this.color2 = color2;
        this.shadowType = shadowType;
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

    public void setShadowType(ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    public ShadowType getShadowType() {
        return this.shadowType;
    }

    public void setBeveledState(boolean beveledState) {
        this.beveledState = beveledState;
    }

    public boolean getBeveledState() {
        return this.beveledState;
    }
}
