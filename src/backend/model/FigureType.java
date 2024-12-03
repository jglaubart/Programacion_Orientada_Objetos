package backend.model;

public enum FigureType {
    RECTANGLE {
        @Override
        public Figure buildFigure(Point startPoint, Point endPoint) {
            return new Rectangle(startPoint, endPoint);
        }
    },
    CIRCLE {
        @Override
        public Figure buildFigure(Point startPoint, Point endPoint) {
            double circleRadius = Math.abs(endPoint.getX() - startPoint.getX());
            return new Circle(startPoint, circleRadius);
        }
    },
    SQUARE {
        @Override
        public Figure buildFigure(Point startPoint, Point endPoint) {
            double size = Math.abs(endPoint.getX() - startPoint.getX());
            return new Square(startPoint, size);
        }
    },
    ELLIPSE {
        @Override
        public Figure buildFigure(Point startPoint, Point endPoint) {
            Point centerPoint = new Point(Math.abs(endPoint.getX() + startPoint.getX()) / 2, (Math.abs((endPoint.getY() + startPoint.getY())) / 2));
            double sMayorAxis = Math.abs(endPoint.getX() - startPoint.getX());
            double sMinorAxis = Math.abs(endPoint.getY() - startPoint.getY());
            return new Ellipse(centerPoint, sMayorAxis, sMinorAxis);
        }
    };

    public abstract Figure buildFigure(Point startPoint, Point endPoint);
}
