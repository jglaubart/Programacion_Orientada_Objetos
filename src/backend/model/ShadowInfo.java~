package backend.model;

import backend.RGBColor;
import backend.model.interfaces.Drawer;
import javafx.scene.paint.Color;

public class ShadowInfo {
    private ShadowType shadowType;
    private static final double OFFSET = 10.0;

    public ShadowInfo(ShadowType shadowType) {
        this.shadowType = shadowType;
    }

    public RGBColor getShadowColor(Drawer drawer, RGBColor color){
        if(shadowType.equals(ShadowType.SIMPLE) || shadowType.equals(ShadowType.SIMPLE_INVERSE)) {
            return RGBColor.GRAY;
        }
        if(shadowType.equals(ShadowType.NONE)){
            return RGBColor.TRANSPARENT;
        }
        return drawer.darken(color);
    }

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
}
