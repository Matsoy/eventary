/*
 * 
 */
package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import database.UserDAO;
import model.Context;
import view.ConnectionPanel;


// TODO: Auto-generated Javadoc
/**
 * The Class ActionConnection.
 */
public class ActionConnection extends AbstractAction {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	Context model;
	
	/** The view. */
	ConnectionPanel view;
	
	
	/**
	 * Instantiates a new action connection.
	 *
	 * @param model the model
	 * @param view the view
	 */
	ActionConnection(Context model, ConnectionPanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Se connecter");
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.connexion(this.view.getLogin(), UserDAO.generateHash(this.view.getPassword()));
	}

}
