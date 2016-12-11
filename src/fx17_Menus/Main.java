package fx17_Menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * メニューの作成
 * MenuBar -> Menu -> MenuItem
 *
 * セパレータの挿入
 * Alt + キー での頭文字アクセス
 * 使用不可状態にする
 *
 * 入れ子のメニュー
 * MenuBar -> Menu -> Menu -> Menuitem
 *	File
 *	  Menu
 *		Menu
 *		  MenuItem
 *
 * @author Kzo
 *
 */
public class Main extends Application {

	Stage window;
	BorderPane layout;

	@Override
	public void start(Stage primaryStage) {

		window = primaryStage;
		window.setTitle("Tree View");

		/* コンポネントの作成 */

		// File menu
		Menu fileMenu = new Menu("File");

		// File menu items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new file...!"));
		fileMenu.getItems().add(newFile);

		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem()); // セパレータ
		fileMenu.getItems().add(new MenuItem("Settings..."));

		// Exit menu
		Menu exitMenu = new Menu("Exit...");

		MenuItem saveAndExit = new MenuItem("Save And Exit");
		MenuItem QuickExit = new MenuItem("QuickExit");

		exitMenu.getItems().addAll(saveAndExit, QuickExit);

		fileMenu.getItems().add(exitMenu);                     // 入れ子のメニュー

		// Edit menu
		Menu editMenu = new Menu("_Edit");            // メニュー名の先頭にアンダースコアを付けると
														// Altキーで頭文字アクセスできる
		// Edit menu items
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));

		MenuItem paste = new MenuItem("paste");
		paste.setOnAction(e -> System.out.println("Pasting some crap"));
		paste.setDisable(true);                   // 使用不可
		editMenu.getItems().add(paste);

		// Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu);

		layout = new BorderPane();
		layout.setTop(menuBar);

		window.setScene(new Scene(layout, 400, 300));

		window.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
