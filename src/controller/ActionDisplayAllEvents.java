/*
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.EventDAO;
import database.SiteDAO;
import model.Context;
import view.HomePanel;


// TODO: Auto-generated Javadoc
/**
 * The Class ActionDisplayMyEvents.
 * Cette action va permettre d'afficher le panel 
 * "Tous les événements", lorsque l'utilisateut 
 * connecté clic dessus le bouton lié à cette action.
 */
public class ActionDisplayAllEvents extends AbstractAction {

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
	ActionDisplayAllEvents(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Tous les événements");
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.setContainerCentral(this.view.getFrame().getAllEventsPanel());
		this.view.getFrame().getAllEventsPanel().displayAllEvents(EventDAO.findAll(model.getTempsAvantSuppression()), this.model, SiteDAO.findAll());
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
