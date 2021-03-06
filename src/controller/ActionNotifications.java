/*
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.NotificationDAO;
import model.Context;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionNotifications.
 * Cette action va permettre d'afficher le panel
 * "Mes notifications", lorsque l'utilisateur connecté clic dessus.
 */
class ActionNotifications extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;
	
	/**
	 * Instantiates a new action notifications.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public ActionNotifications(Context model, HomePanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Notifications");
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.setContainerCentral(this.view.getFrame().getNotifPanel());
		this.view.getFrame().getNotifPanel().displayNotif(NotificationDAO.find(model.getCurrentUser().getLogin()));
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}
}
