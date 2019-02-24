package controllers.standard;

import button.ButtonType;
import button.CustomButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
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
	private boolean isRightSide = false;

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
		leftSide.setOnMouseClicked((x)->changeToggle(false));
		rightSide.setToggleGroup(toggleGroup);
		rightSide.setOnMouseClicked((x)->changeToggle(true));
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
			standardViewController.appendInputVariable(text,isRightSide);
		}else {
			standardViewController.chooseFunction(buttonType, text,isRightSide);
		}
	}

	public void changeToggle(boolean isRightSide) {

		if(isRightSide) {
			toggleGroup.selectToggle(rightSide);
			this.isRightSide = true;
		}
		else {
			toggleGroup.selectToggle(leftSide);
			this.isRightSide = false;
		}
			
		
	}

}
