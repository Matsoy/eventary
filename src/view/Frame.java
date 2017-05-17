package view;

import java.awt.Color;
import java.util.ArrayList;

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

	/** The main panel. */
	JPanel mainPanel;

	/** The message panel. */
	JPanel messagePanel;
	
	/** The event panel. */
	EventPanel eventPanel;
	
	/** The agenda panel. */
	AgendaPanel agendaPanel;

	/**
	 * Instantiates a new frame.
	 */
	public Frame(){
		this.connectionPanel = new ConnectionPanel(this);
		this.homePanel = new HomePanel(this);

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
		repaint();
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
		homePanel.setBounds(0,0,widthScreen,heightScreen);
		this.getContentPane().add(homePanel);
		homePanel.displayAllEvents(events);
		SwingUtilities.updateComponentTreeUI(this);
	}

	/**
	 * Display error.
	 *
	 * @param str the str
	 * @param color the color
	 */
	public void displayMessage(String str, Color color) {
		System.out.println("dans displayMEssage");
		// panel qui contiendra le message d'erreur
		this.messagePanel.removeAll();
		this.messagePanel.setBackground(color);
		//this.labelMessage.setBounds(20,15,Frame.widthScreen,10);
		messagePanel.add(new JLabel(str));
		// message d'erreur invisible par défaut
		this.messagePanel.setVisible(true);
		// rafraichissement de la JFrame
		SwingUtilities.updateComponentTreeUI(this);
	}
}
