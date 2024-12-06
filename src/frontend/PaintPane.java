package frontend;

import backend.CanvasState;
import backend.model.figures.*;
import frontend.buttonBoxes.FigureActionBox;
import frontend.buttonBoxes.FigureToolBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import backend.model.builders.*;
import javax.swing.*;

public class PaintPane extends BorderPane {
	private static final Color LINE_COLOR = Color.BLACK;
	private static final Color DEFAULT_FILL_COLOR = Color.YELLOW;
	private static final Color DEFAULT_FILL_COLOR2 = Color.ORANGE;
	private static final double DUPE_OFFSET = 20.0;
	private static final double SHADOW_OFFSET = 10.0;
	private static final double INVERSE_SHADOW_OFFSET = -SHADOW_OFFSET;

	private final CanvasState canvasState;
	private final Canvas canvas = new Canvas(800, 600);
	private final GraphicsContext gc = canvas.getGraphicsContext2D();


	private final FigureToolBox figureToolBox;
	private final FigureActionBox figureActionBox;

	Point startPoint;
	Figure selectedFigure;
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;

		gc.setLineWidth(1);

		figureToolBox = new FigureToolBox(DEFAULT_FILL_COLOR);

		figureToolBox.setOnDeleteAction(() -> {
			if (selectedFigure != null) {
				canvasState.deleteFigure(selectedFigure);
				selectedFigure = null;
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada");
			}
		});

		figureActionBox = new FigureActionBox();

		figureActionBox.setOnRotateAction(() -> {
			if (selectedFigure != null) {
				selectedFigure.rotate();
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para rotar");
			}
		});

		figureActionBox.setOnReflectVerticalAction(() -> {
			if (selectedFigure != null) {
				selectedFigure.reflectVertical();
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para reflejar verticalmente");
			}
		});

		figureActionBox.setOnReflectHorizontalAction(() -> {
			if (selectedFigure != null) {
				selectedFigure.reflectHorizontal();
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para reflejar horizontalmente");
			}
		});

		figureActionBox.setOnDuplicateAction(() -> {
			if (selectedFigure != null) {
				Figure duplicatedFigure = selectedFigure.duplicate(DUPE_OFFSET);
				canvasState.addFigure(duplicatedFigure);
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para duplicar");
			}
		});

		figureActionBox.setOnDivideAction(() -> {
			if (selectedFigure != null) {
				selectedFigure.divide();
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para dividir");
			}
		});


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

			FigureBuilder builder = figureToolBox.getSelectedFigureBuilder();

			if(builder == null) {
				return ;
			}

			Figure newFigure = builder.buildFigure(
					startPoint,
					endPoint,
					ColorConverter.toRGBColor(figureToolBox.getSelectedFillColor()),
					ColorConverter.toRGBColor(DEFAULT_FILL_COLOR2),
					INVERSE_SHADOW_OFFSET,
					ColorConverter.toRGBColor(Color.GRAY),
					false
			);
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
			if(figureToolBox.isSelectionButtonActive()) {
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
			if(figureToolBox.isSelectionButtonActive() && selectedFigure != null) {
				Point eventPoint = new Point(event.getX(), event.getY());
				selectedFigure.changePosition(startPoint, eventPoint); // DESREFERENCIA NULL
				startPoint = eventPoint;
				redrawCanvas();
			}
		});

		setLeft(figureToolBox.getFigureBox());
		setCenter(canvas);
		setRight(figureActionBox.getActionBox());
	}

	void redrawCanvas() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for(Figure figure : canvasState.figures()) {
			if(figure == selectedFigure) {
				gc.setStroke(Color.RED);
			} else {
				gc.setStroke(LINE_COLOR);
			}

			JavaFXDrawer drawer = new JavaFXDrawer(gc);

			figure.draw(drawer);
		}
	}
}
