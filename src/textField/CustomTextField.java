package textField;

import button.NumberSystemType;
import javafx.scene.control.TextField;

public class CustomTextField extends TextField{
	private NumberSystemType numberSystemType;
	
	
	public NumberSystemType getNumberSystemType() {
		return numberSystemType;
	}
	public void setNumberSystemType(NumberSystemType numberSystemType) {
		this.numberSystemType = numberSystemType;
	}
}
