package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import model.Context;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionOrganisations.
 */
public class ActionOrganisations extends AbstractAction{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	Context model;
	
	/** The view. */
	HomePanel view;
	
	/**
	 * Instantiates a new action organisations.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public ActionOrganisations(Context model, HomePanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Mes Organisations");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.setContainerCentral(this.view.getFrame().getMyOrgaPanel());
		this.view.getFrame().getMyOrgaPanel().displayMyOrganisations(model.getCurrentUser().getListeAsso(), model.getCurrentUser().getListeDpt());
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
