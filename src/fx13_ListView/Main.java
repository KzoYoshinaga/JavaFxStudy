package fx13_ListView;

import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * リストビュー
 *
 * 複数選択できるようにする
 * getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
 *
 * ここまででJavaFXのコンポネントの扱いにパターンが見えてくる
 *
 * Swingだと
 * comboboxModel.setDefaultProperty(100);
 * のようにコンポネントの属性によって振る舞いを変えていた
 *
 * JavaFXだと
 * listView.getSelectionModel().setSelectionModel(SelectionModel.MULTIPLE);
 * layout.getChildren().add(Node);
 * など、使用者がモデルオブジェクトを取り出し
 * それに対してセッティングできるようになっている
 *
 * ListView.getSelectionModel(): MultipleSelectionModel = {}
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;
	Button button;
	ListView<String> listView;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("Change Listener");

		/* コンポネントの作成 */
		listView = new ListView<>();
		listView.getItems().addAll("Iroon Man", "Titanic", "Contact", "Cube");

		// 複数選択可能 ビューについてはカプセル化を壊し実利の設計か？
		listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);



		button = new Button("Submit");
		button.setOnAction(e -> submit());

		/* レイアウト */
		VBox root = new VBox();
		root.setPadding(new Insets(20, 20, 20,20));
		root.getChildren().addAll(listView, button);

		window.setScene(new Scene(root, 300, 300));

		window.show();
	}

	// Print out Movie
	private void submit() {
		ObservableList<String> movies;
		movies = listView.getSelectionModel().getSelectedItems(); // マルチセレクションの選択アイテムリストを得る

		System.out.println(movies.stream().collect(Collectors.joining("\n")));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
