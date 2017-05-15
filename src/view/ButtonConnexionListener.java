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
		if (booleanConnexion) {
			this.screen.displayHome();
		}else{
			this.screen.displayMessage("Connexion Failed : error in login or password ",Screen.colorEventaryError);
			booleanConnexion = true;
		}
	}

}
