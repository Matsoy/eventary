package view;

import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;


public class ButtonConnexionListener implements ActionListener {
	
	private Screen screen;
	
	ButtonConnexionListener(Screen screen){
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Connexion");
		this.screen.getConnected();
	}
	
}
