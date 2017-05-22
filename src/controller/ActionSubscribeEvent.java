/*
 * 
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Context;
import model.Event;
import view.EventPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionSubscribeEvent.
 */
public class ActionSubscribeEvent extends AbstractAction{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event. */
	Event event;

	/** The context. */
	Context context;

	/** The view. */
	EventPanel view;

	
	/**
	 * Instantiates a new action subscribe event.
	 *
	 * @param view the view
	 * @param context the context
	 */
	ActionSubscribeEvent(EventPanel view, Context context){
		this.event = context.getCurrentEvent();
		this.view = view;
		this.putValue(Action.NAME, "S'inscrire");
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//récupération de l'événement courant
		this.event = context.getCurrentEvent();
		
		//si il reste de la place dans l'evenement
		if(event.addParticipant(context.getCurrentUser())){
			view.getFrame().displayMessage("Vous êtes maintenant inscrit à l'événément", Color.GREEN);
		}
		
		// sinon, l'utilisateur est sur liste d'attente
		else{
			view.getFrame().displayMessage("Vous êtes maintenant sur la liste d'attente de l'événément", Color.YELLOW);
		}
	}

}
