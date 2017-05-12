package input_output;

import java.util.*;
import java.io.*;

public class Reader {

	public static int readInteger(String S){	// On passe la chaine à reconnaitre dans le fichier pour m'extraction de donnée
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

	public static ArrayList<String> readModo(){
		ArrayList<String> listeModo = new ArrayList<String>();
		String currentLine = "";	// ligne courante
		String S = "moderatorLogins";
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
						listeModo.add(str);
					}
				}
			}
			br.close();	// On ferme le flux
		} catch(IOException e){
			System.out.println(e.toString());
		}
		return listeModo;
	}

//	public static void main(String[] args) {	// Servira à tester la lecture dans le fichier de config
//		readModo();
//	}

}
