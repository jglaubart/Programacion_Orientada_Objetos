package frontend;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;


public class ActionsPane extends BorderPane {
    private final ToggleButton rotateButton = new ToggleButton("Girar D");
    private final ToggleButton reflectVerticalButton = new ToggleButton("Voletar (Vertical)");
    private final ToggleButton reflectHorizontalButton = new ToggleButton("Voltaer (Horizontal)");
    private final ToggleButton duplicationButton = new ToggleButton("Duplicar");
    private final ToggleButton divdeButton = new ToggleButton("Dividir");
}
