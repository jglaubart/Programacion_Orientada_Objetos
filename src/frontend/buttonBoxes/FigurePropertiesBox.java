package frontend.buttonBoxes;

import backend.model.Properties.ShadowType;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class FigurePropertiesBox implements FillBox {
    private final ComboBox<ShadowType> shadowButton = new ComboBox<>(); // AGREGALE FORMATOS DE SHADOWS
    private final CheckBox beveledButton = new CheckBox("Biselado");
    private final ColorPicker firstColorPicker;
    private final ColorPicker secondColorPicker;
    private final Button copyFormatButton = new Button("Copiar Fmt.");
    private final Label formatLabel = new Label("Formato de Texto");
    private final Label beveledLabel = new Label("Biselado");

    private final VBox propertiesBox;

    public FigurePropertiesBox(Color firstColor, Color secondColor) {
        firstColorPicker = new ColorPicker(firstColor);
        secondColorPicker = new ColorPicker(secondColor);

        HBox beveledBox = new HBox(5);
        beveledBox.getChildren().addAll(beveledButton, beveledLabel);

        shadowButton.getItems().addAll(ShadowType.values());
        shadowButton.setValue(ShadowType.NONE); // default value

        propertiesBox = new VBox(10);
        propertiesBox.setPadding(new Insets(5));
        propertiesBox.setStyle("-fx-background-color: #999");
        propertiesBox.setPrefWidth(100);

        propertiesBox.getChildren().addAll(formatLabel, shadowButton, beveledBox, firstColorPicker, secondColorPicker, copyFormatButton);
    }


}
