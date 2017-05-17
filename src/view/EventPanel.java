package view;

import java.awt.Color;

import javax.swing.JPanel;

public class EventPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	Frame frame;
	
	EventPanel(Frame frame){
		this.frame = frame;
	}
	
	public void displayMessage(String str, Color color) {
		this.frame.displayMessage(str, color);
	}
	
}
