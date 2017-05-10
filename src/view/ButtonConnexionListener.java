package view;

import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;


public class ButtonConnexionListener implements ActionListener {
	
	private Screen screen;
	boolean booleanConnexion;
	
	ButtonConnexionListener(Screen screen){
		this.screen = screen;
		this.booleanConnexion = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Error connexion");
		if (booleanConnexion) {
			this.screen.getConnected();
		}else{
			this.screen.displayError("Connexion Failed : error in login or password ");
			booleanConnexion = true;
		}
	}
	
}
