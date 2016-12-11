package fx19_RadioMenuItem;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * トグルグループの作成(グループ化されたアイテムを択一選択式にするグループ)
 *
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

		// File menu *******************
		Menu fileMenu = new Menu("File");

		// File menu items
		MenuItem newFile = new MenuItem("New...");
		newFile.setOnAction(e -> System.out.println("Create a new file...!"));
		fileMenu.getItems().add(newFile);

		fileMenu.getItems().add(new MenuItem("Open..."));
		fileMenu.getItems().add(new MenuItem("Save..."));
		fileMenu.getItems().add(new SeparatorMenuItem());
		fileMenu.getItems().add(new MenuItem("Settings..."));
		fileMenu.getItems().add(new MenuItem("Exit..."));

		// Edit menu *******************
		Menu editMenu = new Menu("_Edit");

		// Edit menu items
		editMenu.getItems().add(new MenuItem("Cut"));
		editMenu.getItems().add(new MenuItem("Copy"));

		MenuItem paste = new MenuItem("paste");
		paste.setOnAction(e -> System.out.println("Pasting some crap"));
		paste.setDisable(true);

		// Add items to menu
		editMenu.getItems().add(paste);

		// Help menu *******************
		Menu helpMenu = new Menu("Help");

		// Help menu item
		CheckMenuItem showLines = new CheckMenuItem("Show Line Numvers");
		showLines.setOnAction(e -> {
			if (showLines.isSelected())
				System.out.println("Program will now display line numbers");
			else
				System.out.println("Hiding line number");
		});

		CheckMenuItem autoSave = new CheckMenuItem("Enabele AutoSave");
		autoSave.setSelected(true);

		// Add items to menu
		helpMenu.getItems().addAll(showLines, autoSave);

		// Difficulty nenu *******************
		Menu difficultyMenu = new Menu("Dificulty");

		// Difficulty menu item
		ToggleGroup difficultyToggle = new ToggleGroup();    // トグルグループ作成

		RadioMenuItem easy = new RadioMenuItem("Easy");        // トグルアイテム作成
		RadioMenuItem medium = new RadioMenuItem("Medium");
		RadioMenuItem hard = new RadioMenuItem("Hard");

		difficultyToggle.getToggles().addAll(easy, medium, hard); // トグルグループに登録
		/* 等価
		 * easy.setToggleGroup(difficultyToggle);
		 * medium.setToggleGroup(difficultyToggle);
		 * hard.setToggleGroup(difficultyToggle);
		 */

		// Add items to menu
		difficultyMenu.getItems().addAll(easy, medium, hard);

		// Main menu bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, difficultyMenu);

		layout = new BorderPane();
		layout.setTop(menuBar);

		window.setScene(new Scene(layout, 400, 300));

		window.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}






















