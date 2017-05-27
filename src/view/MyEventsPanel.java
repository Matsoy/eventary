/*
 * 
 */
package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.DisplayEventListener;
import database.EventDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 */
public class MyEventsPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The frame. */
	Frame frame;

	/** The filter box. */
	JComboBox<String> filterBox;

	/** The filter box model. */
	DefaultComboBoxModel<String> filterBoxModel;


	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	MyEventsPanel(Frame frame){
		super();
		this.frame = frame;
	}


	/**
	 * Affiche la liste des evenements de l'utilisateur courant.
	 *
	 * @param participationsInAnEvent the participations in an event
	 * @param waitingsEvent the waitings event
	 * @param sites the sites
	 */
	public void displayMyEvents(ArrayList<model.Event> participationsInAnEvent, ArrayList<model.Event> waitingsEvent, ArrayList<model.Site> sites){
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

		// bouton de filtre
		this.filterBox = new EventaryComboBox<String>();
		this.filterBoxModel = new DefaultComboBoxModel<String>();
		this.filterBoxModel.addElement("< Filtrer par site >");
		for (int i = 0; i < sites.size(); i++) {
			filterBoxModel.addElement(sites.get(i).getName());
		}
		filterBox.setModel(filterBoxModel);
		ParticipationsPanel.add(filterBox);

		// quand sélection d'un site
		filterBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (filterBox.getSelectedIndex() > 0)) {
					// on supprime les evenement affichés
					int compIndex = 0;
					for (Component comp : frame.getMyEventsPanel().getComponents()) {
						if (compIndex >= 3) {
							frame.getMyEventsPanel().remove(comp);
						}
						compIndex++;
					}

					// parcours de la liste des participations
					for (model.Event event : participationsInAnEvent) {
						if(EventDAO.isInSite(event, sites.get(filterBox.getSelectedIndex()-1).getId())){
							JPanel panelEvent = new EventItemPanel(frame, event);	
							panelEvent.addMouseListener(new DisplayEventListener());
							frame.getMyEventsPanel().add(panelEvent);
							frame.getMyEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));
						}
					}

					// sur liste d'attente
					add(Box.createRigidArea(new Dimension(0,30)));
					JPanel waitingPanel = new JPanel();
					waitingPanel.setBackground(Frame.colorEventary);
					waitingPanel.setMaximumSize(new Dimension(800,30));
					waitingPanel.add(new JLabel("Sur liste d'attente"));
					add(waitingPanel);
					add(Box.createRigidArea(new Dimension(0,10)));

					// parcours de la liste des attentes
					for (model.Event event : waitingsEvent) {
						if(EventDAO.isInSite(event, sites.get(filterBox.getSelectedIndex()-1).getId())){
							JPanel panelEvent = new EventItemPanel(frame, event);	
							panelEvent.addMouseListener(new DisplayEventListener());
							frame.getMyEventsPanel().add(panelEvent);
							frame.getMyEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));
						}
					}
				}
				else if ((e.getStateChange() == ItemEvent.SELECTED) && (filterBox.getSelectedIndex() == 0)) { //si pas de filtre par site, alors on affiche tous les événements
					// on supprime les evenement affichés
					int compIndex = 0;
					for (Component comp : frame.getMyEventsPanel().getComponents()) {
						if (compIndex >= 3) {
							frame.getMyEventsPanel().remove(comp);
						}
						compIndex++;
					}

					// parcours de la liste des Event auxquels l'utilisateur participe
					for (model.Event event : participationsInAnEvent) {
						JPanel panelEvent = new EventItemPanel(frame, event);	
						panelEvent.addMouseListener(new DisplayEventListener());
						frame.getMyEventsPanel().add(panelEvent);
						frame.getMyEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));
					}

					// sur liste d'attente
					frame.getMyEventsPanel().add(Box.createRigidArea(new Dimension(0,30)));
					JPanel waitingPanel = new JPanel();
					waitingPanel.setBackground(Frame.colorEventary);
					waitingPanel.setMaximumSize(new Dimension(800,30));
					waitingPanel.add(new JLabel("Sur liste d'attente"));
					frame.getMyEventsPanel().add(waitingPanel);
					frame.getMyEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));

					// parcours de la liste des Event auxquels l'utilisateur est sur liste d'attente
					for (model.Event event : waitingsEvent) {
						JPanel panelEvent = new EventItemPanel(frame, event);		
						panelEvent.addMouseListener(new DisplayEventListener());
						frame.getMyEventsPanel().add(panelEvent);
						frame.getMyEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));
					}
				}

				SwingUtilities.updateComponentTreeUI(frame);
			}
		});

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