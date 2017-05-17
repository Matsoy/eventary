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
		this.actionDisplayMyEvents = new ActionDisplayMyEvents(this.model, this.view);
		this.view.getMyEventsButton().setAction(this.actionDisplayMyEvents);
		this.actionQuit = new ActionQuit(this.model, this.view);
		this.view.getQuitButton().setAction(this.actionQuit);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

	}

}
