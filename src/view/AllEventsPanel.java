/*
 * 
 */
package view;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DisplayEventListener;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 */
public class AllEventsPanel extends JPanel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;

	/** The frame. */
	Frame frame;

	
	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	AllEventsPanel(Frame frame){
		super();
		this.frame = frame;
	}


	/**
	 * Affiche la liste de tous les evenements.
	 *
	 * @param events the events
	 */
	public void displayAllEvents(ArrayList<model.Event> events){
		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0,5)));

		// mes participations
		JPanel eventsPanel = new JPanel();
		eventsPanel.setBackground(Frame.colorEventary);
		eventsPanel.setMaximumSize(new Dimension(800,30));
		eventsPanel.add(new JLabel("Les événements"));
		this.add(eventsPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// parcours de la liste des Event
		for (model.Event event : events) {
			JPanel panelEvent = new EventItemPanel(this.frame, event);	
			panelEvent.addMouseListener(new DisplayEventListener());
			this.add(panelEvent);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
	}
}