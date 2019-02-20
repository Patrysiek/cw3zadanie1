package controllers;

import controllers.programmer.ProgrammerViewController;

public class StandardViewController {
	private ProgrammerViewController mainViewController;
	public void injectMainController(ProgrammerViewController mainViewController) {
		this.mainViewController = mainViewController;
	}


	
}
