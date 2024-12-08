package backend;

import backend.model.figures.Figure;
import java.util.ArrayList;
import java.util.List;

public class CanvasState {
    private final List<Layer> layers = new ArrayList<>();
    private final Layer currentLayer;

    public void addFigure(Figure figure) {
        currentLayer.getFigures().add(figure);
    }

    public void deleteFigure(Figure figure) {
        for (Layer layer : layers) {
            if (layer.getFigures().contains(figure)) {
                layer.getFigures().remove(figure);
                break;
            }
        }
    }

    public Iterable<Layer> getLayers() {
        return layers;
    }

}
