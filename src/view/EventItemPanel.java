/*
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JButton;
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
		
		String stringEventTitle = event.getTitle();
		JLabel titre = new JLabel(stringEventTitle);
		
		
		if (stringEventTitle.length()<=45){
			titre.setFont(new Font("Impact", Font.PLAIN, 40));
		} else {
			titre.setFont(new Font("Impact", Font.PLAIN, 30));
		}
		titre.setBounds(5,y,800,y += 40);
		this.add(titre);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy - kk:mm", Locale.getDefault());
		JLabel startingDate = new JLabel(dateFormat.format(event.getStartDate()));
		startingDate.setBounds(5,y,800,y);
		this.add(startingDate);
		
		EventaryButton participateButton = new EventaryButton("Participer");
		participateButton.setBounds(5,145,100,20);
		this.add(participateButton);
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
