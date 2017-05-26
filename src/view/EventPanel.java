/*
 * 
 */
package view;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Event;

// TODO: Auto-generated Javadoc
/**
 * The Class DisplayEventPanel.
 */
public class EventPanel extends JPanel{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;

	/** The frame. */
	Frame frame;

	/** The event. */
	Event event;

	
	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	EventPanel(Frame frame){
		super();
		this.frame = frame;

		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(0,5)));

		// l'événement
		JPanel eventsPanel = new JPanel();
		eventsPanel.setBackground(Frame.colorEventary);
		eventsPanel.setMaximumSize(new Dimension(800,30));
		eventsPanel.add(new JLabel("Display event panel"));
		this.add(eventsPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));
	}
	
	/**
	 * Display event.
	 *
	 * @param event the event
	 */
	public void displayEvent(Event event){
		this.event = event;
	}

	
	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public Frame getFrame() {
		return frame;
	}	

}