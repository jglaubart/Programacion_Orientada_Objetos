package frontend.buttonBoxes;

import backend.Layer;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.SortedSet;
import java.util.function.Consumer;

public class FigureLayerBox implements SettingsBox {
    private final Button bringToFrontButton = new Button("Traer al Frente");
    private final Button bringToBackButton = new Button("Enviar al Fondo");
    private final Label layerLabel = new Label("Capas");
    private final ComboBox<Layer> layerComboBox = new ComboBox<>();
    private final RadioButton showButton = new RadioButton("Mostrar");
    private final RadioButton hideButton = new RadioButton("Ocultar");
    private final Button addLayerButton = new Button("Agregar Capa");
    private final Button removeLayerButton = new Button("Eliminar Capa");

    private final HBox layerBox;

    private Runnable onBringToFrontAction;
    private Runnable onBringToBackAction;
    private Runnable onAddLayerAction;
    private Runnable onRemoveLayerAction;


    private Consumer<Layer> onLayerSelected;
    private Consumer<Boolean> onLayerVisibilityChanged;

    private Runnable onShowAction;
    private Runnable onHideAction;

    public FigureLayerBox() {
        layerBox = new HBox(10);
        layerBox.setAlignment(Pos.CENTER);
        settings(layerBox);

        ToggleGroup displayGroup = new ToggleGroup();
        showButton.setToggleGroup(displayGroup);
        hideButton.setToggleGroup(displayGroup);

        layerBox.getChildren().addAll(bringToFrontButton, bringToBackButton, layerLabel, layerComboBox, showButton, hideButton, addLayerButton, removeLayerButton);

        bringToFrontButton.setOnAction(event -> {
            onBringToFrontAction.run();
        });

        bringToBackButton.setOnAction(event -> {
            onBringToBackAction.run();
        });

        addLayerButton.setOnAction(event -> {
            onAddLayerAction.run();
        });

        removeLayerButton.setOnAction(event -> {
            onRemoveLayerAction.run();
        });

        showButton.setOnAction(event -> {
            if (onLayerVisibilityChanged != null) {
                onLayerVisibilityChanged.accept(true);
            }
        });

        hideButton.setOnAction(event -> {
            if (onLayerVisibilityChanged != null) {
                onLayerVisibilityChanged.accept(false);
            }
        });

        layerComboBox.setOnAction(event -> {
            Layer selected = layerComboBox.getValue();
            if (onLayerSelected != null) {
                onLayerSelected.accept(selected);
            }
        });
    }

    public void setBringToFrontAction(Runnable action) {
        this.onBringToFrontAction = action;
    }

    public void setBringToBackAction(Runnable action) {
        this.onBringToBackAction = action;
    }

    public void setOnAddLayerAction(Runnable action) {
        this.onAddLayerAction = action;
    }

    public void setOnRemoveLayerAction(Runnable action) {
        this.onRemoveLayerAction = action;
    }

    public void setOnLayerSelected(Consumer<Layer> onLayerSelected) {
        this.onLayerSelected = onLayerSelected;
    }

    public void setOnLayerVisibilityChanged(Consumer<Boolean> onLayerVisibilityChanged) {
        this.onLayerVisibilityChanged = onLayerVisibilityChanged;
    }

    public void updateLayers(SortedSet<Layer> layers, Layer currentLayer) {
        layerComboBox.getItems().setAll(layers);
        layerComboBox.setValue(currentLayer);
    }

    public void updateVisibilityButtons(Layer layer) {
        if (layer.showLayer()) {
            showButton.setSelected(true);
        } else {
            hideButton.setSelected(true);
        }
    }

    @Override
    public Pane getBox() {
        return layerBox;
    }
}
