package frontend;

import backend.CanvasState;
import backend.Layer;
import backend.model.FiguresPair;
import backend.model.Properties.DrawProperties;
import backend.model.ShadowType;
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
	private final JavaFXDrawer drawer = new JavaFXDrawer(gc);

	private DrawProperties currentDrawProperties;

	private Layer currentLayer;

	private final FigureToolBox figureToolBox;
	private final FigureActionBox figureActionBox;
	private final FigurePropertiesBox figurePropertiesBox;
	private final FigureLayerBox figureLayerBox;

	Point startPoint;
	Figure selectedFigure;
	StatusPane statusPane;

	public PaintPane(CanvasState canvasState, StatusPane statusPane) {
		this.canvasState = canvasState;
		this.statusPane = statusPane;
		this.currentDrawProperties = new DrawProperties(
				ColorConverter.toRGBColor(DEFAULT_FILL_COLOR),
				ColorConverter.toRGBColor(DEFAULT_FILL_COLOR2),
				ShadowType.SIMPLE,
				false
		);

		gc.setLineWidth(1);

		currentLayer = canvasState.initalizeLayers();

		figureToolBox = new FigureToolBox();

		figureToolBox.setOnDeleteAction(() -> {
			if (selectedFigure != null) {
				currentLayer.removeFigure(selectedFigure); // should pass current layer?
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
				currentLayer.addFigure(duplicatedFigure);
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para duplicar");
			}
		});

		figureActionBox.setOnDivideAction(() -> {
			if (selectedFigure != null) {
				FiguresPair figuresPair = selectedFigure.divide();
				currentLayer.removeFigure(selectedFigure);
				currentLayer.addFigure(figuresPair.getLeft());
				currentLayer.addFigure(figuresPair.getRight());
				redrawCanvas();
			} else {
				statusPane.updateStatus("Ninguna figura encontrada para dividir");
			}
		});

		figurePropertiesBox = new FigurePropertiesBox(DEFAULT_FILL_COLOR, DEFAULT_FILL_COLOR2);
		figurePropertiesBox.setOnButtonAction(() -> {
			updateDrawProperties();
			redrawCanvas();
		});

		figureLayerBox = new FigureLayerBox();

		figureLayerBox.setBringToFrontAction(() -> {
			if (selectedFigure != null) {
				currentLayer.getFigures().remove(selectedFigure);
				currentLayer.getFigures().addFirst(selectedFigure);
			}
		});

		figureLayerBox.setBringToBackAction(() -> {
			if (selectedFigure != null) {
				currentLayer.getFigures().remove(selectedFigure);
				currentLayer.getFigures().addLast(selectedFigure);
			}
		});

		figureLayerBox.setOnLayerSelected((layer) -> {
			currentLayer = layer;
			currentLayer.setShowLayer(true);
			figureLayerBox.updateVisibilityButtons(currentLayer);
			redrawCanvas();
		});

		figureLayerBox.setOnLayerVisibilityChanged((show) -> {
			currentLayer.setShowLayer(show);
			redrawCanvas();
		});

		Runnable updateLayerCombo = () -> {
			figureLayerBox.updateLayers(canvasState.getLayers(), currentLayer);
			currentLayer.setShowLayer(true);
			figureLayerBox.updateVisibilityButtons(currentLayer);
		};

		figureLayerBox.setOnAddLayerAction(() -> {
			currentLayer = canvasState.addNewLayer();
			updateLayerCombo.run();
			redrawCanvas();
		});

		figureLayerBox.setOnRemoveLayerAction(() -> {
			canvasState.removeLayer(currentLayer);
			currentLayer = canvasState.getLastLayer(); // capa 1
			updateLayerCombo.run();
			redrawCanvas();
		});

		figureLayerBox.setBringToFrontAction(() -> {
			if (selectedFigure != null) {
				currentLayer.getFigures().remove(selectedFigure);
				currentLayer.getFigures().addLast(selectedFigure);
				redrawCanvas();
			}
		});

		figureLayerBox.setBringToBackAction(() -> {
			if (selectedFigure != null) {
				currentLayer.getFigures().remove(selectedFigure);
				currentLayer.getFigures().addFirst(selectedFigure);
				redrawCanvas();
			}
		});

		//figureLayerBox.updateLayers(canvasState.getLayers(), currentLayer);
		//figureLayerBox.updateVisibilityButtons(currentLayer);

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

			updateDrawProperties();
			Figure newFigure = builder.buildFigure(startPoint, endPoint, currentDrawProperties.clone(), drawer);

			currentLayer.addFigure(newFigure);
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
					if (layer.showLayer()) {
						for (Figure figure : layer.getFigures()) {
							if(figure.belongs(eventPoint)) {
								found = true;
								selectedFigure = figure;
								currentLayer = layer;
								label.append(figure.toString());
								currentDrawProperties = selectedFigure.getDrawProperties();
								// updatePropertiesBox();
							}
						}
					}
				}
				if (found) {
					statusPane.updateStatus(label.toString());
				} else {
					if(selectedFigure != null)
						currentDrawProperties = currentDrawProperties.clone();
					selectedFigure = null;
					statusPane.updateStatus("Ninguna figura encontrada");
				}
				redrawCanvas();
				return;
			}
		});

		// Mover figura
		canvas.setOnMouseDragged(event -> {
			if(figureToolBox.isSelectionButtonActive() && selectedFigure != null) {
				Point eventPoint = new Point(event.getX(), event.getY());
				selectedFigure.changePosition(startPoint, eventPoint);
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
			if (layer.showLayer()) {
				for (Figure figure : layer.getFigures()) {
					if(figure == selectedFigure) {
						gc.setStroke(Color.RED);
					} else {
						gc.setStroke(LINE_COLOR);
					}

					figure.draw();
				}
			}
		}
	}

	private void updateDrawProperties() {
		currentDrawProperties.setBeveledState(figurePropertiesBox.getBeveledState());
		currentDrawProperties.setColor1(ColorConverter.toRGBColor(figurePropertiesBox.getSelectedFillColor()));
		currentDrawProperties.setColor2(ColorConverter.toRGBColor(figurePropertiesBox.getSecondarySelectedFillColor()));
		currentDrawProperties.setShadowType(figurePropertiesBox.getSelectedShadowType());
		//currentDrawProperties.setShadow(null);
	}
}
