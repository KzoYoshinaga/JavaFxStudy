package fx28_Initialize_Binding_Reuse;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

/**
 * イニシャライザの追加
 * ビューローディング時に呼ばれる
 * @author Kzo
 *
 */
public class Controller implements Initializable {


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("Loading user data");

	}



}
