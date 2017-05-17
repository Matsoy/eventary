package controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import database.EventDAO;
import model.Context;
import view.HomePanel;


/**
 * The Class ActionDisplayMyEvents.
 */
public class ActionDisplayMyEvents extends AbstractAction {

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
	ActionDisplayMyEvents(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Mes événements");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.displayEvents(EventDAO.findAll());
	}

}
