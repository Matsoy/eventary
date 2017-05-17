package controller;

import java.util.Observable;
import model.Context;
import model.Event;
import view.EventPanel;

public class EventController implements java.util.Observer{
	
	/** The event. */
	Event event;
	
	/** The context. */
	Context context;
	
	/** The view. */
	EventPanel view;
	
	EventController(EventPanel eventPanel, Context context){
		this.event = context.getCurrentEvent();
		this.context = context;
		this.view = eventPanel;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
