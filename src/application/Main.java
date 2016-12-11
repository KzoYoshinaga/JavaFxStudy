package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

	Button button;

	Stage window;
	Scene scene_1, scene_2;

	@Override
	public void start(Stage primaryStage) {
		try {

			window = primaryStage;

			Label label_1 = new Label("Scene1");
			Button button_1 = new Button("Go to scene_2");
			button_1.setOnAction(e -> window.setScene(scene_2));
			StackPane layout_1 = new StackPane();
			layout_1.getChildren().addAll(label_1, button_1);
			scene_1 = new Scene(layout_1, 200, 200);


			Label label_2 = new Label("Scene_2");
			Button button_2 = new Button("Go to scene_1");
			button_2.setOnAction(e -> window.setScene(scene_1));
			StackPane layout_2 = new StackPane();
			layout_2.getChildren().addAll(label_2, button_2);
			scene_2 = new Scene(layout_2, 200, 200);

			window.setTitle("Title");
			window.setScene(scene_1);
			window.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/* javafx.application.Application.launch() */
		launch(args);
	}
}

















