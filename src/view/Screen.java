package view;

import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

/**
 * The Class Screen.
 */
public class Screen extends JFrame{

	/** The width screen. */
	private static int widthScreen = 1440;

	/** The height screen. */
	private static int heightScreen = 810;

	/** The width text. */
	private static int widthText = 150;

	/** The height text. */
	private static int heightText = 25;

	/** The width button. */
	private static int widthButton = 95;

	/** The height button. */
	private static int heightButton = 25;

	/** The frame. */
	private JFrame frame;

	/** The main panel. */
	private JPanel mainPanel;

	/** The secondary panel. */
	private JPanel secondaryPanel;

	/** The login. */
	private JTextField login;

	/** The password. */
	private JPasswordField password;


	/**
	 * Instantiates a new screen.
	 */
	public Screen(){
		//D�finit un titre pour notre fen�tre
		this.setTitle("Eventary");
		//D�finit sa taille : 400 pixels de large et 100 pixels de haut
		this.setSize(widthScreen,heightScreen);
		//Nous demandons maintenant � notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(191,169,120));
		mainPanel.setLayout(null);
		this.getContentPane().add(mainPanel);


		this.login = new JTextField();
		this.login.setHorizontalAlignment(JTextField.CENTER);
		this.login.setBounds((int) (widthScreen/2 - widthText/2),(int) ((heightScreen/2 - heightText/2)-20),widthText,heightText);
		mainPanel.add(this.login);

		this.password = new JPasswordField();
		this.password.setHorizontalAlignment(JTextField.CENTER);
		this.password.setBounds((int) (widthScreen/2 - widthText/2),(int) ((heightScreen/2 - heightText/2)+20),widthText,heightText);
		mainPanel.add(this.password);

		JButton bouton = new EventaryButton("Connexion");
		bouton.setBounds((int) (widthScreen/2 - widthButton/2),(int) (heightScreen/2 + 60),widthButton,heightButton);
		bouton.addActionListener(new ButtonConnexionListener(this));
		mainPanel.add(bouton);

		//Et enfin, la rendre visible
		this.setVisible(true);
	}

	/**
	 * Gets the connected.
	 *
	 * @return the connected
	 */
	void getConnected(){
		this.getContentPane().remove(mainPanel);
		this.setLayout(new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(191,169,120));
		mainPanel.setPreferredSize(new Dimension(360, 810));

		this.secondaryPanel = new JPanel();
		secondaryPanel.setBackground(Color.WHITE);

		this.getContentPane().add(mainPanel,BorderLayout.CENTER);
		this.getContentPane().add(secondaryPanel,BorderLayout.WEST);

		JButton bouton = new EventaryButton("Connexion");
		mainPanel.add(bouton);
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login.getText();
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login.setText(login);
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@SuppressWarnings("deprecation")
	public String getPassword() {
		// When calling getText you get a String (immutable object) 
		// that may not be changed (except reflection) 
		// and so the password stays in the memory until garbage collected.
		return password.getText();
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password.setText(password);
	}




}

//class Main {
//
//  public static void main(String[] args){
//
//	  Screen screen = new Screen();
//    //screen.getConnected();
//  }
//}
