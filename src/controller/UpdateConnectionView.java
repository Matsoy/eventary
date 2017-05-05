package controller;

import java.util.Observable;
import java.util.Observer;

public class UpdateConnectionView implements Observer{

	private view.Screen vi;
	
	public UpdateConnectionView(view.Screen vi){
		this.vi = vi;
	}
	
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
		//Afficher la barre rouge d'échec de connexion avec le texte
	}

}
