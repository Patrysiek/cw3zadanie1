package controllers.standard;

import button.ButtonType;
import calculators.StandardCalculator;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StandardResultController {

	private StandardCalculator calculator;
	private StandardViewController standardViewController;
	private ButtonType operationType = null;
	private boolean rightSide = false;

	@FXML
	private TextField var1, var2, result, operation;

	@FXML
	private void initialize() {
		calculator = new StandardCalculator();
		var1.setOnMouseClicked((x) -> {
			rightSide = false;
			standardViewController.changeToggle(rightSide);
		});
		var2.setOnMouseClicked((x) -> {
			rightSide = true;
			standardViewController.changeToggle(rightSide);
		});
	}

	public void setSide(boolean rightSide) {
		if (rightSide) {
			this.rightSide = true;
		} else {

			this.rightSide = false;
		}

	}

	public void appendText(String s) {
		if (rightSide) {
			var2.appendText(s);
		} else {
			var1.appendText(s);
		}
	}

	public void setFunction(ButtonType buttonType, String text) {

		
		switch (buttonType) {
		case EQUAL:
			result.setText(chooseFunction());
			break;
		case BACKSPACE:
			backspaceInput();
			break;
		case ZEROING:
			result.setText("");
			break;
		case PI:
			if (rightSide)
				var2.setText(String.valueOf(Math.PI));
			else
				var1.setText(String.valueOf(Math.PI));
			break;
		case RESET:
			var1.setText("");
			var2.setText("");
			result.setText("");
			break;
		default:
			operationType = buttonType;
			operation.setText(text);
			break;
		}

	}

	private void backspaceInput() {
		if (rightSide) {
			if (var2.getLength() > 0)
				var2.setText(var2.getText().substring(0, var2.getLength() - 1));
		} else {
			if (var1.getLength() > 0)
				var1.setText(var1.getText().substring(0, var1.getLength() - 1));
		}

	}

	private String chooseFunction() {
		if (operationType == null)
			return "";

		switch (operationType) {
		case ADD:
			if (validateLeft() && validateRight())
				return calculator.adding(Float.parseFloat(var1.getText()), Float.parseFloat(var2.getText()));
		case SUBSTRACT:
			if (validateLeft() && validateRight())
				return calculator.substraction(Float.parseFloat(var1.getText()), Float.parseFloat(var2.getText()));
		case MULTIPLY:
			if (validateLeft() && validateRight())
				return calculator.multiplying(Float.parseFloat(var1.getText()), Float.parseFloat(var2.getText()));
		case MODULO:
			if (validateLeft() && validateRight())
				return calculator.modulo(Float.parseFloat(var1.getText()), Float.parseFloat(var2.getText()));
		case DIVIDE:
			if (validateLeft() && validateRight())
				return calculator.division(Float.parseFloat(var1.getText()), Float.parseFloat(var2.getText()));

		case POWER:
			if (validateLeft() && validateRight())
				return calculator.power(Float.parseFloat(var1.getText()), Float.parseFloat(var2.getText()));
		case FACTORIAL:
			if (rightSide) {
				if (validateRight())
					return calculator.factorial(var2.getText());
			} else if (validateLeft())
				return calculator.factorial(var1.getText());

		case SQRT:
			if (rightSide) {
				if (validateRight())
					return calculator.sqrt(var2.getText());
			} else if (validateLeft())
				return calculator.sqrt(var1.getText());
		case LOGARITHM:
			if (rightSide) {
				if (validateRight())
					return calculator.logarithm(var2.getText());
			} else if (validateLeft())
				return calculator.logarithm(var1.getText());

		default:
			return "";

		}

	}

	private boolean validateLeft() {
		if (var1.getText().isEmpty())
			return false;

		if (!var1.getText().matches("^[+-]?([0-9]*[.])?[0-9]+$"))
			return false;

		return true;

	}

	private boolean validateRight() {
		if (var2.getText().isEmpty())
			return false;

		if (!var2.getText().matches("^[+-]?([0-9]*[.])?[0-9]+$"))
			return false;

		return true;

	}

	public void injectMainViewController(StandardViewController standardViewController) {
		this.standardViewController = standardViewController;

	}


}
