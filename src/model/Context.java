package model;

import java.util.Observable;
import database.UserDAO;
import input_output.Reader;

/**
 * The Class Context.
 */
public class Context extends Observable{
	
	/** The current user. */
	User currentUser;
	
	/** The authentification. */
	boolean authentificated;	//Sert à savoir si l'authentification à réussi
	
	/** The temps avant suppression. */
	int tempsAvantSuppression;
	
	/**
	 * Instantiates a new context.
	 */
	public Context(){
		this.currentUser = null;
		this.authentificated = false;
		this.tempsAvantSuppression = Reader.readInteger("DurationBeforeDeletion");
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
	 * Connexion.
	 *
	 * @param login the login
	 * @param passwd the passwd
	 * @return true, if successful
	 */
	public boolean connexion(String login, String passwd){
		this.currentUser = UserDAO.connect(login, passwd);
		if(null == this.currentUser){	// Si les logs ne sont pas bon, on récupère un user null
			this.authentificated = false;
			return this.authentificated;
		}
		this.authentificated = true;
		return this.authentificated;
	}
	
//	public static void main(String[] args) {	// Servira à tester la lecture dans le fichier de config
//		Context context = new Context();
//	}
}
