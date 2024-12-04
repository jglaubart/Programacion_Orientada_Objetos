package backend.model;

import backend.model.figures.Figure;

public class FiguresPair<L extends Figure, R extends Figure> {
    private L left;
    private R right;

    // Constructor
    public FiguresPair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }
    public R getRight() {
        return right;
    }

}
