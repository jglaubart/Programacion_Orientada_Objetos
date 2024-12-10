package frontend.buttonBoxes;

import frontend.exceptions.NoFigureSelectedException;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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


        rotateButton.setOnAction(event -> {
            try {
                onRotateAction.run();
            }catch(NoFigureSelectedException e){
                this.showAlert("Error", e.getMessage());
            }
        });

        reflectVerticalButton.setOnAction(event -> {
            onReflectVerticalAction.run();
        });

        reflectHorizontalButton.setOnAction(event -> {
            onReflectHorizontalAction.run();
        });

        duplicationButton.setOnAction(event -> {
            onDuplicateAction.run();
        });

        divideButton.setOnAction(event -> {
            onDivideAction.run();
        });

    }

    // Método para mostrar la alerta
    private void showAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR); // Define el tipo de alerta como ERROR
        alert.setTitle(title); // Título de la ventana
        alert.setHeaderText(null); // Sin cabecera
        alert.setContentText(content); // Mensaje del error
        alert.getButtonTypes().setAll(ButtonType.OK); // Agrega únicamente el botón "Aceptar"
        alert.showAndWait(); // Muestra la alerta y espera a que se cierre
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
