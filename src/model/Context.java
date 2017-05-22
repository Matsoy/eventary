/*
 * 
 */
package model;

import java.util.Observable;

import database.EventDAO;
import database.UserDAO;
import input_output.Reader;

// TODO: Auto-generated Javadoc
/**
 * The Class Context.
 */
public class Context extends Observable{

	/** The current user. */
	User currentUser;

	/** The authentification. */
	boolean authentificated;	//Sert � savoir si l'authentification � r�ussi

	/** The temps avant suppression. */
	int tempsAvantSuppression;
	
	/** The current event. */
	Event currentEvent;
	
	/**
	 * Instantiates a new context.
	 */
	public Context(){
		this.currentUser = null;
		this.authentificated = false;
		this.tempsAvantSuppression = Reader.readInteger("DurationBeforeDeletion");
		this.currentEvent = null;
	}

	/**
	 * Gets the current user.
	 *
	 * @return the current user
	 */
	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Sets the current user.
	 *
	 * @param currentUser the new current user
	 */
	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Checks if is authentification.
	 *
	 * @return true, if is authentificated
	 */
	public boolean getAuthentificated() {
		return authentificated;
	}

	/**
	 * Sets the authentification.
	 *
	 * @param authentification the new authentification
	 */
	public void setAuthentificated(boolean authentification) {
		this.authentificated = authentification;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Gets the temps avant suppression.
	 *
	 * @return the temps avant suppression
	 */
	public int getTempsAvantSuppression() {
		return tempsAvantSuppression;
	}

	/**
	 * Sets the temps avant suppression.
	 *
	 * @param tempsAvantSuppression the new temps avant suppression
	 */
	public void setTempsAvantSuppression(int tempsAvantSuppression) {
		this.tempsAvantSuppression = tempsAvantSuppression;
	}
	
	/**
	 * Gets the current event.
	 *
	 * @return the current event
	 */
	public Event getCurrentEvent() {
		return currentEvent;
	}

	/**
	 * Sets the current event.
	 *
	 * @param currentEvent the new current event
	 */
	public void setCurrentEvent(Event currentEvent) {
		this.currentEvent = currentEvent;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Connexion.
	 *
	 * @param login the login
	 * @param passwd the passwd
	 * @return true, if successful
	 */
	public void connexion(String login, String passwd){
		setCurrentUser(UserDAO.connect(login, passwd));
		if(null == this.currentUser){	// Si les logs ne sont pas bon, on r�cup�re un user null
			setAuthentificated(false);
		}else{
			setAuthentificated(true);
		}
	}
	
	/**
	 * Display event.
	 *
	 * @param eventId the event id
	 */
	public void displayEvent(int eventId){
		setCurrentEvent(EventDAO.find(eventId));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Context [currentUser=" + currentUser + ", authentificated=" + authentificated
				+ ", tempsAvantSuppression=" + tempsAvantSuppression + "]";
	}
	
	
}
