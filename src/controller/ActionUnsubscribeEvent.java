/*
 * 
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import model.Context;
import model.Event;
import view.EventPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionUnsubscribeEvent.
 * Cette action permet à l'utilisateur connecté de 
 * se désinscrire de l'événement qu'il est en train de 
 * consulter, lorsqu'il clic sur le bouton lié à cette action.
 * Elle va aussi mettre la vue à jour en conséquence.
 * 
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
		
		this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getEventPanel());
		
		if(event.removeParticipant(context.getCurrentUser())){
			this.view.getFrame().getEventPanel().adaptEvent(event, this.context);
			view.getFrame().displayMessage("Vous êtes maintenant désinscrit de l'événement "+event.getTitle(), new Color(139,233,120));
		}
		
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
