/*
 * 
 */
package controller;

import java.util.Observable;
import java.util.Observer;

import model.Context;
import view.AgendaPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaController.
 */
public class AgendaController implements Observer{
	
	/** The model. */
	Context context;
	
	/** The view. */
	AgendaPanel agendaPanel;
	
	
	/**
	 * Instantiates a new agenda controller.
	 *
	 * @param agendaPanel the agenda panel
	 * @param context the context
	 */
	AgendaController(AgendaPanel agendaPanel, Context context){
		this.context = context;
		this.agendaPanel = agendaPanel;
	}
	

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
