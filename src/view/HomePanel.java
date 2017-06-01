/*
 * 
 */
package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import controller.ChooseProfileImageListener;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class HomePanel.
 * 
 * La sidebar de gauche est composée 
 * du nom de l’utilisateur
 * de la photo de profil
 * d’un bouton pour accéder à la liste de tous les événements
 * d’un bouton pour accéder à la liste des événements auxquels l’utilisateur participe
 * d’un bouton pour créer un événement
 * d’un bouton pour accéder à la liste de ses notifications
 * d’un bouton pour accéder à la liste des organisations auxquelles l’utilisateur appartient
 * d’un bouton pour se déconnecter et revenir à l’interface de connexion
 * Au clic sur la photo, un explorateur de fichiers apparaît. L’utilisateur peut sélectionner une nouvelle photo de profil.
 * Au clic sur sur un événement de la liste, cela permet de faire apparaître l’interface qui détail un événement.
 */
public class HomePanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;

	/** The frame. */
	Frame frame;

	/** The container central. */
	Container containerCentral;

	/** The left panel. */
	JPanel leftPanel;

	/** The label error. */
	JLabel labelMessage;

	/** The button 'All Events'. */
	JButton allEventsButton;

	/** The button 'My Events'. */
	JButton myEventsButton;

	/** The create event button. */
	JButton createEventButton;

	/** The notif button. */
	JButton notifButton;
	
	/** The orga button. */
	JButton orgaButton;
	
	/** The Quit button. */
	JButton quitButton;

	/** The scroll main panel. */
	JScrollPane scrollMainPanel;

	/** The profile panel. */
	JPanel profilePanel;



	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	HomePanel(Frame frame){
		this.frame = frame;
		this.setLayout(new BorderLayout());

		// #################### sidebar de gauche
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(null);
		this.leftPanel.setBackground(Frame.colorEventary);
		this.leftPanel.setPreferredSize(new Dimension(Frame.sidebarWidth, Frame.heightScreen));
		ImageIcon profilImage = new ImageIcon("nerd.png");
		this.leftPanel.add(new JLabel(profilImage));

		// panel du profil utilisateur
		this.profilePanel = new JPanel();
		this.profilePanel.setBackground(Frame.colorEventary);

		// Tous les evenements
		allEventsButton = new EventaryMenuButton();
		allEventsButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),250,widthMenuButton,heightMenuButton);
		this.leftPanel.add(allEventsButton);

		// Mes evenements
		myEventsButton = new EventaryMenuButton();
		myEventsButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),290,widthMenuButton,heightMenuButton);
		this.leftPanel.add(myEventsButton);

		// Creer un evenement
		createEventButton = new EventaryMenuButton();
		createEventButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),330,widthMenuButton,heightMenuButton);
		this.leftPanel.add(createEventButton);

		// Notifications
		notifButton = new EventaryMenuButton();
		notifButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),370,widthMenuButton,heightMenuButton);
		this.leftPanel.add(notifButton);
		
		// Mes organisations
		orgaButton = new EventaryMenuButton();
		orgaButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),410,widthMenuButton,heightMenuButton);
		this.leftPanel.add(orgaButton);
		
		// Quitter
		quitButton = new EventaryMenuButton(new Color(255, 85, 50));
		quitButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),(int) (Frame.heightScreen*.90),widthMenuButton,heightMenuButton);
		this.leftPanel.add(quitButton);

		// #################### composant central
		// container central
		this.containerCentral = new Container();

		// on place la container dans une scroll bar 
		this.scrollMainPanel = new JScrollPane(this.containerCentral, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// placement de la sidebar et du composant central dans l'interface
		this.add(this.leftPanel,BorderLayout.WEST);	
		this.add(this.scrollMainPanel,BorderLayout.CENTER);
	}


	/**
	 * Gets the all events button.
	 *
	 * @return the all events button
	 */
	public JButton getAllEventsButton() {
		return allEventsButton;
	}


	/**
	 * Gets the my events button.
	 *
	 * @return the my events button
	 */
	public JButton getMyEventsButton() {
		return myEventsButton;
	}


	/**
	 * Gets the creates the event button.
	 *
	 * @return the creates the event button
	 */
	public JButton getCreateEventButton() {
		return createEventButton;
	}


	/**
	 * Gets the notif button.
	 *
	 * @return the notif button
	 */
	public JButton getNotifButton() {
		return notifButton;
	}


	/**
	 * Gets the orga button.
	 *
	 * @return the orga button
	 */
	public JButton getOrgaButton() {
		return orgaButton;
	}


	/**
	 * Gets the quit button.
	 *
	 * @return the quit button
	 */
	public JButton getQuitButton() {
		return quitButton;
	}


	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public Frame getFrame() {
		return this.frame;
	}


	/**
	 * Sets the container central.
	 *
	 * @param newContainer the new container central
	 */
	public void setContainerCentral(Container newContainer){
		// suppresion du contenu du containerCentral actuel
		this.remove(((BorderLayout) this.getLayout()).getLayoutComponent(BorderLayout.CENTER));

		// on place newContainer dans une scrollbar
		this.containerCentral = new JScrollPane(newContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// et on ajoute cette scrollbar au container central
		this.add(this.containerCentral, BorderLayout.CENTER);
	}


	/**
	 * Display profile.
	 *
	 * @param user the user
	 * @param profileImagePath the profile image path
	 */
	public void displayProfile(User user, String profileImagePath){
		this.profilePanel.removeAll();
		this.profilePanel.setLayout(new BorderLayout());

		JLabel profileLabel = new JLabel(new ImageIcon(new ImageIcon(profileImagePath).getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH)));
		JLabel nameLabel = new JLabel(user.getfName()+" "+user.getlName());
		nameLabel.setFont(new Font("Impact", Font.PLAIN, 22));
		this.profilePanel.add(profileLabel, BorderLayout.CENTER);
		this.profilePanel.add(nameLabel, BorderLayout.NORTH);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		this.profilePanel.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2)-5,8,210,230);
		this.leftPanel.add(profilePanel);
		
		// suppression des MouseListener anciennement appliqués sur le panel profilePanel
	    for( MouseListener listener : profilePanel.getMouseListeners() ) {
	    	profilePanel.removeMouseListener( listener );
	    }
		
		profilePanel.addMouseListener(new ChooseProfileImageListener(this, user));

		// rafraichissement de la JFrame
		SwingUtilities.updateComponentTreeUI(this);
	}
}