package backend.model.Properties;

import backend.RGBColor;
import backend.model.Shadow;
import backend.model.ShadowType;
import backend.model.interfaces.Drawer;

public class DrawProperties implements Cloneable {
    private Shadow shadow;
    private RGBColor color1 = null;
    private RGBColor color2 = null;
    private boolean beveledState = false;

    public DrawProperties(RGBColor color1, RGBColor color2, ShadowType shadowType, boolean beveledState) {
        this.shadow = new Shadow(shadowType);
        this.color1 = color1;
        this.color2 = color2;
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

    public void setShadowType(ShadowType shadowType){
        this.shadow.setShadowType(shadowType);
    }

    public ShadowType getShadowType(){
        return this.shadow.getShadowType();
    }

    public double getShadowOffset() {
        return shadow.getShadowOffset();
    }

    public RGBColor getShadowColor(Drawer drawer){
        return this.shadow.getShadowColor(drawer, color1);
    }

    public boolean hasShadow() {
        return this.shadow.getShadowType() != ShadowType.NONE;
    }

    public void setBeveledState(boolean beveledState) {
        this.beveledState = beveledState;
    }

    public boolean getBeveledState() {
        return this.beveledState;
    }

    @Override
    public DrawProperties clone() {
        try {
            DrawProperties newProperties = (DrawProperties) super.clone();
            newProperties.shadow = this.shadow.clone();
            newProperties.color1 = this.color1.clone();
            newProperties.color2 = this.color2 == null ? null : this.color2.clone();
            return newProperties;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Object cannot be cloned");
        }
    }
}
