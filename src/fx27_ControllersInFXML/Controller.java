package fx27_ControllersInFXML;

import javafx.scene.control.Button;

/**
 * １つのFXMLは１つだけコントローラを持つ
 * JavaScript と HTML の対応に似ている
 * @author Kzo
 *
 */
public class Controller {

	// fx:idに対応したコンポネントの作成
	public Button button;

	// onClickに対応したクリックイベントハンドラの作成
	public void handleButtonClick() {
		System.out.println("Clicked");
		button.setText("Stop touching me!");
	}


}
