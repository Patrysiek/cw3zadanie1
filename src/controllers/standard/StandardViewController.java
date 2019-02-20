package controllers.standard;

import button.ButtonType;
import javafx.fxml.FXML;

public class StandardViewController {
	@FXML
	private StandardKeyboardController standardKeyboardLayoutController;
	@FXML
	private StandardResultController standardResultLayoutController;

	@FXML private void initialize() {
		standardKeyboardLayoutController.injectMainViewController(this);
	}

	public void chooseFunction(ButtonType buttonType, String text) {
		// TODO Auto-generated method stub
		
	}

	public void appendInputVariable(String text) {
		standardResultLayoutController.appendInputVariable(text);
	}


	
	

}
