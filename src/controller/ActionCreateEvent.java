/*
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.SchoolDAO;
import model.Association;
import model.Context;
import model.Department;
import model.School;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionCreateEvent.
 * Cette action sert à afficher le formulaire de création
 * d'un événement. 
 * Lorsque l'utilisateur clic sur le bouton lié à cette action,
 * cela affichera le formulaire de création d'un événement, tout en
 * tenant compte de l'utilisateur connecté.
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
		this.putValue(Action.NAME, "Créer un événement");
	}

	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.setContainerCentral(this.view.getFrame().getCreateEventPanel());
		this.view.getFrame().getCreateEventPanel().displayForm((ArrayList<Association>)model.getCurrentUser().getListeAsso(), (ArrayList<Department>)model.getCurrentUser().getListeDpt(), (ArrayList<School>)SchoolDAO.findAll());
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}

}
