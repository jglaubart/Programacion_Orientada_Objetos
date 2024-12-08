package backend;

import backend.model.figures.Figure;
import java.util.ArrayDeque;
import java.util.Deque;

public class Layer implements Comparable<Layer> {
    private final Deque<Figure> figures = new ArrayDeque<>();
    private boolean showLayer = true;
    private final Integer ID;

    public Layer(int id) {
        ID = id;
    }

    public Deque<Figure> getFigures() {
        return figures;
    }

    public void removeFigure(Figure figure) {
        figures.remove(figure);
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public boolean showLayer() {
        return showLayer;
    }

    public void setShowLayer(boolean show) {
        showLayer = show;
    }

    public Integer getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "Capa %s".formatted(this.ID);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Layer aux && aux.getId().equals(this.getId());
    }

    @Override
    public int compareTo(Layer other) {
        return other.getId().compareTo(this.getId());
    }
}
