package backend;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class CanvasState {
    private static final int INITAL_LAYERS = 3;
    private final SortedSet<Layer> layers = new TreeSet<>(Comparator.reverseOrder());
    private static int ID = 0;


    public SortedSet<Layer> getLayers() {
        return layers;
    }

    public Layer addNewLayer() {
        ID += 1;
        Layer newLayer = new Layer(ID);
        layers.add(newLayer);
        return newLayer;
    }

    public boolean removeLayer(Layer layer) {
        if (layer.getId() <= 3) {
            return false;
        }
        layers.remove(layer);
        return true;
    }

    public Layer initalizeLayers() {
        for (int i = 0; i < INITAL_LAYERS; i++) {
            this.addNewLayer();
        }

        return getFirstLayer(); // "first" = capa 1
    }

    public Layer getFirstLayer() {
        return layers.getFirst();
    }


}
