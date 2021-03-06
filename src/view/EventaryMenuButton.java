/*
 * 
 */
package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class EventaryButton.
 * 
 * JButton personnalisé pour les boutons de la sidebar de gauche
 */
public class EventaryMenuButton extends JButton{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Instantiates a new eventary button.
	 */
	EventaryMenuButton(){
		super();
		this.setBackground(new Color(225,225,225));
		this.setForeground(Color.BLACK);
		this.setFocusPainted(false);
		this.setFont(new Font("Arial", Font.BOLD, 15));
		this.setBorderPainted(false);
		//Enleve les bordures des boutons
		this.setRolloverEnabled(false);
	}
	
	
	/**
	 * Instantiates a new eventary button with a background color
	 *
	 * @param color the color
	 */
	EventaryMenuButton(Color color){
		super();
		this.setBackground(color);
		this.setForeground(Color.BLACK);
		this.setFocusPainted(false);
		this.setFont(new Font("Arial", Font.BOLD, 15));
		this.setBorderPainted(false);
		//Enleve les bordures des boutons
		this.setRolloverEnabled(false);
	}

}
