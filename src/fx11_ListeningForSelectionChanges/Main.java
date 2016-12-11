package fx11_ListeningForSelectionChanges;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ChoiceBox選択変更を監視する
 * 変更があるたびにハンドラに送る
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;
	Button button;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("Change Listener");

		/* コンポネントの作成 */
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().add("Bacon");
		choiceBox.getItems().addAll("Oranges", "Bananas", "Apples");

		choiceBox.setValue("Oranges"); // 初期選択アイテム

		// Listen for selection changes
		choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			System.out.println("ObservableValue: " + v.getValue() + " OldValue: " + oldValue + " NewValue" + newValue);
			});
		choiceBox.getSelectionModel().selectedIndexProperty().addListener((v, oldValue, newValue) -> {
			System.out.println("ObservableValue: " + v.getValue() + " OldValue: " + oldValue + " NewValue" + newValue);
			});

		/* レイアウト */
		VBox root = new VBox();
		root.setPadding(new Insets(20, 20, 20,20));
		root.getChildren().addAll(choiceBox);

		window.setScene(new Scene(root, 300, 300));

		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
