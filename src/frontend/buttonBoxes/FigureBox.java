package frontend.buttonBoxes;

import backend.CanvasState;
import backend.model.builders.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class FigureBox extends Box {
    private static final int DEFAULT_SPACING = 10;

    private final ToggleButton selectionButton = new ToggleButton("Seleccionar");
    private final ToggleButton rectangleButton = new ToggleButton("Rectángulo");
    private final ToggleButton circleButton = new ToggleButton("Círculo");
    private final ToggleButton squareButton = new ToggleButton("Cuadrado");
    private final ToggleButton ellipseButton = new ToggleButton("Elipse");
    private final Button deleteButton = new Button("Borrar");

    private final CanvasState canvasState;
    private final GraphicsContext gc;

    private final ToggleGroup tools = new ToggleGroup();
    private Map<ToggleButton, FigureBuilder> figureBuilderMap = new HashMap<>();

    public FigureBox(CanvasState canvasState, GraphicsContext gc, ColorPicker colorPicker) {
        super();
        this.canvasState = canvasState;
        this.gc = gc;
        ToggleButton[] toolsArr = {selectionButton, rectangleButton, circleButton, squareButton, ellipseButton};
        for(ToggleButton button : toolsArr){
            button.setToggleGroup(tools);
        }

        settingsButtonGroup(toolsArr);
        loadButtonsBox(toolsArr);
        this.getChildren().add(colorPicker);

        figureBuilderMap = Map.of(
                rectangleButton, new RectangleBuilder(),
                circleButton, new CircleBuilder(),
                squareButton, new SquareBuilder(),
                ellipseButton, new EllipseBuilder()
        );
    }

    public Map<ToggleButton, FigureBuilder> getFigureBuilderMap() {
        return figureBuilderMap;
    }

    public ToggleGroup getTools() {
        return tools;
    }

    public ToggleButton getSelectionButton() {
        return selectionButton;
    }
}
