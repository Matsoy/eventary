package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Event;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionPanel.
 */
public class ConnectionPanel extends JPanel {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The login. */
	JTextField login;
	
	/** The label login. */
	JLabel labelLogin;
	
	/** The password. */
	JPasswordField password;
	
	/** The password login. */
	JLabel passwordLogin;
	
	/** The bouton. */
	JButton bouton;
	
	/** The frame. */
	Frame frame;
	
	/** The label error. */
	JLabel labelError;

	/**
	 * Instantiates a new connection panel.
	 *
	 * @param frame the frame
	 */
	ConnectionPanel(Frame frame){
		this.frame = frame;
		this.setBackground(Frame.colorEventary);
		this.setBounds(0,0,Frame.widthScreen, Frame.heightScreen);
		this.setLayout(new BorderLayout());

		// panel qui contient le formulaire de connexion avec les differents champs et le bouton
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Frame.colorEventary);

		
		this.login = new JTextField("E168011W");
		this.login.setHorizontalAlignment(JTextField.CENTER);
		this.login.setBounds((int) (Frame.widthScreen/2 - Frame.widthText/2),(int) ((Frame.heightScreen/2 - Frame.heightText/2)-20), Frame.widthText, Frame.heightText);
		mainPanel.add(login);

		this.labelLogin = new JLabel("Login : ");
		this.labelLogin.setBounds((int) (Frame.widthScreen/2 - Frame.widthText*.9),(int) ((Frame.heightScreen/2 - Frame.heightText/2)-20), Frame.widthText, Frame.heightText);
		mainPanel.add(labelLogin);

		this.password = new JPasswordField("petitkiwi");
		password.setHorizontalAlignment(JTextField.CENTER);
		password.setBounds((int) (Frame.widthScreen/2 - Frame.widthText/2),(int) ((Frame.heightScreen/2 - Frame.heightText/2)+20), Frame.widthText, Frame.heightText);
		mainPanel.add(password);

		this.passwordLogin = new JLabel("Password : ");
		passwordLogin.setBounds((int) (Frame.widthScreen/2 - Frame.widthText),(int) ((Frame.heightScreen/2 - Frame.heightText/2)+20),Frame.widthText,Frame.heightText);
		mainPanel.add(passwordLogin);

		this.bouton = new EventaryButton();

		this.bouton.setBounds((int) (Frame.widthScreen/2 - Frame.widthButton/2),(int) (Frame.heightScreen/2 + 60),Frame.widthButton,Frame.heightButton);
		mainPanel.add(bouton);
		
		// ajout du pannel principal au centre du JPanel ConnectionPanel
		this.add(mainPanel, BorderLayout.CENTER);
		
	}

	/**
	 * Gets the bouton.
	 *
	 * @return the bouton
	 */
	public JButton getBouton() {
		return this.bouton;
	}

	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin(){
		return this.login.getText();
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	@SuppressWarnings("deprecation")
	public String getPassword(){
		return this.password.getText();
	}

	/**
	 * Sets the home panel.
	 *
	 * @param events la liste des evenements
	 */
	public void setHomePanel(ArrayList<Event> events) {
		System.out.println("setHomePanel de ConnectionPanel");
		// TODO Auto-generated method stub
		this.frame.setHomePanel(events);	
	}

	/**
	 * Display error.
	 *
	 * @param str the str
	 * @param color the color
	 */
	public void displayError(String str, Color color) {
		this.frame.displayMessage(str, color);
	}
}
