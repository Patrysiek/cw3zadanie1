package controllers.standard;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StandardResultController {

	@FXML private TextField inputVariable;
	
	public void appendInputVariable(String text) {
		inputVariable.setText(new StringBuilder(inputVariable.getText()).append(text).toString());
	}

}
