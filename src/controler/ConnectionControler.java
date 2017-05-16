package controler;

import java.util.Observable;

import java.awt.Color;

import model.Context;
import view.ConnectionPanel;
import view.Frame;

public class ConnectionControler implements java.util.Observer{
	Context model;
	ConnectionPanel view;
	ActionConnection actionConnection;
	
	ConnectionControler(ConnectionPanel connectionPanel){
		this.actionConnection = new ActionConnection(model, view, this);
		this.model = new model.Context();
		this.view = connectionPanel;
		this.view.getBouton().setAction(actionConnection);
		this.model.addObserver(this); //On observe le model pour que lorsque authentification est true on load setPanelHome();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(this.model.getAuthentificated()){
			view.setHomePanel();
		}else{
			view.displayMessage("Erreur de connexion", Color.RED);
		}
	}
	
}
