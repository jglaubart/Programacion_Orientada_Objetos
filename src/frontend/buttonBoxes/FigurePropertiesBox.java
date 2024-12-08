package frontend.buttonBoxes;

import backend.model.Properties.ShadowType;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class FigurePropertiesBox implements SettingsBox {
    private final ComboBox<ShadowType> shadowButton = new ComboBox<>(); // AGREGALE FORMATOS DE SHADOWS
    private final CheckBox beveledButton = new CheckBox("Biselado");
    private final ColorPicker firstColorPicker;
    private final ColorPicker secondColorPicker;
    private final Button copyFormatButton = new Button("Copiar Fmt.");
    private final Label formatLabel = new Label("Formato");

    private final VBox propertiesBox;

    private Runnable onCopyFormatAction;

    public FigurePropertiesBox(Color firstColor, Color secondColor) {
        firstColorPicker = new ColorPicker(firstColor);
        secondColorPicker = new ColorPicker(secondColor);

        shadowButton.getItems().addAll(ShadowType.values());
        shadowButton.setValue(ShadowType.NONE); // default value

        propertiesBox = new VBox(10);
        settings(propertiesBox);

        propertiesBox.getChildren().addAll(formatLabel, shadowButton, beveledButton, firstColorPicker, secondColorPicker, copyFormatButton);

        copyFormatButton.setOnAction(event -> {
            onCopyFormatAction.run();
        });


    }

    public Color getSelectedFillColor() {
        return firstColorPicker.getValue();
    }

    public Color getSecondarySelectedFillColor() {
        return secondColorPicker.getValue();
    }

    @Override
    public Pane getBox() {
        return propertiesBox;
    }

    public boolean getBeveledState() {
        return beveledButton.isSelected();
    }
}
