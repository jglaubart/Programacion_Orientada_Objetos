package frontend.buttonBoxes;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import javax.swing.*;

public class ActionBox extends Box {
    private final Button rotateButton = new Button("Girar D");
    private final Button reflectVerticalButton = new Button("Voletar V");
    private final Button reflectHorizontalButton = new Button("Voltaer H");
    private final Button duplicationButton = new Button("Duplicar");
    private final Button divideButton = new Button("Dividir");

    public ActionBox() {
        Button[] actionsArr = {rotateButton, reflectVerticalButton, reflectHorizontalButton, duplicationButton, divideButton, deleteButton};
        ButtonGroup actionsGroup = new ButtonGroup();

        settingsButtonGroup(actionsArr);
        loadButtonsBox(actionsArr);
    }
}
