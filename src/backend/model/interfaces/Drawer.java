package backend.model.interfaces;

import backend.model.figures.*;

public interface Drawer {
    public void drawCircle(Point centerPoint, double diameter);
    public void drawEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis);
    public void drawRectangle(Point topLeft, Point bottomRight);
    public void drawAttributes();
}
