package frontend.buttonBoxes;

import backend.model.builders.*;
import backend.model.interfaces.FigureBuilder;
import frontend.exceptions.NoFigureSelectedException;
import frontend.exceptions.TrySelectedException;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;

public class FigureToolBox implements SettingsBox {
    private static final int DEFAULT_SPACING = 10;
    private static final int DEFAULT_MIN_WIDTH = 90;

    private final ToggleButton selectionButton = new ToggleButton("Seleccionar");
    private final ToggleButton rectangleButton = new ToggleButton("Rectángulo");
    private final ToggleButton circleButton = new ToggleButton("Círculo");
    private final ToggleButton squareButton = new ToggleButton("Cuadrado");
    private final ToggleButton ellipseButton = new ToggleButton("Elipse");
    private final Button deleteButton = new Button("Borrar");

    private final VBox toolBox;

    private final ToggleGroup tools = new ToggleGroup();
    private Map<ToggleButton, FigureBuilder> figureBuilderMap = new HashMap<>();

    private Runnable onDeleteAction;
    private Runnable onButtonClickAction;


    public FigureToolBox() {
        super();
        ToggleButton[] toolsArr = {rectangleButton, circleButton, squareButton, ellipseButton};

        selectionButton.setToggleGroup(tools);
        selectionButton.setMinWidth(DEFAULT_MIN_WIDTH);
        selectionButton.setCursor(Cursor.HAND);

        for(ToggleButton button : toolsArr){
            button.setToggleGroup(tools);
            button.setMinWidth(DEFAULT_MIN_WIDTH);
            button.setCursor(Cursor.HAND);
            button.setOnAction(event -> onButtonClickAction.run());
        }

        toolBox = new VBox(DEFAULT_SPACING);
        settings(toolBox);
        toolBox.getChildren().add(selectionButton);
        toolBox.getChildren().addAll(toolsArr);
        toolBox.getChildren().addAll(deleteButton);


        deleteButton.setMinWidth(DEFAULT_MIN_WIDTH);
        deleteButton.setCursor(Cursor.HAND);
        deleteButton.setOnAction(event -> {
            TrySelectedException.tryRunning(onDeleteAction);
        });

        figureBuilderMap = Map.of(
                rectangleButton, new RectangleBuilder(),
                circleButton, new CircleBuilder(),
                squareButton, new SquareBuilder(),
                ellipseButton, new EllipseBuilder()
        );
    }

    public FigureBuilder getSelectedFigureBuilder() {
        Toggle selectedToggle = tools.getSelectedToggle();
        if (selectedToggle instanceof ToggleButton) {
            return figureBuilderMap.get(selectedToggle);
        }
        return null;
    }

    public boolean isSelectionButtonActive() {
        return selectionButton.isSelected();
    }

    public void setOnDeleteAction(Runnable action) {
        this.onDeleteAction = action;
    }

    public void setOnButtonClickAction(Runnable action){
        this.onButtonClickAction = action;
    }

    @Override
    public Pane getBox() {
        return toolBox;
    }
}
