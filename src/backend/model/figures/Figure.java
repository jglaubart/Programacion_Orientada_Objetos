package backend.model.figures;

import backend.RGBColor;
import backend.model.interfaces.Drawer;
import backend.DrawProperties;
import backend.model.interfaces.Movable;
import backend.model.interfaces.Transformable;

public abstract class Figure implements Cloneable, Movable, Transformable<Figure> {

    private Point centerPoint;
    private Point topLeft;
    private Point bottomRight;
    private DrawProperties drawProperties;
    private Drawer drawer;

    public void setDrawProperties(DrawProperties drawProperties) {
        this.drawProperties = drawProperties;
    }

    public DrawProperties getDrawProperties() {
        return drawProperties;
    }

    public abstract boolean belongs(Point eventPoint);

    public void draw(){
        DrawProperties properties = getDrawProperties();
        if(properties.hasShadow()) {
            this.drawShadow();
        }
        if(properties.getBeveledState()) {
            this.drawBeveledFigure();
        }
        this.drawFigure();
    }

    public void fillColor(){
        if(getDrawProperties().getColor2() != null) {
            this.fillGradient();
        }else{
            drawer.fillColor(getDrawProperties().getColor1());
        }
    }

    public void drawFigure(){
        this.fillColor();
        this.drawFigureGeometry(topLeft, bottomRight);
    }

    public abstract void drawFigureGeometry(Point topLeft, Point bottomRight);

    public void drawShadow(){
        RGBColor shadowColor = getDrawProperties().getShadowColor(drawer);
        drawer.fillColor(shadowColor);
        double offset = getDrawProperties().getShadowOffset();
        this.drawFigureGeometry(new Point(topLeft.getX() + offset, topLeft.getY() + offset), new Point(bottomRight.getX() + offset, bottomRight.getY() + offset));
    }

    public abstract void drawBeveledFigure();

    public abstract void fillGradient();

    public Point getCenterPoint(){
        return centerPoint;
    }

    public void setCenterPoint(Point centerPoint) {
        this.centerPoint = centerPoint;

        if(drawProperties == null){
            return;
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
    }
    public Point getBottomRight() {
        return bottomRight;
    }
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;

        if (drawProperties == null) {
            return;
        }
    }

    public Drawer getDrawer(){
        return this.drawer;
    }

    public void setDrawer(Drawer drawer){
        this.drawer = drawer;
    }

    protected abstract double getWidth();

    protected abstract double getHeight();

    @Override
    public void move(double dx, double dy){
        this.centerPoint.move(dx, dy);
        this.topLeft.move(dx, dy);
        this.bottomRight.move(dx, dy);
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
        this.move(0, height);
    }

    @Override
    public Figure duplicate(double offset) {
        Figure newFigure = this.clone();
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

    @Override
    public Figure clone(){
        try{
            Figure newFigure;
            newFigure = (Figure) super.clone();
            newFigure.setDrawProperties(this.getDrawProperties().clone());
            newFigure.setTopLeft(this.getTopLeft().clone());
            newFigure.setBottomRight(this.getBottomRight().clone());
            newFigure.setCenterPoint(this.getCenterPoint().clone());
            return newFigure;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Object cannot be cloned");
        }
    }
}
