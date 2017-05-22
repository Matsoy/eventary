/*
 * 
 */
package view;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Event;

// TODO: Auto-generated Javadoc
/**
 * The Class EventItemPanel.
 */
public class EventItemPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The event. */
	Event event;
	
	/** The frame. */
	Frame frame;
	
	
	/**
	 * Instantiates a new event item panel.
	 *
	 * @param frame the frame
	 * @param event the event
	 */
	public EventItemPanel(Frame frame, Event event){
		super();
		this.frame = frame;
		this.event = event;
		this.setPreferredSize(new Dimension(800,160));
		this.add(new JLabel(event.getTitle()));
		this.add(new JLabel(event.getStartDate().toString()));
	}

	
	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	public Event getEvent() {
		return event;
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
