package frontend;

import backend.CanvasState;
import backend.Layer;
import backend.model.FiguresPair;
import backend.model.figures.*;
import frontend.buttonBoxes.FigureActionBox;
import frontend.buttonBoxes.FigureLayerBox;
import frontend.buttonBoxes.FigurePropertiesBox;
import frontend.buttonBoxes.FigureToolBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import backend.model.builders.*;

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

	private final Layer currentLayer;

	private final FigureToolBox figureToolBox;
	private final FigureActionBox figureActionBox;

	Point startPoint;
	Figure selectedFigure;
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;

		gc.setLineWidth(1);

		figureToolBox = new FigureToolBox(); // no se va a necesitar el color

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
				FiguresPair figuresPair = selectedFigure.divide();
				canvasState.deleteFigure(selectedFigure);
				// figuresPair.getLeft().draw(drawer);
				canvasState.addFigure(figuresPair.getLeft());
				canvasState.addFigure(figuresPair.getRight());
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para dividir");
			}
		});

		FigurePropertiesBox figurePropertiesBox = new FigurePropertiesBox(DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR2);



		FigureLayerBox figureLayerBox = new FigureLayerBox();

		figureLayerBox.setBringToFrontAction(() -> {
			if (selectedFigure != null) {

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
					ColorConverter.toRGBColor(figurePropertiesBox.getSelectedFillColor()),
					ColorConverter.toRGBColor(figurePropertiesBox.getSecondarySelectedFillColor()),
					INVERSE_SHADOW_OFFSET,
					ColorConverter.toRGBColor(Color.GRAY),
					figurePropertiesBox.getBeveledState()
			);

			canvasState.addFigure(newFigure);
			startPoint = null;
			redrawCanvas();
		});


		canvas.setOnMouseMoved(event -> {
			Point eventPoint = new Point(event.getX(), event.getY());
			boolean found = false;
			StringBuilder label = new StringBuilder();

			for (Layer layer : canvasState.getLayers()) {
				for (Figure figure : layer.getFigures()) {
					if(figure.belongs(eventPoint)) {
						found = true;
						label.append(figure.toString());
					}
				}
			}
			// Anterior
			/*for(Figure figure : canvasState.figures()) {
				if(figure.belongs(eventPoint)) {
					found = true;
					label.append(figure.toString());
				}
			}*/
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
				for (Layer layer : canvasState.getLayers()) {
					for (Figure figure : layer.getFigures()) {
						if(figure.belongs(eventPoint)) {
							found = true;
							selectedFigure = figure;
							label.append(figure.toString());
						}
					}
				}
				// anterior
				/*for (Figure figure : canvasState.figures()) {
					if(figure.belongs(eventPoint)) {
						found = true;
						selectedFigure = figure;
						label.append(figure.toString());
					}
				}*/
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

		VBox ToolAndPropertiesBox = new VBox();
		VBox.setVgrow(figurePropertiesBox.getBox(), Priority.ALWAYS);
		ToolAndPropertiesBox.setStyle("-fx-background-color: #999");
		ToolAndPropertiesBox.setPrefWidth(100);

		ToolAndPropertiesBox.getChildren().addAll(figureToolBox.getBox(), figurePropertiesBox.getBox());


		setLeft(ToolAndPropertiesBox);
		setCenter(canvas);
		setRight(figureActionBox.getBox());
		setTop(figureLayerBox.getBox());
	}

	void redrawCanvas() {
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		for (Layer layer : canvasState.getLayers()) {
			for (Figure figure : layer.getFigures()) {
				if(figure == selectedFigure) {
					gc.setStroke(Color.RED);
				} else {
					gc.setStroke(LINE_COLOR);
				}

				JavaFXDrawer drawer = new JavaFXDrawer(gc);

				figure.draw(drawer);
			}
		}
		// Anterior
		/*for(Figure figure : canvasState.figures()) {
			if(figure == selectedFigure) {
				gc.setStroke(Color.RED);
			} else {
				gc.setStroke(LINE_COLOR);
			}

			JavaFXDrawer drawer = new JavaFXDrawer(gc);

			figure.draw(drawer);
		}*/
	}
}
