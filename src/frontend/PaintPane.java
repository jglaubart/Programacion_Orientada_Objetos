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
	private final ToggleButton deleteButton = new ToggleButton("Borrar");

	private final ToggleButton rotateButton = new ToggleButton("Girar D");
	private final ToggleButton reflectVerticalButton = new ToggleButton("Voletar V");
	private final ToggleButton reflectHorizontalButton = new ToggleButton("Voltaer H");
	private final ToggleButton duplicationButton = new ToggleButton("Duplicar");
	private final ToggleButton divideButton = new ToggleButton("Dividir");

	private Map<ToggleButton, FigureBuilder> figureBuilderMap = new HashMap<>();
	private Map<ToggleButton, Runnable> figureActionsMap = new HashMap<>();

	ColorPicker fillColorPicker = new ColorPicker(defaultFillColor);
	Point startPoint;
	Figure selectedFigure;
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;

		ToggleButton[] toolsArr = {selectionButton, rectangleButton, circleButton, squareButton, ellipseButton, deleteButton};
		ToggleGroup tools = new ToggleGroup();

		ToggleButton[] actionsArr = {rotateButton, reflectVerticalButton, reflectHorizontalButton, duplicationButton, divideButton};
		ToggleGroup actionsGroup = new ToggleGroup();

		settingsButtonGroup(toolsArr, tools);
		VBox figuresBox = loadButtonsBox(toolsArr);
		figuresBox.getChildren().add(fillColorPicker);

		settingsButtonGroup(actionsArr, actionsGroup);
		VBox actionsBox = loadButtonsBox(actionsArr);
		Label titleLabel = new Label("Acciones:");
		actionsBox.getChildren().addFirst(titleLabel);

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

	private VBox loadButtonsBox(ToggleButton[] array) {
		VBox box = new VBox(10);
		box.getChildren().addAll(array);
		box.setPadding(new Insets(5));
		box.setStyle("-fx-background-color: #999");
		box.setPrefWidth(100);
		gc.setLineWidth(1);

		return box;
	}

	public void settingsButtonGroup(ToggleButton[] array, ToggleGroup group) {
		for (ToggleButton button : array) {
			button.setMinWidth(90);
			button.setToggleGroup(group);
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
