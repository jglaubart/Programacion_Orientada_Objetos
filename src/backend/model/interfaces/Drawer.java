package backend.model.interfaces;

import backend.RGBColor;
import backend.model.figures.*;

/**
* Toda clase que implemente esta interfaz se puede utilizar para dibujar sobre una interfaz gráfica
* utilizando sus métodos sin conocer la implementación de los mismos.
* */
public interface Drawer {
    /**
    * Dibuja un elipse en la interfaz gráfica con su centro y diámetros.
    * */
    void drawEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis);

    /**
     * Dibuja el borde biselado de un elipse en la interfaz gráfica con su centro y diámetros.
     * */
    void drawBeveledEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis);

    /**
     * Dibuja un rectángulo en la interfaz gráfica con sus extremos.
     * */
    void drawRectangle(Point topLeft, Point bottomRight);

    /**
     * Dibuja el borde de un rectángulo biselado en la interfaz gráfica con sus extremos.
     * */
    void drawBeveledRectangle(Point topLeft, Point bottomRight);

    /**
    * Cambia el color de relleno del pincel de la interfaz gráfica
    * */
    void fillColor(RGBColor color);

    /**
    * Cambia el color de relleno del pincel por un gradiente linear de dos colores
    * */
    void fillLinearGradient(RGBColor color1, RGBColor color2);

    /**
    * Cambia el color de relleno del pincel por un gradiente radial de dos colores.
    * */
    void fillRadialGradient(RGBColor color1, RGBColor color2);

    /**
    * Devuelve un color resultado de oscurecer el color tomado como parámetro.
    * */
    RGBColor darken(RGBColor color);
}
