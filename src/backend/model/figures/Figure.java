package backend.model.figures;

import backend.RGBColor;
import backend.model.FiguresPair;
import backend.model.builders.FigureBuilder;
import backend.model.interfaces.Drawer;
import backend.model.Properties.DrawProperties;
import backend.model.interfaces.Movable;
import backend.model.interfaces.Transformable;

public abstract class Figure implements Movable, Transformable<Figure> {

    private Point centerPoint;
    private Point topLeft;
    private Point bottomRight;
    private DrawProperties drawProperties;
    private FigureBuilder builder;

    public void setDrawProperties(DrawProperties drawProperties) {
        this.drawProperties = drawProperties;
    }

    public DrawProperties getDrawProperties() {
        return drawProperties;
    }

    public FigureBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(FigureBuilder builder) {
        this.builder = builder;
    }

    public void setShadow(Figure shadow) {
        drawProperties.setShadow(shadow);
    }

    public abstract boolean belongs(Point eventPoint);

    public void draw(Drawer drawer){
        DrawProperties properties = this.getDrawProperties();
        Figure shadow = properties.getShadow();
        if(shadow != null) {
            shadow.draw(drawer);
        }
        if(properties.getColor2() != null) {
            this.fillGradient(drawer);
        }else{
            drawer.fillColor(properties.getColor1());
        }
    }

    public abstract void fillGradient(Drawer drawer);

    public Point getCenterPoint(){
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;

        if(drawProperties == null){
            return;
        }

        Figure shadow = drawProperties.getShadow();
        if(shadow != null){
            double offset = drawProperties.getShadowOffset();
            shadow.setCenterPoint(new Point(centerPoint.getX() + offset, centerPoint.getY() + offset));
        }
    }

    public Point getTopLeft() {
        return topLeft;
    }
    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;

        if(drawProperties == null){
            return;
        }

        Figure shadow = drawProperties.getShadow();
        if(shadow != null){
            double offset = drawProperties.getShadowOffset();
            shadow.setTopLeft(new Point(topLeft.getX() + offset, topLeft.getY() + offset));
        }
    }
    public Point getBottomRight() {
        return bottomRight;
    }
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;

        if (drawProperties == null) {
            return;
        }

        Figure shadow = drawProperties.getShadow();
        if(shadow != null){
            double offset = drawProperties.getShadowOffset();
            shadow.setBottomRight(new Point(bottomRight.getX() + offset, bottomRight.getY() + offset));
        }
    }

    protected abstract double getWidth();

    protected abstract double getHeight();

    @Override
    public void move(double dx, double dy){
        this.centerPoint.move(dx, dy);
        this.topLeft.move(dx, dy);
        this.bottomRight.move(dx, dy);

        Figure shadow = drawProperties.getShadow();
        if(shadow != null) {
            shadow.move(dx, dy);
        }
    }

    @Override
    public void rotate() {
        double height = getHeight();
        double width = getWidth();
        setTopLeft(new Point(centerPoint.getX() - height / 2, centerPoint.getY() - width / 2));
        setBottomRight(new Point(centerPoint.getX() + height / 2, centerPoint.getY() + width / 2));
    }

    @Override
    public void reflectHorizontal(){
        double width = getWidth();
        this.move(width, 0);
    }

    @Override
    public void reflectVertical(){
        double height = getHeight();
        this.move(0, -height);
    }

    @Override
    public Figure duplicate(double offset) {
        DrawProperties properties = this.getDrawProperties();
        FigureBuilder builder = this.getBuilder();
        RGBColor shadowColor;
        double shadowOffset;
        if(properties.getShadow() == null) {
            shadowColor = null;
            shadowOffset = 0.0;
        }else{
            shadowColor = properties.getShadow().getDrawProperties().getColor1();
            shadowOffset = properties.getShadowOffset();
        }

        Figure newFigure = builder.buildFigure(topLeft, bottomRight, properties.getColor1(), properties.getColor2(), shadowOffset, shadowColor, properties.getBeveledState());
        newFigure.move(offset, offset);
        return newFigure;
    }

    @Override
    public FiguresPair<Figure, Figure> divide() {
        double newWidth = getWidth() / 2;
        double newHeight = getHeight() / 2;
        Point leftCenter = new Point(getCenterPoint().getX() - newWidth / 2, getCenterPoint().getY());
        Point rightCenter = new Point(getCenterPoint().getX() + newWidth / 2, getCenterPoint().getY());

        Point topLeftRightFig = new Point(rightCenter.getX() - newWidth/2, rightCenter.getY() - newHeight/2);
        Point bottomRightRightFig = new Point(rightCenter.getX() + newWidth/2, rightCenter.getY() + newHeight/2);

        Point topLeftLeftFig = new Point(leftCenter.getX() - newWidth/2, leftCenter.getY() - newHeight/2);
        Point bottomRightLeftFig = new Point(leftCenter.getX() + newWidth/2, leftCenter.getY() + newHeight/2);
        

        Figure left = this.duplicate(0);
        left.setTopLeft(topLeftLeftFig);
        left.setBottomRight(bottomRightLeftFig);
        left.setCenterPoint(leftCenter);

        Figure right = this.duplicate(0);
        right.setTopLeft(topLeftRightFig);
        right.setBottomRight(bottomRightRightFig);
        right.setCenterPoint(rightCenter);

        return new FiguresPair<Figure, Figure>(left, right);
    }
}
