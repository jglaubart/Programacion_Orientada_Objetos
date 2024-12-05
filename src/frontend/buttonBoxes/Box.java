package frontend.buttonBoxes;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Control;
import javafx.scene.layout.VBox;

public abstract class Box extends VBox {
    private static final int DEFAULT_SPACING = 10;

    public Box() {
        super(DEFAULT_SPACING);
    }

    protected void loadButtonsBox(ButtonBase[] array) {
        this.getChildren().addAll(array);
        this.setPadding(new Insets(5));
        this.setStyle("-fx-background-color: #999");
        this.setPrefWidth(100);
    }

    protected void settingsButtonGroup(Control[] array) {
        for (Control button : array) {
            button.setMinWidth(90);
            button.setCursor(Cursor.HAND);
        }
    }
}
