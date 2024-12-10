package backend.model.Shadow;

import backend.RGBColor;
import backend.model.interfaces.Drawer;

public class Shadow implements Cloneable {
    private ShadowType shadowType;
    private static final double OFFSET = 2.0;

    public Shadow(ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    /**
     * Devuelve el color de la sombra en funcion de su tipo
     */
    public RGBColor getShadowColor(Drawer drawer, RGBColor color){
        if(shadowType.equals(ShadowType.SIMPLE) || shadowType.equals(ShadowType.SIMPLE_INVERSE)) {
            return RGBColor.GRAY;
        }
        if(shadowType.equals(ShadowType.NONE)){
            return RGBColor.TRANSPARENT;
        }
        return drawer.darken(color);
    }

    /**
     * Devuelve el offset default de la sombra en funcion de su tipo
     */
    public double getShadowOffset(){
        if(shadowType.equals(ShadowType.SIMPLE) || shadowType.equals(ShadowType.COLORED)) {
            return OFFSET;
        }
        return -OFFSET;
    }

    public void setShadowType(ShadowType shadowType){
        this.shadowType = shadowType;
    }

    public ShadowType getShadowType(){
        return this.shadowType;
    }

    @Override
    public Shadow clone() {
        try {
            Shadow newShadow = (Shadow) super.clone();
            newShadow.setShadowType(shadowType);
            return newShadow;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Object cannot be cloned");
        }
    }
}
