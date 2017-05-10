package view;

import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;


public class ButtonDisconnection implements ActionListener {
	
	private Screen screen;
	boolean booleanConnexion;
	
	ButtonDisconnection(Screen screen){
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		this.screen.displayLogin(false);
	}
	
}
