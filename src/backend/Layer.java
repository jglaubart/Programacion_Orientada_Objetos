package backend;

import backend.model.figures.Figure;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * Instancia de una capa sobre la cual se pueden dibujar figuras.
 */
public class Layer implements Comparable<Layer> {

    /**
     * Cola de figuras, para establecer una jerarquia de dibujado
     */
    private final Deque<Figure> figures = new ArrayDeque<>();
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

    public boolean hasFigure(Figure figure) {
        for (Figure f : figures) {
            if (figure.equals(f)) {
                return true;
            }
        }
        return false;
    }
}
