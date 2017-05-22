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
 * The Class ActionUnsubscribeEvent.
 */
public class ActionUnsubscribeEvent extends AbstractAction{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The event. */
	Event event;
	
	/** The context. */
	Context context;
	
	/** The view. */
	EventPanel view;
	
	
	/**
	 * Instantiates a new action unsubscribe event.
	 *
	 * @param view the view
	 * @param context the context
	 */
	ActionUnsubscribeEvent(EventPanel view, Context context){
		this.event = context.getCurrentEvent();
		this.view = view;
		this.putValue(Action.NAME, "Se désinscrire");
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// récupération de l'evenement courant
		this.event = context.getCurrentEvent();
		
		// si l'utilisateur est supprimé de la liste principale
		if(event.removeParticipant(context.getCurrentUser())){
			view.getFrame().displayMessage("Vous êtes maintenant désinscrit de l'evenement", Color.GREEN);
		}
		
		// sinon, il est supprimé de la liste d'attente
		else{
			view.getFrame().displayMessage("Vous n'êtes plus sur la liste d'attente de l'evenement", Color.YELLOW);
		}
	}

}
