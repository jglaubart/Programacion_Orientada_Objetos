package frontend.exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class TrySelectedException {
    /**
     * Verifica si se debe lanzar alerta
     */
    public static void tryRunning(Runnable action){
        try {
            action.run();
        }catch(NoFigureSelectedException e){
            showAlert("Error", e.getMessage());
        }
    }
    /**
     * Metodo para lanzar alerta en pantalla
     */
    private static void showAlert(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR); // Define el tipo de alerta como ERROR
        alert.setTitle(title); // Título de la ventana
        alert.setHeaderText(null); // Sin cabecera
        alert.setContentText(content); // Mensaje del error
        alert.getButtonTypes().setAll(ButtonType.OK); // Agrega únicamente el botón "Aceptar"
        alert.showAndWait(); // Muestra la alerta y espera a que se cierre
    }
}
