package frontend.buttonBoxes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FigureLayerBox implements SettingsBox {
    private final Button bringToFront = new Button("Traer al Frente");
    private final Button bringToBack = new Button("Enviar al Fondo");
    private final Label layerLabel = new Label("Capas");
    private final ComboBox<Button> layerComboBox = new ComboBox<>();
    private final RadioButton showButton = new RadioButton("Mostrar");
    private final RadioButton hideButton = new RadioButton("Ocultar");
    private final Button addLayerButton = new Button("Agregar Capa");
    private final Button removeLayerButton = new Button("Eliminar Capa");

    private final HBox layerBox;

    public FigureLayerBox() {
        layerBox = new HBox(10);
        layerBox.setAlignment(Pos.CENTER);
        settings(layerBox);

        layerBox.getChildren().addAll(bringToFront, bringToBack, layerLabel, layerComboBox, showButton, hideButton, addLayerButton, removeLayerButton);
    }


    @Override
    public Pane getBox() {
        return layerBox;
    }
}
