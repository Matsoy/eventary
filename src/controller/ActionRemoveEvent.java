package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.EventDAO;
import database.SiteDAO;
import model.Context;
import view.EventPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionRemoveEvent.
 * Cette action va entrainer l'annulation (et donc la
 * suppression) de l'événement consulté, lorsque l'utilisateur
 * connecté clic dessu le bouton lié à cette action.
 * Elle va donc entrainer une modification du model, et
 * une mise à jour de la vue (pour rediriger l'utilisateur sur la
 * page d'accueil).
 */
public class ActionRemoveEvent extends AbstractAction {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The model. */
	Context model;

	/** The view. */
	EventPanel view;

	/**
	 * Instantiates a new action remove event.
	 *
	 * @param model the model
	 * @param view the view
	 */
	public ActionRemoveEvent(Context model, EventPanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Supprimer cet Evenement");
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
System.out.println("view.getMessSupp().getText()"+view.getMessSupp().getText());
		this.view.getEvent().removeEvent(this.model.getCurrentUser(), view.getMessSupp().getText()); // supp de l'event
		this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getAllEventsPanel()); // retour page d'accueil avec la liste de tous les events
		this.view.getFrame().getAllEventsPanel().displayAllEvents(EventDAO.findAll(model.getTempsAvantSuppression()), this.model, SiteDAO.findAll());
		this.view.getFrame().displayMessage("L'Evenement "+this.view.getEvent().getTitle()+" a bien ete supprimé", new Color(139,233,120)); // message de confirmation de suppression
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}
}
