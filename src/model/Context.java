package model;

import database.*;
import java.io.File;

public class Context {
	User currentUser;
	boolean authentification;	//Sert à savoir si l'authentification à réussi
	int tempsAvantSuppression;
	
	public Context(){
		this.currentUser = null;
		this.authentification = false;
		this.tempsAvantSuppression = lireTempsAvantSupp();
	}
	
	public int getTempsAvantSuppression() {
		return tempsAvantSuppression;
	}

	public void setTempsAvantSuppression(int tempsAvantSuppression) {
		this.tempsAvantSuppression = tempsAvantSuppression;
	}

	public int lireTempsAvantSupp(){
		int temps = 0;
		File config = new File("../../config.txt");
		System.out.println("Chemin absolu du fichier : " + config.getAbsolutePath());
		
		return temps;
	}
	
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
	
	public static void main(String[] args) {	// Servira à tester la lecture dans le fichier de config
		
	}
	
}
