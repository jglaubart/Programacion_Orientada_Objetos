package backend;

import backend.model.Shadow.Shadow;
import backend.model.Shadow.ShadowType;
import backend.model.interfaces.Drawer;

/**
 * Instancia de clase que guarda las propiedades de una figura
 */
public class DrawProperties implements Cloneable {
    private Shadow shadow;
    private RGBColor color1;
    private RGBColor color2;
    private boolean beveledState;

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

    public double getDefaultShadowOffset() {
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
