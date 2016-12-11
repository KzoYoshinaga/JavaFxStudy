package fx03_AlertBox;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String title, String message) {

		Stage window = new Stage();

		// MODAL setting
		window.initModality(Modality.APPLICATION_MODAL);

		window.setTitle(title);

		window.setScene(new Scene(new StackPane(new Label(message)), 100, 20));

		window.show();
	}
}
