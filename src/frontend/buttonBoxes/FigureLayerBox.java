package frontend.buttonBoxes;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FigureLayerBox implements SettingsBox {
    private final Button bringToFrontButton = new Button("Traer al Frente");
    private final Button bringToBackButton = new Button("Enviar al Fondo");
    private final Label layerLabel = new Label("Capas");
    private final ComboBox<Button> layerComboBox = new ComboBox<>();
    private final RadioButton showButton = new RadioButton("Mostrar");
    private final RadioButton hideButton = new RadioButton("Ocultar");
    private final Button addLayerButton = new Button("Agregar Capa");
    private final Button removeLayerButton = new Button("Eliminar Capa");

    private final HBox layerBox;

    private Runnable onBringToFrontAction;
    private Runnable onBringToBackAction;
    private Runnable onAddLayerAction;
    private Runnable onRemoveLayerAction;


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

    @Override
    public Pane getBox() {
        return layerBox;
    }
}
