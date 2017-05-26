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
public class MyEventsPanel extends JPanel{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The frame. */
	Frame frame;
	
	
	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	MyEventsPanel(Frame frame){
		this.frame = frame;
	}


	/**
	 * Affiche la liste des evenements de l'utilisateur courant.
	 *
	 * @param participationsInAnEvent the participations in an event
	 * @param waitingsEvent the waitings event
	 */
	public void displayMyEvents(ArrayList<model.Event> participationsInAnEvent, ArrayList<model.Event> waitingsEvent){
		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0,5)));

		// mes participations
		JPanel ParticipationsPanel = new JPanel();
		ParticipationsPanel.setBackground(Frame.colorEventary);
		ParticipationsPanel.setMaximumSize(new Dimension(800,30));
		ParticipationsPanel.add(new JLabel("Mes participations"));
		this.add(ParticipationsPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// parcours de la liste des Event auxquels l'utilisateur participe
		for (model.Event event : participationsInAnEvent) {
			JPanel panelEvent = new EventItemPanel(this.frame, event);	
			panelEvent.addMouseListener(new DisplayEventListener());
			this.add(panelEvent);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
		
		// sur liste d'attente
		this.add(Box.createRigidArea(new Dimension(0,30)));
		JPanel waitingPanel = new JPanel();
		waitingPanel.setBackground(Frame.colorEventary);
		waitingPanel.setMaximumSize(new Dimension(800,30));
		waitingPanel.add(new JLabel("Sur liste d'attente"));
		this.add(waitingPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// parcours de la liste des Event auxquels l'utilisateur est sur liste d'attente
		for (model.Event event : waitingsEvent) {
			JPanel panelEvent = new EventItemPanel(this.frame, event);		
			panelEvent.addMouseListener(new DisplayEventListener());
			this.add(panelEvent);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
	}
}