/*
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import model.Context;
import view.EventPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionDisplayEvent.
 */
public class ActionDisplayEvent extends AbstractAction{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	Context model;
	
	EventPanel view;

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Event.getEvent(e.id); //En gros on récupére l'ID de l'event et on le récupére
		//Le mieux serait de récupérer directment 
		//model.setCurrentEvent(currentEvent);
	}

}
