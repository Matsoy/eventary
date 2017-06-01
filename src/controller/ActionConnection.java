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
 * Cette action sert pour l'authentification de l'utilisateur.
 * Lorsque l'utilisateur clic sur le bouton lié à cette action,
 * cela va envoyer le login et le mot de passe haché au model
 * pour voir si l'authentification est valide ou non.
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
