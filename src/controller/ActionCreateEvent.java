package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import model.Context;
import view.HomePanel;

/**
 * The Class ActionCreateEvent.
 */
public class ActionCreateEvent extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;


	/**
	 * Instantiates a new action display my events.
	 *
	 * @param model the model
	 * @param view the view
	 */
	ActionCreateEvent(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Creer un evenement");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed de ActionCreateEvent");
		this.view.setContainerCentral(this.view.getFrame().getCreateEventPanel());
		this.view.getFrame().getCreateEventPanel().displayForm();
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
