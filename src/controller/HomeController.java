package controller;

import java.util.Observable;

import model.Context;
import view.HomePanel;

/**
 * The Class HomeControler.
 */
public class HomeController implements java.util.Observer{

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;
	
	ActionDisplayMyEvents actionDisplayMyEvents;
	ActionDisplayAllEvents actionDisplayAllEvents;
	ActionCreateEvent actionCreateEvent;
	ActionQuit actionQuit;

	/**
	 * Instantiates a new home controler.
	 *
	 * @param homePanel the home panel
	 * @param model the model
	 */
	HomeController(HomePanel homePanel, Context model){
		this.model = model;
		this.view = homePanel;
		this.model.addObserver(this);
		
		// clic Tous les evenements
		this.actionDisplayAllEvents = new ActionDisplayAllEvents(this.model, this.view);
		this.view.getAllEventsButton().setAction(this.actionDisplayAllEvents);

		// clic Mes evenements
		this.actionDisplayMyEvents = new ActionDisplayMyEvents(this.model, this.view);
		this.view.getMyEventsButton().setAction(this.actionDisplayMyEvents);
		
		// clic Creer un evenement
		this.actionCreateEvent = new ActionCreateEvent(this.model, this.view);
		this.view.getCreateEventButton().setAction(this.actionCreateEvent);
		
		// clic Quitter
		this.actionQuit = new ActionQuit(this.model, this.view);
		this.view.getQuitButton().setAction(this.actionQuit);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("dans update de HomeController");
	}

}
