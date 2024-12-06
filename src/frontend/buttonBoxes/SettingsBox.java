package frontend.buttonBoxes;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;

public interface SettingsBox {
     default void settings(Pane box) {
        box.setPadding(new Insets(5));
        box.setStyle("-fx-background-color: #999");
        box.setPrefWidth(100);
    }

    public Pane getBox();
}
