package frontend.buttonBoxes;

import backend.model.ShadowType;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

public class FigurePropertiesBox implements SettingsBox {
    private final ChoiceBox<ShadowType> shadowButton = new ChoiceBox<>();
    private final CheckBox beveledButton = new CheckBox("Biselado");
    private final ColorPicker firstColorPicker;
    private final ColorPicker secondColorPicker;
    private final Button copyFormatButton = new Button("Copiar Fmt.");
    private final Label formatLabel = new Label("Formato");

    private final VBox propertiesBox;

    private Runnable onCopyFormatAction;
    private Runnable onButtonAction;

    public FigurePropertiesBox(Color firstColor, Color secondColor) {
        firstColorPicker = new ColorPicker(firstColor);
        secondColorPicker = new ColorPicker(secondColor);

        shadowButton.getItems().addAll(ShadowType.values());
        shadowButton.setValue(ShadowType.NONE); // default value

        shadowButton.setConverter(new StringConverter<>() {
            @Override
            public String toString(ShadowType shadowType) {
                return shadowType.getName();
            }
            @Override
            public ShadowType fromString(String string) {
                return null;
            }
        });

        propertiesBox = new VBox(10);
        settings(propertiesBox);

        propertiesBox.getChildren().addAll(formatLabel, shadowButton, beveledButton, firstColorPicker, secondColorPicker, copyFormatButton);

        shadowButton.setOnAction(event -> onButtonAction.run());
        beveledButton.setOnAction(event -> onButtonAction.run());
        firstColorPicker.setOnAction(event -> onButtonAction.run());
        secondColorPicker.setOnAction(event -> onButtonAction.run());

        copyFormatButton.setOnAction(event -> {
            onCopyFormatAction.run();
        });
    }

    public void setOnButtonAction(Runnable onButtonAction) {
        this.onButtonAction = onButtonAction;
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

    public ShadowType getSelectedShadowType() {
        return shadowButton.getValue();
    }

    public boolean getBeveledState() {
        return beveledButton.isSelected();
    }
}
