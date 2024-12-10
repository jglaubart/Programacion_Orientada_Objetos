package backend;

import backend.model.figures.Figure;
import java.util.*;

/**
 * Almacena las figuras ya dibujadas
 */
public class CanvasState {
    private static final int INITAL_LAYERS = 3;

    /**
     * Collecion para guardar las capas, se guardan en el orden correspondiente al que se dibujan
     */
    private final SortedSet<Layer> layers = new TreeSet<>(Comparator.reverseOrder());

    /**
     * Mapa para vincular una capa con su estado de visibilidad
     */
    private final Map<Layer, Boolean> visibilityMap = new HashMap<>();
    private static int ID = 0;

    /**
     * Devuelve las capas ordenadas por su ID.
     */
    public SortedSet<Layer> getLayers() {
        return layers;
    }


    /**
     * Agrega una capa de dibujado
     */
    public Layer addNewLayer() {
        ID += 1;
        Layer newLayer = new Layer(ID);
        layers.add(newLayer);
        visibilityMap.put(newLayer, true);
        return newLayer;
    }

    /**
     * Borra una capa de dibujado
     */
    public boolean removeLayer(Layer layer) {
        if (layer.getId() <= 3) {
            return false;
        }
        layers.remove(layer);
        visibilityMap.remove(layer);
        return true;
    }

    /**
     * Inicializa las capas iniciales
     */
    public Layer initalizeLayers() {
        for (int i = 0; i < INITAL_LAYERS; i++) {
            addNewLayer();
        }

        return getFirstLayer(); // "first" = capa 1
    }

    /**
     * Analiza a que capa pertenece una figura
     */
    public Layer belongToLayer(Figure figure) {
        for (Layer layer : layers) {
            if (layer.hasFigure(figure)) {
                return layer;
            }
        }
        return null;
    }


    public boolean getLayerVisibility(Layer layer) {
        return visibilityMap.get(layer);
    }

    /**
     * Oculta o muestra una capa
     */
    public void setLayerVisibility(Layer layer, boolean isVisible) {
        visibilityMap.put(layer, isVisible);
    }

    public Layer getFirstLayer() {
        return layers.getFirst();
    }

    public Map<Layer, Boolean> getVisibilityMap() {
        return visibilityMap;
    }

}
