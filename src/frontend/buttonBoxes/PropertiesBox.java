package frontend.buttonBoxes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PropertiesBox extends Box {
    private final Color defaultFillColor = Color.YELLOW;
    private final Color defaultFillColor2 = Color.ORANGE;

    private final ComboBox<String> shadowButton = new ComboBox<>();
    private final CheckBox beveledButton = new CheckBox("Biselado");
    private final ColorPicker firstColorPicker = new ColorPicker(defaultFillColor);
    private final ColorPicker secondColorPicker = new ColorPicker(defaultFillColor2);
    private final Button copyFormatButton = new Button("Copiar Fmt.");

    public PropertiesBox() {
        private VBox configurePropertiesButtons() {
            Label formatLabel = new Label("Formato");
            Label beveledLabel = new Label("Biselado");
            VBox propertiesBox = new VBox(10);
            HBox beveledBox = new HBox(5);
            beveledBox.getChildren().addAll(beveledButton, beveledLabel);
            shadowButton.getItems().addAll("No", "Simple", "Coloreada", "Simple Inversa", "Coloreada Inversa");
            shadowButton.setValue("No"); // default value
            propertiesBox.getChildren().addAll(formatLabel, shadowButton, beveledBox, firstColorPicker, secondColorPicker, copyFormatButton);
            Control[] propertiesButtons = {beveledButton, shadowButton, copyFormatButton};
            settingsButtonGroup(propertiesButtons);
            propertiesBox.setPadding(new Insets(5));
            propertiesBox.setStyle("-fx-background-color: #999");
            propertiesBox.setPrefWidth(100);

            return propertiesBox;
        }
    }
}
