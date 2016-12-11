package fx25_BindingSample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * バインディング
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Binding Sample");




		VBox layout = new VBox();

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
