package frontend.buttonBoxes;

import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;

public interface FillBox {
     default VBox loadBox(Control[] array) {
        VBox box = new VBox(10);
        box.getChildren().addAll(array);
        box.setPadding(new Insets(5));
        box.setStyle("-fx-background-color: #999");
        box.setPrefWidth(100);
        return box;
    }

}
