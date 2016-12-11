package fx06_EnbeddingLayouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * レイアウトの合成
 * HBoxとVBox、をBorderPaneの上と左にセット
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("GridLayout");

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume(); // 終了イベントを消費済みにしないと閉じちゃう
			closeProgram();});

		/* グリッドレイアウト */
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10)); // Insets : A set of inside offsets for the 4 side of a rectangular area
		grid.setVgap(8); // virtical gapping
		grid.setHgap(10); // horizontal gapping

		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0, 0);

		TextField nameInput = new TextField("Kzo");
		GridPane.setConstraints(nameInput, 1, 0);

		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);

		PasswordField passInput = new PasswordField(); // 入力された文字をマスクする
		passInput.setPromptText("password");   // グレー初期文字、カーソルインで消える
		GridPane.setConstraints(passInput, 1, 1);


		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);

		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);

		window.setScene(new Scene(grid, 300,300));

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
