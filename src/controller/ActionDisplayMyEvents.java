/*
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.ParticipationDAO;
import database.WaitingDAO;
import model.Context;
import view.HomePanel;


// TODO: Auto-generated Javadoc
/**
 * The Class ActionDisplayMyEvents.
 */
public class ActionDisplayMyEvents extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;


	/**
	 * Instantiates a new action display my events.
	 *
	 * @param model the model
	 * @param view the view
	 */
	ActionDisplayMyEvents(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Mes événements");
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.setContainerCentral(this.view.getFrame().getMyEventsPanel());
		this.view.getFrame().getMyEventsPanel().displayMyEvents(ParticipationDAO.participationsInAnEvent(model.getCurrentUser().getLogin()), WaitingDAO.waitingEvents(model.getCurrentUser().getLogin()));
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
