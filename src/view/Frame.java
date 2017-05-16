package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import input_output.Reader;

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
	
	/** The secondary panel. */
	JPanel secondaryPanel;
	
	/** The message panel. */
	JPanel messagePanel;
	
	/** The label error. */
	JLabel labelError;

	/**
	 * Instantiates a new frame.
	 */
	public Frame(){
		this.connectionPanel = new ConnectionPanel(this);
		this.homePanel = new HomePanel(this);

		this.setTitle("Eventary");
		this.setSize(widthScreen,heightScreen);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

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
	 * Sets the connection panel.
	 */
	public void setConnectionPanel(){
		connectionPanel.setBounds(0,0,widthScreen,heightScreen);
		this.getContentPane().add(connectionPanel);
		repaint();
	}

	/**
	 * Sets the home panel.
	 */
	public void setHomePanel(){
		homePanel.setBounds(0,0,widthScreen,heightScreen);
		// on enleve le ConnectionPanel
		this.getContentPane().removeAll();
		this.getContentPane().add(homePanel);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
