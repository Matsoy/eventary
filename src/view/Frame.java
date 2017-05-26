/*
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import input_output.Reader;
import model.Event;

// TODO: Auto-generated Javadoc
/**
 * The Class Frame.
 */
public class Frame extends JFrame{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthScreen. */
	static final int widthScreen = Reader.readInteger("ScreenWidth");

	/** The Constant heightScreen. */
	static final int heightScreen = Reader.readInteger("ScreenHeight");

	/** The Constant widthText. */
	static final int widthText = Reader.readInteger("TextWidth");

	/** The Constant heightText. */
	static final int heightText = Reader.readInteger("TextHeight");

	/** The Constant widthButton. */
	static final int widthButton = Reader.readInteger("ButtonWidth");

	/** The Constant heightButton. */
	static final int heightButton = Reader.readInteger("ButtonHeight");

	/** The Constant sidebarWidth. */
	static final int sidebarWidth = Reader.readInteger("SidebarWidth");

	/** The Constant colorEventary. */
	public static final Color colorEventary = new Color(191,169,120);

	/** The Constant colorEventaryError. */
	public static final Color colorEventaryError = new Color(214,56,45);

	/** The connection panel. */
	ConnectionPanel connectionPanel;

	/** The home panel. */
	HomePanel homePanel;

	/** The home panel. */
	AllEventsPanel allEventsPanel;

	/** The home panel. */
	MyEventsPanel myEventsPanel;

	/** The create event panel. */
	CreateEventPanel createEventPanel;

	/** The message panel. */
	JPanel messagePanel;

	/** The event panel. */
	EventPanel eventPanel;

	/** The agenda panel. */
	AgendaPanel agendaPanel;

	/** The display event panel. */
	EventPanel displayEventPanel;

	/** The notif panel. */
	NotificationsPanel notifPanel;
	
	MyOrganisationsPanel myOrgaPanel;
	
	OrgaPanel orgaPanel;


	/**
	 * Instantiates a new frame.
	 */
	public Frame(){
		// initialisation des differents panels
		this.connectionPanel = new ConnectionPanel(this);
		this.homePanel = new HomePanel(this);
		this.allEventsPanel = new AllEventsPanel(this);
		this.myEventsPanel = new MyEventsPanel(this);
		this.createEventPanel = new CreateEventPanel(this);
		this.notifPanel = new NotificationsPanel(this);
		this.displayEventPanel = new EventPanel(this);
		this.myOrgaPanel = new MyOrganisationsPanel(this);
		this.orgaPanel = new OrgaPanel(this);

		this.setTitle("Eventary");
		this.setResizable(false);
		this.setSize(widthScreen,heightScreen);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		this.messagePanel = new JPanel();
		this.messagePanel.setBounds(0,0,Frame.widthScreen,25);

		setConnectionPanel();
		this.setVisible(true);
	}


	/**
	 * Gets the connection panel.
	 *
	 * @return the connection panel
	 */
	public ConnectionPanel getConnectionPanel() {
		return connectionPanel;
	}


	/**
	 * Gets the home panel.
	 *
	 * @return the home panel
	 */
	public HomePanel getHomePanel() {
		return homePanel;
	}


	/**
	 * Gets the event panel.
	 *
	 * @return the event panel
	 */
	public EventPanel getEventPanel() {
		return eventPanel;
	}


	/**
	 * Gets the agenda panel.
	 *
	 * @return the agenda panel
	 */
	public AgendaPanel getAgendaPanel() {
		return agendaPanel;
	}


	/**
	 * Gets the all events panel.
	 *
	 * @return the all events panel
	 */
	public AllEventsPanel getAllEventsPanel() {
		return allEventsPanel;
	}


	/**
	 * Gets the my events panel.
	 *
	 * @return the my events panel
	 */
	public MyEventsPanel getMyEventsPanel() {
		return myEventsPanel;
	}


	/**
	 * Gets the creates the event panel.
	 *
	 * @return the creates the event panel
	 */
	public CreateEventPanel getCreateEventPanel() {
		return createEventPanel;
	}


	/**
	 * Gets the notif panel.
	 *
	 * @return the notif panel
	 */
	public NotificationsPanel getNotifPanel() {
		return notifPanel;
	}


	/**
	 * Gets the display event panel.
	 *
	 * @return the display event panel
	 */
	public EventPanel getDisplayEventPanel() {
		return displayEventPanel;
	}

	
	public MyOrganisationsPanel getMyOrgaPanel() {
		return myOrgaPanel;
	}
	
	public OrgaPanel getOrgaPanel() {
		return orgaPanel;
	}

	/**
	 * Sets the message panel.
	 */
	public void setMessagePanel(){
		this.add(this.messagePanel);
		this.messagePanel.setVisible(false);
	}


	/**
	 * Sets the connection panel.
	 */
	public void setConnectionPanel(){
		this.getContentPane().removeAll();
		setMessagePanel();
		connectionPanel.setBounds(0,0,widthScreen,heightScreen);
		this.getContentPane().add(connectionPanel);
		SwingUtilities.updateComponentTreeUI(this);
	}


	/**
	 * Sets the home panel.
	 *
	 * @param events la liste des evenements
	 */
	public void setHomePanel(ArrayList<Event> events){
		// on enleve le ConnectionPanel
		this.getContentPane().removeAll();
		setMessagePanel();
		homePanel.setBounds(0,0,widthScreen,heightScreen-27);
		this.getContentPane().add(homePanel);
	}


	/**
	 * Display error.
	 *
	 * @param str the str
	 * @param color the color
	 */
	public void displayMessage(String str, Color color) {
		// panel qui contiendra le message d'erreur
		this.messagePanel.removeAll();
		this.messagePanel.setBackground(color);
		this.messagePanel.setLayout(new BorderLayout());
		JLabel imgLabel = new JLabel(new ImageIcon(new ImageIcon("img/notification.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT)));	
		messagePanel.add(imgLabel, BorderLayout.WEST);
		JLabel messLabel = new JLabel(str);
		messLabel.setHorizontalAlignment(JLabel.CENTER);
		messagePanel.add(messLabel, BorderLayout.CENTER);
		// message d'erreur invisible par défaut
		this.messagePanel.setVisible(true);
		this.messagePanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				messagePanel.setVisible(false);
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
		});

		// rafraichissement de la JFrame
		SwingUtilities.updateComponentTreeUI(this);
	}
}
