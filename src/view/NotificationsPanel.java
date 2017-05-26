/*
 * 
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(0,5)));
		
		// mes notifications
		JPanel notifPanel = new JPanel();
		notifPanel.setBackground(Frame.colorEventary);
		notifPanel.setMaximumSize(new Dimension(800,30));
		if(listeNotif.size() == 1) {
			notifPanel.add(new JLabel(listeNotif.size() + " Notification"));
		} else {
			notifPanel.add(new JLabel(listeNotif.size() + " Notifications"));
		}
		this.add(notifPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		
		// clear Button
		this.clearButton.setPreferredSize(new Dimension(200,20));
		notifPanel.add(clearButton);

		// parcours de la liste des Notif
		for (String notif : listeNotif) {
			JPanel panelNotif = new JPanel();
			panelNotif.setMaximumSize(new Dimension(800,80));
			panelNotif.add(new JLabel(notif));
			this.add(panelNotif);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
	}
}
