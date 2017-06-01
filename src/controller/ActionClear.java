package controller;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.NotificationDAO;
import model.Context;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionClear.
 * Cette action sert pour supprimer les notifications
 * de l'uilisateur courant. 
 * Lorsque celui-ci clique sur le bouton lié à cette action,
 * cela va appeler la bonne méthode du model pour supprimer les
 * notifications de la BDD, et mettra ainsi la vue à jour.
 */
public class ActionClear extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The model. */
	Context model;
	
	/** The view. */
	HomePanel view;
	
	/**
	 * Instantiates a new action clear.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public ActionClear(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Supprimer Notifications");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Appeler le model pour qu'il remove les notifs
		model.getCurrentUser().removeNotifications();
		this.view.setContainerCentral(this.view.getFrame().getNotifPanel());
		this.view.getFrame().getNotifPanel().displayNotif(NotificationDAO.find(model.getCurrentUser().getLogin()));
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}
}
