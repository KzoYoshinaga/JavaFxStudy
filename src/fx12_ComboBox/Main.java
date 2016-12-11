package fx12_ComboBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ChoiceBox選択変更を監視する
 * 変更があるたびにハンドラに送る
 *
 * 特定のアイテムリストから選択してもらう他
 * 入力してもらうことも出来る
 *
 * setEditable(true)
 *
 * 入力を促す文字を表示させる
 *
 * setPomptText("Input!")
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;
	Button button;
	ComboBox<String> comboBox;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("Change Listener");

		/* コンポネントの作成 */
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll(
				"Sunday",
				"Monday",
				"Tuesday");
		comboBox.setPromptText("What is your favorite Day");

		comboBox.setEditable(true); // 選択を入力可能になる

		button = new Button("Submit");
		button.setOnAction(e -> printDay());

		comboBox.setOnAction(e -> System.out.println("User selected"));

		/* レイアウト */
		VBox root = new VBox();
		root.setPadding(new Insets(20, 20, 20,20));
		root.getChildren().addAll(comboBox, button);

		window.setScene(new Scene(root, 300, 300));

		window.show();
	}

	private void printDay() {
		System.out.println(comboBox.getValue());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
