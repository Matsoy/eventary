package controller;

import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.AbstractAction;

import model.Context;
import model.Event;
import model.Organization;
import model.Room;
import model.User;
import view.CreateEventPanel;

public class ActionCreateEventForm extends AbstractAction{
	CreateEventPanel view;
	Context model;
	
	ActionCreateEventForm(CreateEventPanel view, Context model){
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String eventName = this.view.getEventName();
		String description = this.view.getDescription();
		Date startDate = this.view.getStartDate();
		Date endDate = this.view.getEndDate();
		int maxParticipant = this.view.getMaxParticipant();
		User organizer = this.model.getCurrentUser();
		Organization organization = this.view.getOrganization();
		Room room = this.view.getRoom();
		String address = this.view.getAddress();
		if(Event.createEvent(eventName, description, startDate, endDate, maxParticipant, organizer, organization, room, address)){
			//Afficher l'accueil avec un message de création d'événement réussie
		}else{
			//Rester sur la même page avec un message d'erreur
		}
	}
	
	
	
}
