package fx09_Checkbox;





import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * チェックボックス
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
		window.setTitle("Checkbox");

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();});

		/* コンポネントの作成 */
		CheckBox box1 = new CheckBox("Bacon");
		box1.setSelected(true);
		CheckBox box2 = new CheckBox("Tuna");

		button = new Button("Oder Now!");
		button.setOnAction(e -> handleOptions(box1, box2)); // ボタンを押された際にチェックボックスの状態により分岐

		/* レイアウト */
		VBox root = new VBox();
		root.setPadding(new Insets(20, 20, 20,20));
		root.getChildren().addAll(box1, box2, button);

		window.setScene(new Scene(root, 300, 300));

		window.show();
	}

	/* チェックボックスの選択状態によるハンドラ */
	private void handleOptions(CheckBox box1, CheckBox box2) {
		String message = "User oder:";

		if (box1.isSelected())
			message += " Bacon";

		if (box2.isSelected())
			message += " Tuna";

		System.out.println(message);
	}


	/* 閉じる時の挙動 */
	private void closeProgram() {
		boolean isChoseClose = ConfirmBox.display("Title","Sure you want to exit?");
		if (isChoseClose)
			window.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
