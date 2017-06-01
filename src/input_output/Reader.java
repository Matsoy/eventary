/*
 * 
 */
package input_output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Reader.
 * Cette classe va contenir des méthodes pour aller lire
 * des informations dans le fichier congit.txt
 * 
 */
public class Reader {

	/**
	 * Retourne l'entier correspondant à la chaîne à reconnaître
	 *
	 * @param S le nom de la chaîne à reconnaître
	 * @return l'entier
	 */
	public static int readInteger(String S){	//On passe la chaine à reconnaitre dans le fichier pour m'extraction de données
		int entier = 0;
		String currentLine = "";	// ligne courante
		int ctr = 0;	// Variable de controle
		int index = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));	// Ouverture du fichier pour lecture
			//lecture du fichier texte 
			while (((currentLine = br.readLine()) != null) && ctr == 0){
				if (currentLine.startsWith(S)){   // on a la ligne qui indique le tempsAvantSuppression
					// On supprime les caractères blancs qui sont sur la ligne
					currentLine = currentLine.replaceAll("\\s", "");
					index = (currentLine.indexOf(":")+1);
					entier = Integer.parseInt(currentLine.substring(index));
					ctr++;
				}
			}
			if(ctr == 0){
				System.out.println("ERROR : pas de ligne qui qui commence par " + S);
			}
			br.close();	// On ferme le flux
		} catch (IOException e){
			System.out.println(e.toString());
		}
		return entier;
	}

	/**
	 * retourne la liste de String correspondant à la chaîne à reconnaître
	 *
	 * @param S le nom de la chaîne à reconnaître
	 * @return la liste de String
	 */
	public static ArrayList<String> readLogs(String S){
		ArrayList<String> listeUsers = new ArrayList<String>();
		String currentLine = "";	// ligne courante
		String[] splitLine;
		int index = 0;
		int ctr = 0; // Variable de controle

		try {
			BufferedReader br = new BufferedReader(new FileReader("config.txt"));	// Ouverture du fichier pour lecture
			//lecture du fichier texte 
			while (((currentLine = br.readLine()) != null) && ctr == 0){
				if (currentLine.startsWith(S)){   // on a la ligne qui indique le tempsAvantSuppression
					// On supprime les caractères blancs qui sont sur la ligne
					currentLine = currentLine.replaceAll("\\s", "");
					index = (currentLine.indexOf(":")+1);
					currentLine = currentLine.substring(index);
					splitLine = currentLine.split(",");
					for(String str : splitLine){
						listeUsers.add(str);
					}
				}
			}
			br.close();	// On ferme le flux
		} catch(IOException e){
			System.out.println(e.toString());
		}
		return listeUsers;
	}
}
