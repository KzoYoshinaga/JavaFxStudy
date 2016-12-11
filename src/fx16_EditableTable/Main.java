package fx16_EditableTable;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	Scene scene;

	TableView<Product> table;

	TextField nameInput, priceInput, quantityInput;


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



		/* Editable フィールドの作成 */
		nameInput = new TextField();
		nameInput.setPromptText("Neme");
		nameInput.setMinWidth(200);

		/* Editable フィールドの作成 */
		priceInput = new TextField();
		priceInput.setPromptText("Price");

		/* Editable フィールドの作成 */
		quantityInput = new TextField();
		quantityInput.setPromptText("Quantity");

		/* ボタンの作成 */
		Button addButton = new Button("Add");
		addButton.setOnAction(e -> addButtonClicked());

		Button deleteButton = new Button("Delete");
		deleteButton.setOnAction(e -> deleteButtonClicked());

		HBox buttonLayout = new HBox();
		buttonLayout.setPadding(new Insets(10,10,10,10));     // Layount内側からのパディング
		buttonLayout.setSpacing(10);                          // 配置アイテムの間隔
		buttonLayout.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);



		table = new TableView<>();
		table.setItems(getProduct());

		table.getColumns().addAll(nameColumn, priceColumn, quantityColumn); // Warning

		/* レイアウト */
		VBox layout = new VBox();
		layout.setPadding(new Insets(20, 20, 20,20));
		layout.getChildren().addAll(table, buttonLayout);

		window.setScene(new Scene(layout));

		window.show();
	}

	// アイテム追加
	private void addButtonClicked() {

		// StringEmptyガーディアン
		String nameString = nameInput.getText().trim();
		if (nameString.equals("")) return;
		String priceString = priceInput.getText().trim();
		if (priceString.equals("")) return;
		String quantityString = quantityInput.getText().trim();
		if (priceString.equals("")) return;

		// NumberFormatガーディアン
		try { Double.parseDouble(priceString); }
		catch(NumberFormatException e) { return; }
		try { Integer.parseInt(quantityString); }
		catch(NumberFormatException e) { return; }

		// MainProcessor
		String name = nameString;
		Double price = Double.parseDouble(priceString);
		Integer quantity = Integer.parseInt(quantityString);

		table.getItems().add(new Product(name, price, quantity));
	}

	// アイテム削除
	private void deleteButtonClicked() {
		// テーブルのアイテムリストから選択アイテムを削除
		ObservableList<Product> allProducts, productSelected;
		allProducts = table.getItems();
		productSelected = table.getSelectionModel().getSelectedItems();

		productSelected.forEach(allProducts::remove);
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
