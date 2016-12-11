package fx29_SceneBuilder;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SceneBuilderを使ったシーンの組み立て
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		primaryStage.setTitle("Scene Builder");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("Sample.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}


}
