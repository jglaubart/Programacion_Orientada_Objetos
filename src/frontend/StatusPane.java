package frontend;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class StatusPane extends BorderPane {
	private static final String DEFAULT_STYLE = "-fx-background-color: #4EBCF8";
	private static final String DEFAULT_LABEL_STYLE = "-fx-font-size: 16";
	private final Label statusLabel;

	public StatusPane() {
		setStyle(DEFAULT_STYLE);
		statusLabel = new Label("");
		statusLabel.setAlignment(Pos.CENTER);
		statusLabel.setStyle(DEFAULT_LABEL_STYLE);
		setCenter(statusLabel);
	}
	
	public void updateStatus(String text) {
		statusLabel.setText(text);
	}

}