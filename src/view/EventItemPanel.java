/*
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
		this.setLayout(null);
		
		int y = 5;
		
		JLabel titre = new JLabel(event.getTitle());
		titre.setFont(new Font("Bebas", Font.PLAIN, 40));
		titre.setBounds(5,y,800,y += 40);
		this.add(titre);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy - kk:mm", Locale.getDefault());
		JLabel startingDate = new JLabel(dateFormat.format(event.getStartDate()));
		startingDate.setBounds(5,y,800,y);
		this.add(startingDate);
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
