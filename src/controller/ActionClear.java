package controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingUtilities;

import database.NotificationDAO;
import model.Context;
import view.HomePanel;

public class ActionClear extends AbstractAction {

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
		//this.model.getCurrentUser().addObserver(this);;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Appeler le model pour qu'il remove les notifs
		model.getCurrentUser().removeNotifications();
		this.view.setContainerCentral(this.view.getFrame().getNotifPanel());
		this.view.getFrame().getNotifPanel().displayNotif(NotificationDAO.find(model.getCurrentUser().getLogin()));
		SwingUtilities.updateComponentTreeUI(this.view.getFrame());
	}
}
