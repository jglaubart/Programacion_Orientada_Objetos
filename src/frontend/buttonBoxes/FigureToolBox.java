package frontend.buttonBoxes;

import backend.model.builders.*;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class FigureToolBox implements FillBox {
    private static final int DEFAULT_SPACING = 10;

    private final ToggleButton selectionButton = new ToggleButton("Seleccionar");
    private final ToggleButton rectangleButton = new ToggleButton("Rectángulo");
    private final ToggleButton circleButton = new ToggleButton("Círculo");
    private final ToggleButton squareButton = new ToggleButton("Cuadrado");
    private final ToggleButton ellipseButton = new ToggleButton("Elipse");
    private final Button deleteButton = new Button("Borrar");

    private final VBox figureBox;
    private final ColorPicker fillColorPicker;

    private final ToggleGroup tools = new ToggleGroup();
    private Map<ToggleButton, FigureBuilder> figureBuilderMap = new HashMap<>();

    private Runnable onDeleteAction;


    public FigureToolBox(Color defaultcolor) {super();
        fillColorPicker = new ColorPicker(defaultcolor);

        ToggleButton[] toolsArr = {selectionButton, rectangleButton, circleButton, squareButton, ellipseButton};

        for(ToggleButton button : toolsArr){
            button.setToggleGroup(tools);
            button.setMinWidth(90);
            button.setCursor(Cursor.HAND);
        }

        figureBox = loadBox(toolsArr);

        deleteButton.setMinWidth(90);
        deleteButton.setCursor(Cursor.HAND);
        deleteButton.setOnAction(event -> {
            onDeleteAction.run();
        });

        figureBox.getChildren().addAll(deleteButton, fillColorPicker);

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

    public Color getSelectedFillColor() {
        return fillColorPicker.getValue();
    }

    public boolean isSelectionButtonActive() {
        return selectionButton.isSelected();
    }

    public VBox getFigureBox() {
        return figureBox;
    }

    public void setOnDeleteAction(Runnable action) {
        this.onDeleteAction = action;
    }

}
