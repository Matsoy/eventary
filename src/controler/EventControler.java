package controler;

import java.util.Observable;
import model.Context;
import model.Event;
import view.EventPanel;

public class EventControler implements java.util.Observer{
	
	/** The event. */
	Event event;
	
	/** The context. */
	Context context;
	
	/** The view. */
	EventPanel view;
	
	EventControler(EventPanel eventPanel, Event event, Context context){
		this.event = event;
		this.context = context;
		this.view = eventPanel;
		this.event.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
