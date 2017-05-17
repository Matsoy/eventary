package controler;

import java.util.Observable;

import model.Context;
import view.EventPanel;

public class EventControler implements java.util.Observer{
	
	/** The model. */
	Context model;
	
	/** The view. */
	EventPanel view;
	
	EventControler(EventPanel eventPanel, Context model){
		this.model = model;
		this.view = eventPanel;
		this.model.addObserver(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
