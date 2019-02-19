package controllers;

import button.ButtonType;
import button.CustomButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ProgrammerViewController {
	private MainViewController mainViewController;
	@FXML
	GridPane programmerViewLayout;

	public void injectMainController(MainViewController mainViewController) {
		this.mainViewController = mainViewController;
	}

	@FXML
	private void initialize() {
		initButtons(programmerViewLayout);
	}

	private void initButtons(Pane pane) {
		for (Node n : pane.getChildren()) {

			if (n.getClass().equals(CustomButton.class)) {
				CustomButton button = (CustomButton) n;
				button.setOnAction((ActionEvent event) -> buttonAction(button.getText(),button.getType()));
			}
		}
	}

	private void buttonAction(String text,ButtonType type) {
		
		if(type==null || text==null)
			return;
		
		if(type.equals(ButtonType.FUNCT))
			mainViewController.setFunction(text);
		else
			mainViewController.setScore(text);
	}

}
