package button;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class CustomButtonDisabler {

	public void disableButtons(Pane pane, boolean disable, NumberSystemType... types) {
		if (pane == null)
			return;

		for (Node n : pane.getChildren()) {
			if (!n.getClass().equals(CustomButton.class))
				continue;

			CustomButton button = (CustomButton) n;
			if(!button.getButtonType().equals(ButtonType.NUMERIC))
				continue;
			button.setDisable(!disable);
			
			if (types == null)
				continue;

			for (NumberSystemType t : types) {
				if (button.getNumberSystemType().equals(t)) {
					button.setDisable(disable);
					break;
				}
			}

		}
	}
}
