package controllers.programmer;

import button.NumberSystemType;
import calculators.ProgrammerCalculator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import textField.CustomTextField;

public class ProgrammerResultController {

	private ProgrammerCalculator calculator;
	@FXML
	private SplitPane programmerResultLayout;
	@FXML
	private CustomTextField hexResult, decResult, binResult, octResult;

	@FXML
	private void initialize() {
		calculator = new ProgrammerCalculator();
	}

	public void appendToField(String text, NumberSystemType type) {
		for (Node n : programmerResultLayout.getItems()) {
			if (!n.getClass().getName().equals(AnchorPane.class.getName()))
				continue;

			for (Node x : ((AnchorPane) n).getChildren()) {
				if (!x.getClass().getName().equals(CustomTextField.class.getName()))
					continue;
				CustomTextField ctf = ((CustomTextField) x);
				if (!ctf.getNumberSystemType().equals(type))
					continue;
				ctf.setText(new StringBuilder(ctf.getText()).append(text).toString());
			}
		}
	}

	public void resetAllFields() {
		for (Node n : programmerResultLayout.getItems()) {
			if (!n.getClass().getName().equals(AnchorPane.class.getName()))
				continue;

			for (Node x : ((AnchorPane) n).getChildren()) {
				if (!x.getClass().getName().equals(CustomTextField.class.getName()))
					continue;
				((CustomTextField) x).setText("");
			}
		}
	}

	public void backspaceFromField(NumberSystemType type) {
		for (Node n : programmerResultLayout.getItems()) {
			if (!n.getClass().getName().equals(AnchorPane.class.getName()))
				continue;

			for (Node x : ((Pane) n).getChildren()) {

				if (!x.getClass().getName().equals(CustomTextField.class.getName()))
					continue;

				CustomTextField ctf = ((CustomTextField) x);
				if (!ctf.getNumberSystemType().equals(type))
					continue;

				String text = ctf.getText();
				if (text.length() <= 0)
					continue;

				ctf.setText(new StringBuilder(text).deleteCharAt(text.length() - 1).toString());
			}
		}
	}
	
	public void zeroingField(NumberSystemType type) {
		for (Node n : programmerResultLayout.getItems()) {
			if (!n.getClass().getName().equals(AnchorPane.class.getName()))
				continue;

			for (Node x : ((AnchorPane) n).getChildren()) {
				if (!x.getClass().getName().equals(CustomTextField.class.getName()))
					continue;
				CustomTextField ctf = ((CustomTextField) x);
				if (!ctf.getNumberSystemType().equals(type))
					continue;
				
				ctf.setText("");
			}
		}
	}

	public void calculateFromDec() {
		String result = decResult.getText();
		resetAllFields();
		decResult.setText(result);
		hexResult.setText(calculator.decToHex(Integer.parseInt(result)));
		binResult.setText(calculator.decToBin(Integer.parseInt(result)));
		octResult.setText(calculator.decToOct(Integer.parseInt(result)));
	}

	public void calculateFromBin() {
		String result = binResult.getText();
		resetAllFields();
		decResult.setText(calculator.binToDec(result));
		hexResult.setText(calculator.binToHex(result));
		binResult.setText(result);
		octResult.setText(calculator.binToOct(result));
	}

	public void calculateFromHex() {
		String result = hexResult.getText();
		resetAllFields();
		hexResult.setText(result);
		decResult.setText(calculator.hexToDec(result));
		binResult.setText(calculator.hexToBin(result));
		octResult.setText(calculator.hexToOct(result));
	}

	public void calculateFromOct() {
		String result = octResult.getText();
		resetAllFields();
		decResult.setText(calculator.octToDec(result));
		hexResult.setText(calculator.octToHex(result));
		binResult.setText(calculator.octToBin(result));
		octResult.setText(result);
	}



}
