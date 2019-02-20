package controllers.programmer;

import button.ButtonType;
import button.NumberSystemType;
import javafx.fxml.FXML;

public class ProgrammerViewController {

	@FXML
	private ProgrammerKeyboardController programmerKeyboardLayoutController;
	@FXML
	private ProgrammerResultController programmerResultLayoutController;

	@FXML
	private void initialize() {
		programmerKeyboardLayoutController.injectProgrammerViewController(this);
	}

	public void appendToField(String text, NumberSystemType mode) {
			programmerResultLayoutController.appendToField(text,mode);

		}
	

	public void setFunction(String text, NumberSystemType mode, ButtonType type) {

		switch (type) {

		case EQUAL:
			calcualate(mode);
			break;
		case RESET:
			programmerResultLayoutController.resetAllFields();
			break;
		case BACKSPACE:
			programmerResultLayoutController.backspaceFromField(mode);
			break;
		case ZEROING:
			programmerResultLayoutController.zeroingField(mode);
		default:
			break;
		}

	}
	private void calcualate(NumberSystemType mode) {
		switch (mode) {
		case DEC:
			programmerResultLayoutController.calculateFromDec();
			break;
		case OCT:
			programmerResultLayoutController.calculateFromOct();
			break;
		case HEX:
			programmerResultLayoutController.calculateFromHex();
			break;
		case BIN:
			programmerResultLayoutController.calculateFromBin();
			break;
		default:
			break;
		}

	}



}
