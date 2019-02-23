package button;

import javafx.scene.control.Button;

public class CustomButton extends Button{
	
	private NumberSystemType numberSystemType;
	private ButtonType buttonType;
	
	
	
	public CustomButton() {
		numberSystemType = null;
		buttonType = null;
	}
	public void setNumberSystemType(NumberSystemType numberSystemType) {
		this.numberSystemType = numberSystemType;
	}
	public NumberSystemType getNumberSystemType() {
		return numberSystemType;
	}
	public ButtonType getButtonType() {
		return buttonType;
	}
	public void setButtonType(ButtonType buttonType) {
		this.buttonType = buttonType;
	}


}
