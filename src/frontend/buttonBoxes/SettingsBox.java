package frontend.buttonBoxes;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;

public interface SettingsBox {
    double DEFAULT_SPACING = 10;

    /*
     * Setea ciertas propiedades
     */
    default void settings(Pane box) {
        box.setPadding(new Insets(5));
        box.setStyle("-fx-background-color: #999");
        box.setPrefWidth(100);
    }

    Pane getBox();

}
