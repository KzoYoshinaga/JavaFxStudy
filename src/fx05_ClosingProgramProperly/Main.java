package fx05_ClosingProgramProperly;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 終了処理の実装、ウィンドウ×ボタンのActionEventはハンドラを抜けると
 * ウィンドウを閉じてしまうので
 * e.consume() で消費してやる
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume(); // 終了イベントを消費済みにしないと閉じちゃう
			closeProgram();});

		Button button = new Button("click!");
		button.setOnAction(e -> System.out.println(ConfirmBox.display("Confirm", "Are U OK?")));

		Button saveAndCloseButton = new Button("Save and exit");
		saveAndCloseButton.setOnAction(e -> closeProgram());

		window.setScene(new Scene(new VBox(button, saveAndCloseButton),200,200));

		window.show();
	}

	private void closeProgram() {
		boolean isChoseClose = ConfirmBox.display("Title","Sure you want to exit?");
		if (isChoseClose)
			window.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
