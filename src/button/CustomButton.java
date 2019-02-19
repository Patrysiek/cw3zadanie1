package button;

import javafx.scene.control.Button;

public class CustomButton extends Button{
	
	private ButtonType type;
	
	public void setType(ButtonType type) {
		this.type = type;
	}
	public ButtonType getType() {
		return type;
	}

}
