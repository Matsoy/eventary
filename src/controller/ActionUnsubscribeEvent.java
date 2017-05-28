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
		this.view = view;
		this.context = context;
		this.putValue(Action.NAME, "Se désinscrire");
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// récupération de l'evenement courant
		Event event = this.view.getEvent();
		
		if(event.removeParticipant(context.getCurrentUser())){
			this.view.removeAll();
			this.view.getFrame().getEventPanel().adaptEvent(event, this.context);
			view.getFrame().displayMessage("Vous êtes maintenant désinscrit de l'événement "+event.getTitle(), new Color(139,233,120));
		}
	}

}
