package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Context;
import view.HomePanel;


/**
 * The Class ActionQuit.
 */
public class ActionQuit extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;


	ActionQuit(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Quitter");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// reset de l'utilisateur courant
		this.model.setCurrentEvent(null);
		this.model.setAuthentificated(false);
		// retour au panel de connexion
		this.view.getFrame().setConnectionPanel();
	}

}
