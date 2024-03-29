package fx25_BindingSample;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * コンポネント同士のバインディングサンプル
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Binding Sample");

		// Input and labels
		TextField userInput = new TextField();
		userInput.setMaxWidth(200);

		Label firstLabel = new Label("Welcome to the site ");
		Label secondLabel = new Label();

		HBox bottomText = new HBox(firstLabel, secondLabel);
		bottomText.setAlignment(Pos.CENTER);

		VBox layout = new VBox(10, userInput, bottomText);
		layout.setAlignment(Pos.CENTER);

		// ラベルの文字をテキストフィールドの文字にバインドする
		secondLabel.textProperty().bind(userInput.textProperty());

		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
