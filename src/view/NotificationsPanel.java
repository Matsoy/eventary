/*
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationsPanel.
 */
public class NotificationsPanel extends JPanel {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The frame. */
	Frame frame;

	JButton clearButton;

	/**
	 * Instantiates a new notifications panel.
	 *
	 * @param frame the frame
	 */
	public NotificationsPanel(Frame frame){
		this.frame = frame;
		this.clearButton = new EventaryButton();
	}

	public JButton getClearButton() {
		return clearButton;
	}

	/**
	 * Display notif.
	 */
	public void displayNotif(List<String> listeNotif) {
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
		gc.weighty = listeNotif.size() + 1;

		/* pour dire qu'on ajoute un composant en position (i, j), on définit gridx=i et gridy=j */
		gc.gridy = 0;

		/* insets définir la marge entre les composant new Insets(margeSupérieure, margeGauche, margeInférieur, margeDroite) */
		gc.insets = new Insets(5, 5, 5, 5);

		// mes notifications
		JPanel notifPanel = new JPanel();
		notifPanel.setBackground(Frame.colorEventary);
		notifPanel.setPreferredSize(new Dimension(800,20));
		notifPanel.add(new JLabel("Mes Notifications"));
		
		// clear Button
		this.clearButton.setPreferredSize(new Dimension(200,20));
		notifPanel.add(clearButton);
		this.add(notifPanel, gc);

		// parcours de la liste des Notif
		for (String notif : listeNotif) {
			gc.gridy++;
			JPanel panelNotif = new JPanel();
			panelNotif.setPreferredSize(new Dimension(800,160));
			panelNotif.add(new JLabel(notif));
			this.add(panelNotif, gc);
		}
	}
}
