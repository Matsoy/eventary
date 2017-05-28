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
		this.context = context;
		this.view = view;
		this.putValue(Action.NAME, "S'inscrire");
	}
	

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//récupération de l'événement courant
		Event event = this.view.getEvent();
		
		this.view.removeAll();
		
		if(event.addParticipant(context.getCurrentUser())){	//si il reste de la place dans l'evenement
			this.view.getFrame().getEventPanel().adaptEvent(event, this.context);
			view.getFrame().displayMessage("Vous êtes maintenant inscrit à l'événément"+event.getTitle(), new Color(139,233,120));
		}else{	// Sinon, utilisateur en liste d'attente
			this.view.getFrame().getEventPanel().adaptEvent(event, this.context);
			view.getFrame().displayMessage("Vous êtes maintenant sur la liste d'attente à l'événément"+event.getTitle(), new Color(227,237,82));
		}
	}
}
