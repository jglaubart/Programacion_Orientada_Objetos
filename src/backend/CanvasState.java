package backend;

import backend.model.figures.Figure;
import java.util.ArrayList;
import java.util.List;

public class CanvasState {
    private static final int INITAL_LAYERS = 3;
    private final List<Layer> layers = new ArrayList<>();

    private static int ID = 0;


    public List<Layer> getLayers() {
        return layers;
    }

    public Layer addNewLayer() {
        ID += 1;
        Layer newLayer = new Layer(ID);
        layers.add(newLayer); // OJO CON DONDE LO ESTA AGREGANDO
        return newLayer;
    }

    public void removeLayer(Layer layer) {
        layers.remove(layer);
    }

    public Layer initalizeLayers() {
        for (int i = 0; i < INITAL_LAYERS; i++) {
            this.addNewLayer();
        }

        return layers.getFirst();
    }

    public Layer getFirstLayer() {
        return layers.getFirst();
    }
}
