/*
 * 
 */
package controller;

import java.util.Observable;

import model.Context;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class HomeControler.
 */
public class HomeController implements java.util.Observer{

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;

	/** The action display my events. */
	ActionDisplayMyEvents actionDisplayMyEvents;

	/** The action display all events. */
	ActionDisplayAllEvents actionDisplayAllEvents;

	/** The action create event. */
	ActionCreateEvent actionCreateEvent;

	/** The action notif. */
	ActionNotifications actionNotif;

	/** The action clear. */
	ActionClear actionClear;

	/** The action orga. */
	ActionOrganisations actionOrga;

	/** The action ajout membre. */
	ActionAddMember actionAjoutMembre;

	/** The action quit. */
	ActionQuit actionQuit;
	
	/** The action inscrire. */
	ActionSubscribeEvent actionInscrire;
	
	/** The action desinscrire. */
	ActionUnsubscribeEvent actionDesinscrire;
	
	/** The action suppression. */
	ActionRemoveEvent actionSuppression;


	/**
	 * Instantiates a new home controler.
	 *
	 * @param homePanel the home panel
	 * @param model the model
	 */
	HomeController(HomePanel homePanel, Context model){
		this.model = model;
		this.view = homePanel;
		this.model.addObserver(this);

		// clic Tous les evenements
		this.actionDisplayAllEvents = new ActionDisplayAllEvents(this.model, this.view);
		this.view.getAllEventsButton().setAction(this.actionDisplayAllEvents);

		// clic Mes evenements
		this.actionDisplayMyEvents = new ActionDisplayMyEvents(this.model, this.view);
		this.view.getMyEventsButton().setAction(this.actionDisplayMyEvents);

		// clic Creer un evenement
		this.actionCreateEvent = new ActionCreateEvent(this.model, this.view);
		this.view.getCreateEventButton().setAction(this.actionCreateEvent);

		// validation du formulaire de création d'un événement
		ActionCreateEventForm actionCreateEventForm = new ActionCreateEventForm(this.model, this.view.getFrame().getCreateEventPanel());
		this.view.getFrame().getCreateEventPanel().getCreateEventButton().setAction(actionCreateEventForm);

		// clic Notifications
		this.actionNotif = new ActionNotifications(this.model, this.view);
		this.view.getNotifButton().setAction(this.actionNotif);

		// clic Supprimer Notifications dans Notifications
		this.actionClear = new ActionClear(this.model, this.view);
		this.view.getFrame().getNotifPanel().getClearButton().setAction(actionClear);

		// clic Mes Organisations
		this.actionOrga = new ActionOrganisations(this.model, this.view);
		this.view.getOrgaButton().setAction(actionOrga);

		// clic Valider pour ajouter un membre dans une organisation
		this.actionAjoutMembre = new ActionAddMember(this.model, this.view.getFrame().getOrgaPanel());
		this.view.getFrame().getOrgaPanel().getValider().setAction(actionAjoutMembre);

		// clic s'inscrire
		ActionSubscribeEvent actionInscrire = new ActionSubscribeEvent(this.view.getFrame().getEventPanel(), this.model);
		this.view.getFrame().getEventPanel().getInscription().setAction(actionInscrire);

		// clic se desinscrire
		ActionUnsubscribeEvent actionDesinscrire = new ActionUnsubscribeEvent(this.view.getFrame().getEventPanel(), this.model);
		this.view.getFrame().getEventPanel().getDesinscription().setAction(actionDesinscrire);

		// clic supprimer cet Evenement
		ActionRemoveEvent actionSuppression = new ActionRemoveEvent(this.model, this.view.getFrame().getEventPanel());
		this.view.getFrame().getEventPanel().getSuppressionEvent().setAction(actionSuppression);

		// clic Quitter
		this.actionQuit = new ActionQuit(this.model, this.view);
		this.view.getQuitButton().setAction(this.actionQuit);
	}


	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
	}

}
