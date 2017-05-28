package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.OrganizationDAO;
import database.UserDAO;
import model.Association;
import model.Context;
import model.User;
import view.Frame;
import view.OrgaPanel;


// TODO: Auto-generated Javadoc
/**
 * The Class ActionAddMember.
 */
public class ActionAddMember extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	OrgaPanel view;

	/** The login. */
	String login;

	/**
	 * Instantiates a new action ajouter membre.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public ActionAddMember(Context model, OrgaPanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Valider Inscription");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action) {
		this.login = this.view.getLoginBox().getSelectedItem().toString().toUpperCase();
		if(UserDAO.find(this.login).getLogin() != null){	// Si login valide
			if(UserDAO.find(this.login).isInOrga(this.view.getOrganisation()) == false) {	// Si l'etu n'est pas dans l'asso
				try {
					// ajout du membre en BDD
					((Association)this.view.getOrganisation()).addMember(UserDAO.find(this.login));

					// rafraichissement de la page
					this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getOrgaPanel());              
					this.view.getFrame().getOrgaPanel().adaptOrga(OrganizationDAO.findAsso(this.view.getOrganisation().getId()), (List<User>)UserDAO.findAll());
					SwingUtilities.updateComponentTreeUI(this.view.getFrame());
				} catch(ClassCastException exc) {
					System.out.println(exc.getMessage());
				}
			} else {
				view.getFrame().displayMessage(this.login +" est déjà membre de l'organisation",Frame.colorEventaryError);
			}
		} else {
			view.getFrame().displayMessage("Login invalide",Frame.colorEventaryError);
		}
	}
}
