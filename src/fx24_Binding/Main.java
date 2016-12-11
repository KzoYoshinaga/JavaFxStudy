package fx24_Binding;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * バインディング
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Button button;

	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		window.setTitle("Binding");


		IntegerProperty x = new SimpleIntegerProperty(3);
		IntegerProperty y = new SimpleIntegerProperty();
		IntegerProperty z = new SimpleIntegerProperty();

		y.bind(x.multiply(10));
		z.bind(y.divide(6));

		System.out.println("x: " + x.getValue());
		System.out.println("y: " + y.getValue());
		System.out.println("z: " + z.getValue() + "\n");

		x.setValue(9);

		System.out.println("x: " + x.getValue());
		System.out.println("y: " + y.getValue());
		System.out.println("z: " + z.getValue() + "\n");

		// y.setValue(9);  // リフレクションエラー
		// y.bind(z.add(10)); // リフレクションエラー　簡単に無限スタックに陥る


		button = new Button("Submit");

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
