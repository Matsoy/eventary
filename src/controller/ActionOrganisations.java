package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import model.Context;
import view.HomePanel;

public class ActionOrganisations extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Context model;
	
	HomePanel view;
	
	public ActionOrganisations(Context model, HomePanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Mes Organisations");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.view.setContainerCentral(this.view.getFrame().getOrgaPanel());
		this.view.getFrame().getOrgaPanel().displayOrganisations(model.getCurrentUser().getListeAsso(), model.getCurrentUser().getListeDpt());
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
