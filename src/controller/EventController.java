/*
 * 
 */
package controller;

import java.util.Observable;

import model.Context;
import model.Event;
import view.EventPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class EventController.
 */
public class EventController implements java.util.Observer{
	
	/** The event. */
	Event event;
	
	/** The context. */
	Context context;
	
	/** The view. */
	EventPanel view;
	
	
	/**
	 * Instantiates a new event controller.
	 *
	 * @param eventPanel the event panel
	 * @param context the context
	 */
	EventController(EventPanel eventPanel, Context context){
		this.event = context.getCurrentEvent();
		this.context = context;
		this.view = eventPanel;
	}
	
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
