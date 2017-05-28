package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Context;
import model.Event;
import view.EventPanel;

public class ActionRemoveEvent extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Context model;
	
	EventPanel view;
	
	public ActionRemoveEvent(Context model, EventPanel view) {
		this.model = model;
		this.view = view;
		this.putValue(Action.NAME, "Supprimer cet Evenement");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Event removedEvent = this.view.getEvent();
		//removedEvent.removeEvent(this.model.getCurrentUser());
		this.view.getFrame().displayMessage("L'Evenement "+removedEvent.getTitle()+" a bien ete supprime", new Color(139,233,120));
	}

}
