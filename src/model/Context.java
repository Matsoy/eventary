package model;

import database.*;
import java.io.*;

/**
 * The Class Context.
 */
public class Context {
	
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
		this.tempsAvantSuppression = lireEntier("DurationBeforeDeletion");
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
	 * Lire temps avant supp.
	 *
	 * @return the int
	 */
	public int lireEntier(String S){	// On passe la chaine à reconnaitre dans le fichier pour m'extraction de donnée
		int entier = 0;
		String currentLine = "";	// ligne courante
		int ctr = 0;	// Variable de controle

		try {     
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));	// Ouverture du fichier pour lecture
			//lecture du fichier texte 
			while (((currentLine = br.readLine()) != null) || ctr == 0){
				if (currentLine.startsWith(S)){   // on a la ligne qui indique le tempsAvantSuppression
					int index = (currentLine.indexOf(":")+1);
					// On supprime les caractères blancs entre les ":" et l'entier à lire 
					currentLine = currentLine.replaceAll("\\s", "");
					entier = Integer.parseInt(currentLine.substring(index));
					System.out.println(entier);
					ctr++;
				}  
			}
			if(ctr == 0){
				System.out.println("ERROR : pas de ligne DurationBeforeDeletion");
			}
			br.close();	// On ferme le flux
		} catch (IOException e){
			System.out.println(e.toString());
	
		}
		return entier;
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
			this.authentificated = false;
			return this.authentificated;
		}
		this.authentificated = true;
		return this.authentificated;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {	// Servira à tester la lecture dans le fichier de config
		Context context = new Context();
	}
	
}
