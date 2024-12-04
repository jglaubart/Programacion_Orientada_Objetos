package frontend;

import backend.CanvasState;
import backend.model.figures.Point;
import backend.model.figures.*;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import backend.model.builders.*;

import javax.swing.*;

public class PaintPane extends BorderPane {
	private final CanvasState canvasState;

	private final Canvas canvas = new Canvas(800, 600);
	private final GraphicsContext gc = canvas.getGraphicsContext2D();
	private final Color lineColor = Color.BLACK;
	private final Color defaultFillColor = Color.YELLOW;

	private final ToggleButton selectionButton = new ToggleButton("Seleccionar");
	private final ToggleButton rectangleButton = new ToggleButton("Rectángulo");
	private final ToggleButton circleButton = new ToggleButton("Círculo");
	private final ToggleButton squareButton = new ToggleButton("Cuadrado");
	private final ToggleButton ellipseButton = new ToggleButton("Elipse");

	private final Button deleteButton = new Button("Borrar");

	private final Button rotateButton = new Button("Girar D");
	private final Button reflectVerticalButton = new Button("Voletar V");
	private final Button reflectHorizontalButton = new Button("Voltaer H");
	private final Button duplicationButton = new Button("Duplicar");
	private final Button divideButton = new Button("Dividir");

	private Map<ToggleButton, FigureBuilder> figureBuilderMap = new HashMap<>();
	private Map<ToggleButton, Runnable> figureActionsMap = new HashMap<>();

	ColorPicker fillColorPicker = new ColorPicker(defaultFillColor);
	Point startPoint;
	Figure selectedFigure;
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;

		ToggleButton[] toolsArr = {selectionButton, rectangleButton, circleButton, squareButton, ellipseButton};
		ToggleGroup tools = new ToggleGroup();
		for(ToggleButton button : toolsArr){
			button.setToggleGroup(tools);
		}

		Button[] actionsArr = {rotateButton, reflectVerticalButton, reflectHorizontalButton, duplicationButton, divideButton, deleteButton};
		ButtonGroup actionsGroup = new ButtonGroup();

		settingsButtonGroup(toolsArr);
		VBox figuresBox = loadButtonsBox(toolsArr);
		figuresBox.getChildren().add(fillColorPicker);

		settingsButtonGroup(actionsArr);
		VBox actionsBox = loadButtonsBox(actionsArr);

		figureBuilderMap = Map.of(
				rectangleButton, new RectangleBuilder(),
				circleButton, new CircleBuilder(),
				squareButton, new SquareBuilder(),
				ellipseButton, new EllipseBuilder()
		);

		figureActionsMap = Map.of(
				
		);

		canvas.setOnMousePressed(event -> {
			startPoint = new Point(event.getX(), event.getY());
		});

		canvas.setOnMouseReleased(event -> {
			Point endPoint = new Point(event.getX(), event.getY());
			if(startPoint == null) {
				return ;
			}
			if(endPoint.getX() < startPoint.getX() || endPoint.getY() < startPoint.getY()) {
				return ;
			}

			ToggleButton selectedButton = (ToggleButton) tools.getSelectedToggle();
			if(selectedButton == null) {
				return ;
			}

			FigureBuilder builder = figureBuilderMap.get(selectedButton);
			if(builder == null) {
				return ;
			}
			Figure newFigure = builder.buildFigure(startPoint, endPoint, ColorConverter.toRGBColor(fillColorPicker.getValue()));
			canvasState.addFigure(newFigure);
			startPoint = null;
			redrawCanvas();
		});


		canvas.setOnMouseMoved(event -> {
			Point eventPoint = new Point(event.getX(), event.getY());
			boolean found = false;
			StringBuilder label = new StringBuilder();
			for(Figure figure : canvasState.figures()) {
				if(figure.belongs(eventPoint)) {
					found = true;
					label.append(figure.toString());
				}
			}
			if(found) {
				statusPane.updateStatus(label.toString());
			} else {
				statusPane.updateStatus(eventPoint.toString());
			}
		});

		canvas.setOnMouseClicked(event -> {
			if(selectionButton.isSelected()) {
				Point eventPoint = new Point(event.getX(), event.getY());
				boolean found = false;
				StringBuilder label = new StringBuilder("Se seleccionó: ");
				for (Figure figure : canvasState.figures()) {
					if(figure.belongs(eventPoint)) {
						found = true;
						selectedFigure = figure;
						label.append(figure.toString());
					}
				}
				if (found) {
					statusPane.updateStatus(label.toString());
				} else {
					selectedFigure = null;
					statusPane.updateStatus("Ninguna figura encontrada");
				}
				redrawCanvas();
			}
		});

		// Mover figura
		canvas.setOnMouseDragged(event -> {
			if(selectionButton.isSelected() && selectedFigure != null) {
				Point eventPoint = new Point(event.getX(), event.getY());
				selectedFigure.changePosition(startPoint, eventPoint); // DESREFERENCIA NULL
				startPoint = eventPoint;
				redrawCanvas();
			}
		});

		deleteButton.setOnAction(event -> {
			if (selectedFigure != null) {
				canvasState.deleteFigure(selectedFigure);
				selectedFigure = null;
				redrawCanvas();
			}
		});

		setLeft(figuresBox);
		setCenter(canvas);
		setRight(actionsBox);
	}

	void redrawCanvas() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(Figure figure : canvasState.figures()) {
			if(figure == selectedFigure) {
				gc.setStroke(Color.RED);
			} else {
				gc.setStroke(lineColor);
			}

			gc.setFill(ColorConverter.toJavaFXColor(figure.getColor()));

			JavaFXDrawer drawer = new JavaFXDrawer(gc);

			figure.draw(drawer);
		}
	}

	private VBox loadButtonsBox(ButtonBase[] array) {
		VBox box = new VBox(10);
		box.getChildren().addAll(array);
		box.setPadding(new Insets(5));
		box.setStyle("-fx-background-color: #999");
		box.setPrefWidth(100);
		gc.setLineWidth(1);

		return box;
	}

	public void settingsButtonGroup(ButtonBase[] array) {
		for (ButtonBase button : array) {
			button.setMinWidth(90);
			button.setCursor(Cursor.HAND);
		}
	}

	private void rotateSelectedFigure() {
		if (selectedFigure != null) {
			selectedFigure.rotate();
			redrawCanvas();
		}
	}
}
