package controllers.standard;

import button.ButtonType;
import button.CustomButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class StandardKeyboardController {
	
	
	private ButtonType mode;
	@FXML private GridPane standardKeyboardLayout;
	
	private StandardViewController standardViewController;
	public void injectMainViewController(StandardViewController standardViewController) {
		this.standardViewController = standardViewController;

	}
	@FXML private void initialize() {
		initButtons(standardKeyboardLayout);

	}
	
	private void initButtons(Pane pane) {
		if(pane==null)
		return;
		
		for(Node n : pane.getChildren()) {
			if(!n.getClass().getName().equals(CustomButton.class.getName())) {
				continue;
			}
				
			CustomButton cb = (CustomButton)n;
			cb.setOnAction((ActionEvent event)->onButtonClick(cb.getButtonType(),cb.getText()));
		}
			
		
	}
	private void onButtonClick(ButtonType buttonType, String text) {
		
		if(buttonType.equals(ButtonType.NUMERIC)) {
			standardViewController.appendInputVariable(text);
		}
		else 
			standardViewController.chooseFunction(buttonType,text);
	}

}
