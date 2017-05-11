package model;

import database.*;
import java.io.File;

/**
 * The Class Context.
 */
public class Context {
	
	/** The current user. */
	User currentUser;
	
	/** The authentification. */
	boolean authentification;	//Sert à savoir si l'authentification à réussi
	
	/** The temps avant suppression. */
	int tempsAvantSuppression;
	
	/**
	 * Instantiates a new context.
	 */
	public Context(){
		this.currentUser = null;
		this.authentification = false;
		this.tempsAvantSuppression = lireTempsAvantSupp();
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
	public boolean getAuthentification() {
		return authentification;
	}



	/**
	 * Sets the authentification.
	 *
	 * @param authentification the new authentification
	 */
	public void setAuthentification(boolean authentification) {
		this.authentification = authentification;
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
	 * Lire temps avant supp.
	 *
	 * @return the int
	 */
	public int lireTempsAvantSupp(){
		int temps = 0;
		File config = new File("../../config.txt");
		System.out.println("Chemin absolu du fichier : " + config.getAbsolutePath());
		
		return temps;
	}
	
	/**
	 * Connexion.
	 *
	 * @param login the login
	 * @param passwd the passwd
	 * @return true, if successful
	 */
	public boolean connexion(String login, String passwd){
		UserDAO user = new UserDAO();
		this.currentUser = user.connect(login, passwd);
		if(null == this.currentUser){	// Si les logs ne sont pas bon, on récupère un user null
			this.authentification = false;
			return this.authentification;
		}
		this.authentification = true;
		return this.authentification;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {	// Servira à tester la lecture dans le fichier de config
		
	}
	
}
