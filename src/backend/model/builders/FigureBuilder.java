package backend.model.builders;

import backend.RGBColor;
import backend.model.Properties.DrawProperties;
import backend.model.figures.Figure;
import backend.model.figures.Point;

public interface FigureBuilder {

    Figure buildFigure(Point startPoint, Point endPoint);

    default Figure buildFigure(Point startPoint, Point endPoint, RGBColor defaultColor, RGBColor secondaryColor, double offset, RGBColor shadowColor, boolean BeveledState){
        Figure figure = buildFigure(startPoint, endPoint);
        figure.setBuilder(this);
        DrawProperties properties = new DrawProperties(defaultColor, secondaryColor, offset, BeveledState);
        figure.setDrawProperties(properties);
        if(offset != 0.0){
            Point figureStartPoint = new Point(startPoint.getX() + offset, startPoint.getY() + offset);
            Point figureEndPoint = new Point(endPoint.getX() + offset, endPoint.getY() + offset);
            figure.setShadow(figure.getBuilder().buildFigure(figureStartPoint, figureEndPoint, shadowColor, null, 0, null, false));
        }

        return figure;
    }
}
