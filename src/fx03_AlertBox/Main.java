package fx03_AlertBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * モーダルなアラートウィンドウを表示
 * @author Kzo
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Button button = new Button("click!");

		button.setOnAction(e -> AlertBox.display("Alert", "Warning!!"));

		primaryStage.setScene(new Scene(new StackPane(button),200,200));

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
