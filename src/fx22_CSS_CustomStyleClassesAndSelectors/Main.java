package fx22_CSS_CustomStyleClassesAndSelectors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * カスタムクラス、セレクター
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("CSS");

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume(); // 終了イベントを消費済みにしないと閉じちゃう
			closeProgram();});


		/* スタイル適用メニューの作成 */
		RadioMenuItem caspian = new RadioMenuItem("Caspian");
		caspian.setOnAction(e -> setUserAgentStyle(STYLESHEET_CASPIAN));

		RadioMenuItem modena = new RadioMenuItem("Modena");
		modena.setOnAction(e -> setUserAgentStyle(STYLESHEET_MODENA));

		ToggleGroup agentStyleGroup = new ToggleGroup();
		agentStyleGroup.getToggles().addAll(caspian, modena);

		Menu agentStyleMenu = new Menu("Style");
		agentStyleMenu.getItems().addAll(caspian, modena);

		// シーンにCSS適用
		RadioMenuItem vipper = new RadioMenuItem("Vipper");
		vipper.setOnAction(e -> setSceneStyle("Vipper.css"));

		RadioMenuItem vipper2 = new RadioMenuItem("Vipper2");
		vipper2.setOnAction(e -> setSceneStyle("Vipper2.css"));

		ToggleGroup sceneStyleGroup = new ToggleGroup();
		sceneStyleGroup.getToggles().addAll(vipper, vipper2);

		Menu sceneStyleMenu = new Menu("SceneStyle");
		sceneStyleMenu.getItems().addAll(vipper, vipper2);

		// メニューバー
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(agentStyleMenu, sceneStyleMenu);


		VBox vbox = new VBox();
		vbox.getChildren().addAll(menuBar, composeGrid());

		scene = new Scene(vbox, 300,300);

		window.setScene(scene);

		window.show();
	}

	// スタイル適用
	private void setUserAgentStyle(String style) {
		setUserAgentStylesheet(style);
	}

	private void setSceneStyle(String styleFile) {
		scene.getStylesheets().clear();
		scene.getStylesheets().add(getClass().getResource(styleFile).toExternalForm());
	}

	private GridPane composeGrid() {
		/* グリッドレイアウト */
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10)); // Insets : A set of inside offsets for the 4 side of a rectangular area
		grid.setVgap(8); // virtical gapping
		grid.setHgap(10); // horizontal gapping

		Label nameLabel = new Label("Username:");
		nameLabel.setId("bold-label");                     // カスタムIDを設定
		GridPane.setConstraints(nameLabel, 0, 0);

		TextField nameInput = new TextField("Kzo");
		GridPane.setConstraints(nameInput, 1, 0);

		Label passLabel = new Label("Password:");
		GridPane.setConstraints(passLabel, 0, 1);

		PasswordField passInput = new PasswordField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);


		Button loginButton = new Button("Log In");
		GridPane.setConstraints(loginButton, 1, 2);

		// Sign up
		Button signUpButton = new Button("Sign up");
		signUpButton.getStyleClass().add("button-blue"); // カスタムクラス名を設定
		GridPane.setConstraints(signUpButton, 1, 3);

		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signUpButton);

		return grid;
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






























