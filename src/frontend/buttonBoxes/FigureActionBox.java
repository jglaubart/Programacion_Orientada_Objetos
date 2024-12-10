package frontend.buttonBoxes;

import frontend.exceptions.TrySelectedException;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class FigureActionBox implements SettingsBox {
    private final Button rotateButton = new Button("Girar D");
    private final Button reflectVerticalButton = new Button("Voletar V");
    private final Button reflectHorizontalButton = new Button("Voltaer H");
    private final Button duplicationButton = new Button("Duplicar");
    private final Button divideButton = new Button("Dividir");

    private final VBox actionBox;

    private Runnable onRotateAction;
    private Runnable onReflectVerticalAction;
    private Runnable onReflectHorizontalAction;
    private Runnable onDuplicateAction;
    private Runnable onDivideAction;


    public FigureActionBox() {
        Button[] actionsArr = {rotateButton, reflectVerticalButton, reflectHorizontalButton, duplicationButton, divideButton};

        for(Button button : actionsArr){
            button.setMinWidth(90);
            button.setCursor(Cursor.HAND);
        }

        actionBox = new VBox(DEFAULT_SPACING);
        settings(actionBox);
        actionBox.getChildren().add(new Label("Acciones"));
        actionBox.getChildren().addAll(actionsArr);


        /**
         * Se asignan acciones a cada boton, realizando la accion especifica o lanzando una alerta en pantalla
         */
        rotateButton.setOnAction(event -> {
            TrySelectedException.tryRunning(onRotateAction);
        });

        reflectVerticalButton.setOnAction(event -> {
            TrySelectedException.tryRunning(onReflectVerticalAction);
        });

        reflectHorizontalButton.setOnAction(event -> {
            TrySelectedException.tryRunning(onReflectHorizontalAction);
        });

        duplicationButton.setOnAction(event -> {
            TrySelectedException.tryRunning(onDuplicateAction);
        });

        divideButton.setOnAction(event -> {
            TrySelectedException.tryRunning(onDivideAction);
        });

    }


    public void setOnRotateAction(Runnable action) {
        this.onRotateAction = action;
    }

    public void setOnReflectVerticalAction(Runnable action) {
        this.onReflectVerticalAction = action;
    }

    public void setOnReflectHorizontalAction(Runnable action) {
        this.onReflectHorizontalAction = action;
    }

    public void setOnDuplicateAction(Runnable action) {
        this.onDuplicateAction = action;
    }

    public void setOnDivideAction(Runnable action) {
        this.onDivideAction = action;
    }

    public VBox getActionBox() {
        return actionBox;
    }

    @Override
    public Pane getBox() {
        return actionBox;
    }
}
