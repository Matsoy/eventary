package controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Context;
import view.HomePanel;

public class ActionClear extends AbstractAction implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Context model;
	HomePanel view;
	
	public ActionClear(Context model, HomePanel view){
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Supprimer Notifications");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Appeler le model pour qu'il remove les notifs
		model.getCurrentUser().removeNotifications();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		//Mettre à jour la vue --> effacer/pas de notifs
		view.getFrame().getNotifPanel().removeAll();
	}
}
