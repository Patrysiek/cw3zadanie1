package controllers.standard;

import button.ButtonType;
import button.CustomButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class StandardKeyboardController {

	@FXML
	private SplitPane standardKeyboardLayout;
	@FXML
	private GridPane buttonPane;
	private ToggleGroup toggleGroup;
	@FXML
	private RadioButton leftSide,rightSide;
	private StandardViewController standardViewController;

	public void injectMainViewController(StandardViewController standardViewController) {
		this.standardViewController = standardViewController;
	}

	@FXML
	private void initialize() {
		toggleGroup = new ToggleGroup();
		initButtons(buttonPane);
		initToggleButtons();

	}

	private void initToggleButtons() {
		leftSide.setToggleGroup(toggleGroup);
		rightSide.setToggleGroup(toggleGroup);
		toggleGroup.selectToggle(leftSide);
	}

	private void initButtons(Pane pane) {
		if (pane == null)
			return;

		for (Node n : pane.getChildren()) {
			if (!n.getClass().getName().equals(CustomButton.class.getName())) {
				continue;
			}

			CustomButton cb = (CustomButton) n;
			cb.setOnAction((ActionEvent event) -> onButtonClick(cb.getButtonType(), cb.getText()));
		}

	}

	private void onButtonClick(ButtonType buttonType, String text) {

		if (buttonType.equals(ButtonType.NUMERIC)) {			
			standardViewController.appendInputVariable(text,((RadioButton)toggleGroup.getSelectedToggle()).getText());
		}else {
			standardViewController.chooseFunction(buttonType, text,((RadioButton)toggleGroup.getSelectedToggle()).getText());
		}
	}

	public void changeToggle(String string) {

		if(string.equals(leftSide.getText()))
			toggleGroup.selectToggle(leftSide);
		else
			toggleGroup.selectToggle(rightSide);
		
	}

}
