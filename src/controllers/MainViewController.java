package controllers;

import calculators.ProgrammerCalculator;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;


public class MainViewController {


	private ProgrammerCalculator calculator;
	@FXML private ProgrammerViewController programmerViewLayoutController;
	@FXML private StandardViewController standardViewLayoutController;
	@FXML private TextArea textEquation;
	@FXML private TextArea textScore;

	
	@FXML private void initialize() {
		programmerViewLayoutController.injectMainController(this);
		standardViewLayoutController.injectMainController(this);

		
	}
	
	public void setScore(String text) {
		textScore.setText(new StringBuilder(textScore.getText()).append(text).toString());
	}
	
	public void setFunction(String text) {
		
		switch(text) {
		case"=":
			
			break;
		case "RESET":
			
			break;
		case "ZEROWANIE":
			
			break;		
		
		}
		
		
		textEquation.setText(new StringBuilder(textEquation.getText()).append(textScore.getText()).toString());
		textScore.setText("");
	}
}
