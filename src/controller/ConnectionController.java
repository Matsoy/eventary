/*
 * 
 */
package controller;

import java.util.Observable;

import javax.swing.SwingUtilities;

import database.EventDAO;
import model.Context;
import view.ConnectionPanel;
import view.Frame;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionControler.
 */
public class ConnectionController implements java.util.Observer{
	
	/** The model. */
	Context model;
	
	/** The view. */
	ConnectionPanel view;
	
	/** The action connection. */
	ActionConnection actionConnection;
	

	/**
	 * Instantiates a new connection controler.
	 *
	 * @param connectionPanel the connection panel
	 * @param model the model
	 */
	ConnectionController(ConnectionPanel connectionPanel, Context model){
		this.model = model;
		this.view = connectionPanel;
		this.model.addObserver(this);
		this.actionConnection = new ActionConnection(this.model, this.view);
		this.view.getBouton().setAction(this.actionConnection);
	}
	

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// si l'utilisateur est authentifié, on passe à la page d'accueil
		if(this.model.getAuthentificated()){
			view.getFrame().setHomePanel(EventDAO.findAll());
			this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getAllEventsPanel());
			this.view.getFrame().getAllEventsPanel().displayAllEvents(EventDAO.findAll());
			SwingUtilities.updateComponentTreeUI(this.view.getFrame());
		}
		
		// si il y a un mauvais login/mdp, on affaiche un message d'erreur
		else{
			view.getFrame().displayMessage("Connexion Failed : error in login or password",Frame.colorEventaryError);
		}
	}

}
