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
 * The Class ActionSubscribeEvent.
 * Cette action va permettre l'inscription de l'utilisateur 
 * connecté à l'événement qu'il est en train de consulter,
 * lorsqu'il clic sur le bouton lié à cette action.
 * En plus de faire un appel au méthode du model pour l'inscription,
 * elle va aussi s'occuper de mettre la vue à jour selon si l'utilisateur
 * va en liste d'attente ou en liste principale.
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

		this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getEventPanel());

		if(event.addParticipant(context.getCurrentUser())){	//si il reste de la place dans l'evenement
			this.view.getFrame().getEventPanel().adaptEvent(event, this.context);
			view.getFrame().displayMessage("Vous êtes maintenant inscrit à l'événément "+event.getTitle(), new Color(139,233,120));
		}
		else {	// Sinon, utilisateur en liste d'attente
			this.view.getFrame().getEventPanel().adaptEvent(event, this.context);
			view.getFrame().displayMessage("Vous êtes maintenant sur la liste d'attente à l'événément "+event.getTitle(), new Color(227,237,82));
		}

		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}
}
