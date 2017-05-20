package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class HomePanel.
 */
public class MyEventsPanel extends JPanel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;

	/** The frame. */
	Frame frame;

	/**  The panel for the creation of a new event. */
	JPanel newEventPanel;
	
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
		gc.weighty = participationsInAnEvent.size() + waitingsEvent.size() + 2;
		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridx = 0;
		gc.gridy = 0;
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);

		// mes participations
		JPanel ParticipationsPanel = new JPanel();
		ParticipationsPanel.setBackground(Frame.colorEventary);
		ParticipationsPanel.setPreferredSize(new Dimension(800,20));
		ParticipationsPanel.add(new JLabel("Mes participations"));
		this.add(ParticipationsPanel, gc);

		// parcours de la liste des Event auxquels l'utilisateur participe
		for (model.Event event : participationsInAnEvent) {
			gc.gridy++;
			JPanel panelEvent = new JPanel();
			panelEvent.setPreferredSize(new Dimension(800,160));
			panelEvent.add(new JLabel(event.getTitle()));
			panelEvent.add(new JLabel(event.getStartDate().toString()));
			this.add(panelEvent, gc);
		}

		// sur liste d'attente
		gc.gridy++;
		JPanel waitingPanel = new JPanel();
		waitingPanel.setBackground(Frame.colorEventary);
		waitingPanel.setPreferredSize(new Dimension(800,20));
		waitingPanel.add(new JLabel("Sur liste d'attente"));
		this.add(waitingPanel, gc);

		// parcours de la liste des Event auxquels l'utilisateur est sur liste d'attente
		for (model.Event event : waitingsEvent) {
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