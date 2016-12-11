package fx01_SimpleWindow;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * シンプルなウインドウを作ります
 * デフォルトで右上ボタン(閉じる、最小化、最大化)とサイズ変更などが実装されている
 * @author Kzo
 *
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.show();
		} catch (Exception e) { e.printStackTrace(); }
	}

	public static void main(String[] args) {
		launch(args);
	}

}
