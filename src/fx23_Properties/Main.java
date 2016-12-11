package fx23_Properties;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * プロパティー
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Button button;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Properties");

		Person bucky = new Person();
		bucky.firstNameProperty().addListener((v, oldValue, newValue) -> {
			System.out.println("Name change to " + newValue);
			System.out.println("firstNameProperty(): " + bucky.firstNameProperty());
			System.out.println("getFirstName(): " + bucky.getFirstName());
		});

		button = new Button("Submit");
		button.setOnAction(e -> {
			bucky.setFirstName("Porky");
		});

		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene scene = new Scene(layout, 300, 250);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
