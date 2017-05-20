package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

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

	/** The main panel. */
	JPanel mainPanel;

	/** The left panel. */
	JPanel leftPanel;

	/** The frame. */
	Frame frame;

	/** The label error. */
	JLabel labelMessage;

	/** The button 'My Events'. */
	JButton myEventsButton;

	/** The Quit button. */
	JButton quitButton;

	/**  The panel for the creation of a new event. */
	JPanel newEventPanel;

	/** The scroll main panel. */
	JScrollPane scrollMainPanel;
	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	AllEventsPanel(Frame frame){
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
		this.setLayout(new GridBagLayout());

		// parametrage des contraintes du GridBagLayout
		GridBagConstraints gc = new GridBagConstraints();
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.ipady = gc.anchor = GridBagConstraints.NORTH;
		/* weightx définit le nombre de cases en abscisse */
		gc.weightx = 1;
		/* le parametre fill sert à définir comment le composant sera rempli GridBagConstraints.BOTH permet d'occuper tout l'espace disponible
		 * horizontalement et verticalement GridBagConstraints.HORIZONTAL maximise horizontalement GridBagConstraints.VERTICAL maximise verticalement
		 */
		gc.fill = GridBagConstraints.HORIZONTAL;
		/* weightx définit le nombre de cases en ordonnée */
		gc.weighty = events.size();
		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridx = 0;
		gc.gridy = 0;
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);

		// mes participations
		gc.gridy++;
		JPanel eventsPanel = new JPanel();
		eventsPanel.setBackground(Frame.colorEventary);
		eventsPanel.setPreferredSize(new Dimension(800,20));
		eventsPanel.add(new JLabel("Les evenements"));
		this.add(eventsPanel, gc);

		// parcours de la liste des Event
		for (model.Event event : events) {
			gc.gridy++;
			JPanel panelEvent = new JPanel();
			panelEvent.setPreferredSize(new Dimension(800,160));
			panelEvent.add(new JLabel(event.getTitle()));
			panelEvent.add(new JLabel(event.getStartDate().toString()));
			this.add(panelEvent, gc);
		}
	}

	/**
	 * Sets the connection panel.
	 */
	public void setConnectionPanel(){
		this.frame.setConnectionPanel();
	}
}