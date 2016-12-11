package fx14_TreeView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TreeView
 *
 * SwingのTreeNodeと違って値を格納しないのかな？
 * DefoultTreeNodeを継承して使う必要はない
 *
 * 呼出値を返すのがTreeItemの仕事
 * 処理は別のクラスの仕事
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;
	Button button;

	TreeView<String> tree;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("Tree View");

		/* コンポネントの作成 */
		TreeItem<String> root, bucky, megan;

		// Root
		root = new TreeItem<>("Root");
		root.setExpanded(true); // 開かれた初期状態

		// Bucky
		bucky = makeBranch("Bucky", root);
		makeBranch("Ritz", bucky);
		makeBranch("Tanaka", bucky);
		makeBranch("Satou", bucky);

		// Megan
		megan = makeBranch("Megan", root);
		makeBranch("Ritz", megan);
		makeBranch("Lady GaGaGaSP", megan);
		makeBranch("Tamago", megan);

		// Create tree
		tree = new TreeView<>(root);
		tree.setShowRoot(true); // ルートノードを表示する
		tree.getSelectionModel().selectedItemProperty()		// 選択変更時のリスナ
			.addListener((v, oldValue, newValue) -> {
				if (newValue != null)
						System.out.println(newValue.getValue());
			});

		button = new Button("Submit");
		button.setOnAction(e -> System.out.println(tree.getSelectionModel().getSelectedItem().getValue()));

		/* レイアウト */
		VBox layout = new VBox();
		layout.setPadding(new Insets(20, 20, 20,20));
		layout.getChildren().addAll(tree, button);

		window.setScene(new Scene(layout, 300, 300));

		window.show();
	}

	// Create branch
	private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
		TreeItem<String> item = new TreeItem<>(title);
		parent.getChildren().add(item);
		return item;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
