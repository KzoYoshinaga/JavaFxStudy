package fx10_ChoiceBox_DropDown;





import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * ドロップダウン選択ボックス
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
		window.setTitle("Choicebox - DropDown");

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();});

		/* コンポネントの作成 */
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().add("Bacon");
		choiceBox.getItems().addAll("Oranges", "Bananas", "Apples");

		choiceBox.setValue("Oranges"); // 初期表示アイテム


		button = new Button("Choice your favorite one!");
		button.setOnAction(e -> getChoice(choiceBox));


		/* レイアウト */
		VBox root = new VBox();
		root.setPadding(new Insets(20, 20, 20,20));
		root.getChildren().addAll(choiceBox, button);

		window.setScene(new Scene(root, 300, 300));

		window.show();
	}

	private void getChoice(ChoiceBox<String> box) {
		String food = box.getValue();
		System.out.println("Your favarite food is: " + food);
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
