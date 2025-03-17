import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebView; //navegador web
//Menu
import javafx.application.Platform; //asignar acciones sobre la plataforma

import java.util.Optional;


public class MyBrowser extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    private final WebView webView = new WebView(); //nueva variable webView
    private static final String HOME = "www.google.com.ar";
    private final TextField textField = new TextField("https://" + HOME); //Nuevo cuadro de texto. Por defecto, en el cuadro empieza diciendo esto
    private final EventHandler<ActionEvent> eventHandler = new AddressHandler();

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox();

        //Menu
        MenuBar mainMenu = new MenuBar(); //Barra de menu

        Menu file = new Menu("File"); // Menu de archivo

        MenuItem refreshMenuItem = new MenuItem("Refresh");
        refreshMenuItem.setOnAction(eventHandler);  //misma accion que el textField, vuelve a buscar lo que esta escrito
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Exit");
            alert.setContentText("Are you sure you want to Exit?");
            alert.showAndWait().
                    filter(buttonType -> buttonType.equals(ButtonType.OK)).
                    ifPresent(buttonType -> Platform.exit());
        }); //asigno la accion correspondiente al boton del menu, mostrando una alerta de confirmacion
        file.getItems().addAll(refreshMenuItem, exitMenuItem); //Agrego a los items como hijos del menu

        Menu help = new Menu("Help");
        MenuItem aboutMenuItem = new MenuItem("About");
        aboutMenuItem.setOnAction(event -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Alerta");
                    alert.setContentText("Mensaje!");
                    alert.showAndWait();
                });
        help.getItems().add(aboutMenuItem);

        mainMenu.getMenus().addAll(file, help); //Get Menus devuelve los menues que tiene la barra ya agrego los que quiero como hijos.

/// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ProgressBar progressBar = new ProgressBar();  //barra de carga
        progressBar.progressProperty().bind(
                webView.getEngine().getLoadWorker().progressProperty());

        //textField.setOnAction(event -> System.out.println(textField.getText())); //Cada vez que se escriba algo y se presiona enter (por defecto), se lo imprime por salida estandar
        textField.setOnAction(eventHandler); //ya esta definido el comportamiento, solo tengo que asignarlo
        eventHandler.handle(new ActionEvent()); //comienza la accion del buscador automaticamente

        //vBox.getChildren().add(textField);  // Cuadro de texto. ocupa un renglon y toda la pantalla de ancho por defecto
        vBox.getChildren().addAll(mainMenu, progressBar, textField, webView); //agrego la webView a la pantalla. Lo agrega en el orden que se pasa

        Scene scene = new Scene(vBox, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class AddressHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event){
            webView.getEngine().load(textField.getText());
        }  // asigno y linkeo el texto del textField con el webView
    }
}

