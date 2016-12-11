package fx28_Initialize_Binding_Reuse;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controllerのイニシャライジング
 * FXML上でのバインディング $マーク
 * FXML上で再利用すｒオブジェクトの作成
 *
 * カッコの読み方
 *
 * 種類	日本語名１			日本語名２			  英語名１  	 英語名２
 * ()	丸括弧（まるかっこ）小括弧（しょうかっこ）Parentheses	 Round brackets
 * {}	波括弧（なみかっこ）中括弧（ちゅうかっこ）Braces		 Curly brackets
 * []	角括弧（かくかっこ）大括弧（だいかっこ）  Box brackets	 Square brackets
 * <>	山括弧（やまかっこ）	 				  Angle brackets
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(root, 300,275));
		primaryStage.show();
	}


}
