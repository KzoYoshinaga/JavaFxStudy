package fx08_ExtractAndBalidateInput;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 入力のバリデーション(正当性検証)
 * ボタンのアクションイベントからバリデーションメソッドの呼出S
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
		window.setTitle("EnbeddingLayouts");

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume(); // 終了イベントを消費済みにしないと閉じちゃう
			closeProgram();});

		/* コンポネントの作成 */
		TextField nameInput = new TextField();
		button = new Button("Click me!");
		button.setOnAction(e -> isInt(nameInput, nameInput.getText())); // バリデートメソッド呼出

		/* レイアウト */
		VBox root = new VBox();
		root.setPadding(new Insets(20, 20, 20,20));
		root.getChildren().addAll(nameInput, button);

		window.setScene(new Scene(root, 300, 300));

		window.show();
	}

	/* バリデーションメソッド */
	private boolean isInt(TextField input, String message) {
		try {
			int age = Integer.parseInt(message);
			System.out.println("User is: " + age);
			return true;
		} catch(NumberFormatException e) {
			System.out.println("Erro: " + message + "is not a number" );
			return false;
		}
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
