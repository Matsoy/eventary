package model;

import database.*;
import java.io.*;

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
		String currentLine = "";	// ligne courante
		String S = "DurationBeforeDeletion";	// Chaine à retrouver pour avoir le temps
		int ctr = 0;	// Variable de controle

		try {     
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));	// Ouverture du fichier pour lecture
			//lecture du fichier texte 
			while (((currentLine = br.readLine()) != null) || ctr == 0){
				if (currentLine.startsWith(S)){   // on a la ligne qui indique le tempsAvantSuppression
					int index = currentLine.indexOf(":");
					temps = Integer.parseInt(currentLine.substring(index +2));
					System.out.println(temps);
					ctr++;
				}  
			}

			if(ctr == 0){
				System.out.println("ERROR : pas de ligne DurationBeforeDeletion");
			}
			br.close();	// On ferme le flux
		}
		catch (IOException e)
		{
			System.out.println(e.toString());
		}
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

//	public static void main(String[] args) {	// Servira à tester la lecture dans le fichier de config
//		Context context = new Context();
//	}
}
