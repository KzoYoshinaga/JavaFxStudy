package fx27_ControllersInFXML;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * SceneBuilderを使ったシーンの組み立て
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
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root, 300,275));
		primaryStage.show();
	}


}
