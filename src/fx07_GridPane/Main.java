package fx07_GridPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
		window.setTitle("EnbeddingLayouts");

		/* ウィンドウの×ボタンの挙動 */
		window.setOnCloseRequest(e -> {
			e.consume(); // 終了イベントを消費済みにしないと閉じちゃう
			closeProgram();});

		/* トップメニュー */
		HBox topMenu = new HBox();
		Button fileMenu = new Button("File");
		Button editMenu = new Button("Edit");
		Button helpMenu = new Button("Help");
		topMenu.getChildren().addAll(fileMenu, editMenu, helpMenu);

		/* 左サイドメニュー */
		VBox leftMenu = new VBox();
		Button workspaceMenu = new Button("Workspace");
		Button projectMenu = new Button("Project");
		Button packageMenu = new Button("Package");
		leftMenu.getChildren().addAll(workspaceMenu, projectMenu, packageMenu);

		/* 親レイアウト */
		BorderPane root = new BorderPane();
		root.setTop(topMenu);
		root.setLeft(leftMenu);

		window.setScene(new Scene(root, 300, 300));

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
