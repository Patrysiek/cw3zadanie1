package controllers.programmer;

import button.NumberSystemType;
import button.CustomButtonDisabler;
import button.ButtonType;
import button.CustomButton;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ProgrammerKeyboardController {

	private ProgrammerViewController programmerViewController;
	private NumberSystemType mode;
	private ToggleGroup switchModeButtons;
	CustomButtonDisabler customButtonDisabler;

	@FXML
	GridPane programmerKeyboardLayout;
	@FXML
	HBox radioButtonBox;

	public void injectProgrammerViewController(ProgrammerViewController programmerViewController) {
		this.programmerViewController = programmerViewController;
	}

	@FXML
	private void initialize() {
		switchModeButtons = new ToggleGroup();
		customButtonDisabler = new CustomButtonDisabler();

		initButtons(programmerKeyboardLayout);
		initRadioButtons(radioButtonBox, switchModeButtons);

		mode = NumberSystemType.DEC;
		changeMode(mode.name());
	}

/////////////////KEYBOARD BUTTONS////////////////////////////////////////
	private void initButtons(Pane pane) {
		if (pane == null)
			return;

		for (Node n : pane.getChildren()) {

			if (n.getClass().equals(CustomButton.class)) {
				CustomButton button = (CustomButton) n;
				if(!(button.getNumberSystemType()==null))
					button.setButtonType(ButtonType.NUMERIC);
				
				
				button.setOnAction((ActionEvent event) -> buttonAction(button.getText(), mode,button.getButtonType()));
			}
		}
	}

	private void buttonAction(String text, NumberSystemType mode,ButtonType type) {

		if (mode == null || text == null || type == null)
			return;

		if(type.equals(ButtonType.NUMERIC))
			programmerViewController.appendToField(text,mode);
		else
			programmerViewController.setFunction(text, mode, type);
	}
	/////////////////////////////////////////////////////////////////////////////

	/////////////////// RADIO BUTTONS////////////////////////////////////////////
	private void initRadioButtons(HBox box, ToggleGroup tg) {
		setGroupToggleProperty(tg);
		addButtonsToToggleGroup(box, tg);
	}

	private void addButtonsToToggleGroup(Pane pane, ToggleGroup tg) {
		if (pane == null || tg == null)
			return;

		for (Node n : pane.getChildren()) {
			if (n.getClass().equals(RadioButton.class)) {
				RadioButton button = (RadioButton) n;
				button.setToggleGroup(tg);
			}
		}
	}

	private void setGroupToggleProperty(ToggleGroup tg) {
		tg.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue,
				Toggle newValue) -> changeMode((((RadioButton) tg.getSelectedToggle()).getText())));
	}

	private void changeMode(String string) {

		switch (string) {
		case "DEC":
			setMode(NumberSystemType.DEC);
			customButtonDisabler.disableButtons(programmerKeyboardLayout, true, NumberSystemType.HEX);
			break;
		case "BIN":
			setMode(NumberSystemType.BIN);
			customButtonDisabler.disableButtons(programmerKeyboardLayout, false, NumberSystemType.BIN);
			break;
		case "OCT":
			setMode(NumberSystemType.OCT);
			customButtonDisabler.disableButtons(programmerKeyboardLayout, true, NumberSystemType.HEX, NumberSystemType.DEC);
			break;
		case "HEX":
			setMode(NumberSystemType.HEX);
			customButtonDisabler.disableButtons(programmerKeyboardLayout, true, (NumberSystemType[]) null);
			break;
		default:
			System.out.println("cos zlego");
			break;
		}

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public void setMode(NumberSystemType mode) {
		this.mode = mode;
	}
}
