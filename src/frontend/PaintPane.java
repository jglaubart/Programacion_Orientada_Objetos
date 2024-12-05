package frontend;

import backend.CanvasState;
import backend.model.figures.*;
import backend.RGBColor;
import frontend.buttonBoxes.FigureBox;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
	private final Color defaultFillColor2 = Color.ORANGE; // NOMBRE DE MIERDA !!!!!!!!!!

	private Map<ToggleButton, FigureBuilder> figureBuilderMap = new HashMap<>();


	ColorPicker fillColorPicker = new ColorPicker(defaultFillColor);
	Point startPoint;
	Figure selectedFigure;
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;

		gc.setLineWidth(1); // QUE PASA SI NO ESTA ESTA LINEA?

		VBox figuresBox = new FigureBox(canvasState, gc, fillColorPicker);
		VBox propertiesBox = configurePropertiesButtons();


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

			ToggleButton selectedButton = (ToggleButton) ((FigureBox) figuresBox).getTools().getSelectedToggle();
			if(selectedButton == null) {
				return ;
			}

			FigureBuilder builder = ((FigureBox) figuresBox).getFigureBuilderMap().get(selectedButton);
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
			if(((FigureBox) figuresBox).getSelectionButton().isSelected()) {
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
			if(((FigureBox) figuresBox).getSelectionButton().isSelected() && selectedFigure != null) {
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
}
