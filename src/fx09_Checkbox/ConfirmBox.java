package fx09_Checkbox;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {


	static boolean answer;


	public static boolean display(String title, String message) {

		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);

		Label label = new Label(message);
		Button okButton = new Button("OK");
		okButton.setOnAction(e -> {answer = true; window.close();});
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> {answer = false; window.close();});

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, okButton, cancelButton);
		layout.setAlignment(Pos.CENTER);

		window.setScene(new Scene(layout, 200, 100));

		window.showAndWait(); // Shows this stage and waits for it to be hidden (closed) before returning to the caller

		return answer;
	}
}
