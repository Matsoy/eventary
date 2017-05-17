package controller;

import java.util.Observable;

import database.EventDAO;
import model.Context;
import view.ConnectionPanel;
import view.Frame;

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
		// TODO Auto-generated method stub
		System.out.println("dans update de ConnectionControler");
		if(this.model.getAuthentificated()){
			// on passe à la page d'accueil
			view.setHomePanel(EventDAO.findAll());
			System.out.println("Connecté");
		}else{
			view.displayError("Connexion Failed : error in login or password",Frame.colorEventaryError);
			System.out.println("Pas connecté");
		}
	}

}
