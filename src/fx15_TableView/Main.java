package fx15_TableView;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TableView
 *
 * TableColumnオブジェクト作成
 *
 * "propertyName" によってカラムに追加するオブジェクトのクラスからBeansゲットする
 * TableColumn.setCellValueFactory(new PropertyValueFactory<TargetClass, ValueClass>("propertyName"))
 *
 * 入れ込むBeansオブジェクトのObservableItemListを登録
 * TableView.addItems(ObservableItemList<TargetClass>)
 *
 * カラム見出し行を追加
 * TableView.addColumns.addAll(TableColumn1 ... )
 *
 * テーブルには並べ替え機能が標準でついている！！
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;
	Button button;

	TableView<Product> table;


	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("Tree View");

		/* コンポネントの作成 */

		// Name column
		TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));

		// Price column
		TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
		priceColumn.setMinWidth(100);
		priceColumn .setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));

		// Quantity column
		TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(100);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));

		table = new TableView<>();
		table.setItems(getProduct());

		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn); // Warning

		/* レイアウト */
		VBox layout = new VBox();
		layout.setPadding(new Insets(20, 20, 20,20));
		layout.getChildren().addAll(table);

		window.setScene(new Scene(layout, 300, 300));

		window.show();
	}

	// Get all of the products
	public ObservableList<Product> getProduct() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Raspberry Pi 1",  60.0, 100));
		products.add(new Product("Raspberry Pi 2", 100.0, 100));
		products.add(new Product("Raspberry Pi 3", 300.0, 100));
		products.add(new Product("Camera 1", 300.0, 100));
		products.add(new Product("Camera 2", 300.0, 100));
		products.add(new Product("Camera 3", 300.0, 100));
		products.add(new Product("Bananana", 300.0, 100));
		products.add(new Product("Reengo", 300.0, 100));
		return products;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
