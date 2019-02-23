package controllers.standard;

import button.ButtonType;
import javafx.fxml.FXML;
import javafx.scene.control.Toggle;

public class StandardViewController {

	@FXML
	private StandardKeyboardController standardKeyboardLayoutController;
	@FXML
	private StandardResultController standardResultLayoutController;

	@FXML
	private void initialize() {
		standardKeyboardLayoutController.injectMainViewController(this);
		standardResultLayoutController.injectMainViewController(this);
	}

	public void chooseFunction(ButtonType buttonType, String text, String side) {
		standardResultLayoutController.setSide(side);
		standardResultLayoutController.setFunction(buttonType, text, side);
	}

	public void appendInputVariable(String text, String side) {

		standardResultLayoutController.setSide(side);
		standardResultLayoutController.appendText(text);
	}

	public void changeToggle(String string) {
		standardKeyboardLayoutController.changeToggle(string);
	}

}
