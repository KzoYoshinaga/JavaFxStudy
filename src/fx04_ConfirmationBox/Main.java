package fx04_ConfirmationBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * 操作の結果を受け取ることが出来るサブウィンドウ
 * window.showAndWait() で、サブウィンドウは閉じるまで処理を戻さない
 * @author Kzo
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Button button = new Button("click!");

		button.setOnAction(e -> System.out.println(ConfirmBox.display("Confirm", "Are U OK?")));

		primaryStage.setScene(new Scene(new StackPane(button),200,200));

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
