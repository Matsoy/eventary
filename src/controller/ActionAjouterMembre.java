package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import database.UserDAO;
import model.Association;
import model.Context;
import view.OrgaPanel;

public class ActionAjouterMembre extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Context model;
	OrgaPanel view;
	String login;
	
	public ActionAjouterMembre(Context model, OrgaPanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Valider Inscription");
	}
	
	@Override
	public void actionPerformed(ActionEvent action) {
		this.login = this.view.getLoginBox().getSelectedItem().toString();
		if(UserDAO.find(this.login) != null){	// Si login valide
			if(UserDAO.find(this.login).isInAsso(this.view.getOrganisation()) == false) {	// Si l'etu n'est pas dans l'asso
				System.out.println("il est pas dedans : GG");
				try {
					((Association)this.view.getOrganisation()).addMember(UserDAO.find(this.login));
					
				} catch(ClassCastException exc) {
					System.out.println("Vous essayer d'ajouter un membre à un Département, c'est impossible");
				}
			} else {
				System.out.println("déjà dedans : retente");
			}
		} else {
			System.out.println("login invalide");
		}
	}
}
