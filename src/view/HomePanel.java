package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 */
public class HomePanel extends JPanel{
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
	HomePanel(Frame frame){
		this.frame = frame;
		this.setLayout(new BorderLayout());
		// panel central
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(Color.WHITE);
		this.scrollMainPanel = new JScrollPane(this.mainPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(this.scrollMainPanel,BorderLayout.CENTER);
		// sidebar de gauche
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(null);
		this.leftPanel.setBackground(Frame.colorEventary);
		this.leftPanel.setPreferredSize(new Dimension(Frame.sidebarWidth, Frame.heightScreen));
		ImageIcon profilImage = new ImageIcon("nerd.png");
		this.leftPanel.add(new JLabel(profilImage));

		myEventsButton = new EventaryMenuButton("Mes evenements");
		myEventsButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),10,widthMenuButton,heightMenuButton);
		this.leftPanel.add(myEventsButton);
		quitButton = new EventaryButton("Quitter");
		quitButton.setBounds((int) (Frame.sidebarWidth/2 - Frame.widthButton/2),(int) (Frame.heightScreen*.87),Frame.widthButton,Frame.heightButton);
		this.leftPanel.add(quitButton);
		this.add(this.leftPanel,BorderLayout.WEST);
	}


	/**
	 * Affiche la liste des evenements de l'utilisateur courant
	 *
	 * @param participationsInAnEvent the participations in an event
	 * @param waitingsEvent the waitings event
	 */
	public void displayMyEvents(ArrayList<model.Event> participationsInAnEvent, ArrayList<model.Event> waitingsEvent){
		//JPanel panelEvent;
		this.mainPanel.removeAll();
		JPanel gridBagPanel = new JPanel();
		gridBagPanel.setBackground(Color.WHITE);
		gridBagPanel.setLayout(new GridBagLayout());
		this.mainPanel.add(gridBagPanel);

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
		gc.weighty = participationsInAnEvent.size() + waitingsEvent.size() + 3;
		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridx = 0;
		gc.gridy = 0;
		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);

		// panneau de creation d'un event
		newEventPanel = new JPanel();
		newEventPanel.setPreferredSize(new Dimension(800,20));
		newEventPanel.setBackground(new Color(102, 255, 102));
		newEventPanel.add(new JLabel("Creer un evenement"));
		//		ImageIcon icon = new ImageIcon("i.png");
		gridBagPanel.add(newEventPanel, gc);
		
		// mes participations
		gc.gridy++;
		JPanel ParticipationsPanel = new JPanel();
		ParticipationsPanel.setBackground(Frame.colorEventary);
		ParticipationsPanel.setPreferredSize(new Dimension(800,20));
		ParticipationsPanel.add(new JLabel("Mes participations"));
		gridBagPanel.add(ParticipationsPanel, gc);

		// parcours de la liste des Event auxquels l'utilisateur participe
		for (model.Event event : participationsInAnEvent) {
			gc.gridy++;
			JPanel panelEvent = new JPanel();
			panelEvent.setPreferredSize(new Dimension(800,160));
			panelEvent.add(new JLabel(event.getTitle()));
			panelEvent.add(new JLabel(event.getStartDate().toString()));
			gridBagPanel.add(panelEvent, gc);
		}
		
		// sur liste d'attente
		gc.gridy++;
		JPanel waitingPanel = new JPanel();
		waitingPanel.setBackground(Frame.colorEventary);
		waitingPanel.setPreferredSize(new Dimension(800,20));
		waitingPanel.add(new JLabel("Sur liste d'attente"));
		gridBagPanel.add(waitingPanel, gc);

		// parcours de la liste des Event auxquels l'utilisateur est sur liste d'attente
		for (model.Event event : waitingsEvent) {
			gc.gridy++;
			JPanel panelEvent = new JPanel();
			panelEvent.setPreferredSize(new Dimension(800,160));
			panelEvent.add(new JLabel(event.getTitle()));
			panelEvent.add(new JLabel(event.getStartDate().toString()));
			gridBagPanel.add(panelEvent, gc);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
	
	/**
	 * Affiche la liste de tous les evenements
	 *
	 * @param events the events
	 */
	public void displayAllEvents(ArrayList<model.Event> events){
		//JPanel panelEvent;
		this.mainPanel.removeAll();
		JPanel gridBagPanel = new JPanel();
		gridBagPanel.setBackground(Color.WHITE);
		gridBagPanel.setLayout(new GridBagLayout());
		this.mainPanel.add(gridBagPanel);

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
		gridBagPanel.add(eventsPanel, gc);

		// parcours de la liste des Event
		for (model.Event event : events) {
			gc.gridy++;
			JPanel panelEvent = new JPanel();
			panelEvent.setPreferredSize(new Dimension(800,160));
			panelEvent.add(new JLabel(event.getTitle()));
			panelEvent.add(new JLabel(event.getStartDate().toString()));
			gridBagPanel.add(panelEvent, gc);
		}
		
		SwingUtilities.updateComponentTreeUI(this);
	}

	/**
	 * Gets the my events button.
	 *
	 * @return the my events button
	 */
	public JButton getMyEventsButton(){
		return myEventsButton;
	}

	/**
	 * Gets the quit button.
	 *
	 * @return the quit button
	 */
	public JButton getQuitButton(){
		return quitButton;
	}

	/**
	 * Sets the connection panel.
	 */
	public void setConnectionPanel(){
		this.frame.setConnectionPanel();
	}
}