package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import model.Context;
import view.HomePanel;

public class ActionNotifications extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;
	
	public ActionNotifications(Context model, HomePanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Notifications");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("actionPerformed de ActionNotifications");
		this.view.setContainerCentral(this.view.getFrame().getNotifPanel());
		this.view.getFrame().getNotifPanel().displayNotif();
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
