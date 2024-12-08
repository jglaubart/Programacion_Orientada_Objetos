package backend.model.interfaces;

import backend.RGBColor;
import backend.model.figures.*;

public interface Drawer {
    public void drawEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis);
    public void drawBeveledEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis);
    public void drawRectangle(Point topLeft, Point bottomRight);
    public void drawBeveledRectangle(Point topLeft, Point bottomRight);
    public void fillColor(RGBColor color);
    public void fillLinearGradient(RGBColor color1, RGBColor color2);
    public void fillRadialGradient(RGBColor color1, RGBColor color2);

}
