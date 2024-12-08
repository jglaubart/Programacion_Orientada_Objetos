package backend;

import backend.model.figures.Figure;

import java.util.ArrayDeque;
import java.util.Deque;

public class Layer {
    private final Deque<Figure> figures = new ArrayDeque<>();
    private boolean showLayer = true;

    public Deque<Figure> getFigures() {
        return figures;
    }

}
