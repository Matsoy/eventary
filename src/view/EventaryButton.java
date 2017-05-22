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
 */
public class EventaryButton extends JButton{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	
	/**
	 * Instantiates a new eventary button.
	 */
	EventaryButton(){
		super();
		this.setBackground(new Color(225,225,225));
		this.setForeground(Color.BLACK);
		this.setFocusPainted(false);
		this.setFont(new Font("Arial", Font.BOLD, 12));
		//this.setBorderPainted(false);
		//Enleve les bordures des boutons
		//this.setRolloverEnabled(false);
		//Enleve l'effet hoover
	}
	
	
	/**
	 * Instantiates a new eventary button.
	 *
	 * @param color the color
	 */
	EventaryButton(Color color){
		super();
		this.setBackground(color);
		this.setForeground(Color.BLACK);
		this.setFocusPainted(false);
		this.setFont(new Font("Arial", Font.BOLD, 12));
		//this.setBorderPainted(false);
		//Enleve les bordures des boutons
		//this.setRolloverEnabled(false);
		//Enleve l'effet hoover
	}

}
