package fx29_SceneBuilder;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

/**
 * @author Kzo
 *
 */
public class Controller implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Loading user data");

	}

	public void loginButtonClicked() {
		System.out.println("User logged in...");
	}



}
