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
import model.Context;

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

	/** The filter box. */
	JComboBox<String> filterBox;

	/** The filter box model. */
	DefaultComboBoxModel<String> filterBoxModel;


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
	 * @param sites the sites
	 */
	public void displayAllEvents(ArrayList<model.Event> events,  Context model, ArrayList<model.Site> sites){
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

		// bouton de filtre
		this.filterBox = new EventaryComboBox<String>();
		this.filterBoxModel = new DefaultComboBoxModel<String>();
		this.filterBoxModel.addElement("< Filtrer par site >");
		for (int i = 0; i < sites.size(); i++) {
			filterBoxModel.addElement(sites.get(i).getName());
		}
		filterBox.setModel(filterBoxModel);
		eventsPanel.add(filterBox);

		// quand sélection d'un site
		filterBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (filterBox.getSelectedIndex() > 0)) {
					// on supprime les evenement affichés
					int compIndex = 0;
					for (Component comp : frame.getAllEventsPanel().getComponents()) {
						if (compIndex >= 3) {
							frame.getAllEventsPanel().remove(comp);
						}
						compIndex++;
					}

					// parcours de la liste des Event
					for (model.Event event : events) {
						if(EventDAO.isInSite(event, sites.get(filterBox.getSelectedIndex()-1).getId())){
							JPanel panelEvent = new EventItemPanel(frame, event);	
							panelEvent.addMouseListener(new DisplayEventListener(model));
							frame.getAllEventsPanel().add(panelEvent);
							frame.getAllEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));
						}
					}
				}
				else if ((e.getStateChange() == ItemEvent.SELECTED) && (filterBox.getSelectedIndex() == 0)) { //si pas de filtre par site, alors on affiche tous les événements
					// on supprime les evenement affichés
					int compIndex = 0;
					for (Component comp : frame.getAllEventsPanel().getComponents()) {
						if (compIndex >= 3) {
							frame.getAllEventsPanel().remove(comp);
						}
						compIndex++;
					}
					
					// parcours de la liste des Event
					for (model.Event event : events) {
						JPanel panelEvent = new EventItemPanel(frame, event);	
						panelEvent.addMouseListener(new DisplayEventListener(model));
						frame.getAllEventsPanel().add(panelEvent);
						frame.getAllEventsPanel().add(Box.createRigidArea(new Dimension(0,10)));
					}
				}

				SwingUtilities.updateComponentTreeUI(frame);
			}
		});

		// parcours de la liste des Event
		for (model.Event event : events) {
			JPanel panelEvent = new EventItemPanel(this.frame, event);	
			panelEvent.addMouseListener(new DisplayEventListener(model));
			this.add(panelEvent);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
	}
}