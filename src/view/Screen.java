package view;

import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Screen extends JFrame{
	
	public static final int widthScreen = 1440;
	private static final int heightScreen = 810;
	
	private static final int widthText = 150;
	private static final int heightText = 25;

	private static final int widthButton = 95;
	private static final int heightButton = 25;
	
	private static final int widthMainPanel = 360;
	
	public static final Color colorEventary = new Color(191,169,120);
	public static final Color colorEventaryError = new Color(214,56,45);
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel secondaryPanel;
	private JPanel messagePanel;
	

	public Screen(){
		this.setTitle("Eventary");
	    this.setSize(widthScreen,heightScreen);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(null);
	    this.displayLogin(true);
	}
	
	void displayLogin(boolean firstLogin){
		if (!(firstLogin)){
			getContentPane().remove(messagePanel);
			getContentPane().remove(mainPanel);
		}
		
	    mainPanel = new JPanel();
	    mainPanel.setBackground(colorEventary);
	    mainPanel.setBounds(0,0,widthScreen, heightScreen);
	    mainPanel.setLayout(null);
	    
	    JTextField login = new JTextField();
	    login.setHorizontalAlignment(JTextField.CENTER);
	    login.setBounds((int) (widthScreen/2 - widthText/2),(int) ((heightScreen/2 - heightText/2)-20),widthText,heightText);
	    mainPanel.add(login);
	    
	    JLabel labelLogin = new JLabel("Login : ");
	    labelLogin.setBounds((int) (widthScreen/2 - widthText*.9),(int) ((heightScreen/2 - heightText/2)-20),widthText,heightText);
	    mainPanel.add(labelLogin);
	    
	    JPasswordField password = new JPasswordField();
	    password.setHorizontalAlignment(JTextField.CENTER);
	    password.setBounds((int) (widthScreen/2 - widthText/2),(int) ((heightScreen/2 - heightText/2)+20),widthText,heightText);
	    mainPanel.add(password);
	    
	    JLabel passwordLogin = new JLabel("Password : ");
	    passwordLogin.setBounds((int) (widthScreen/2 - widthText),(int) ((heightScreen/2 - heightText/2)+20),widthText,heightText);
	    mainPanel.add(passwordLogin);
	    
	    JButton bouton = new EventaryButton("Connexion");
	    bouton.setBounds((int) (widthScreen/2 - widthButton/2),(int) (heightScreen/2 + 60),widthButton,heightButton);
		bouton.addActionListener(new ButtonConnexionListener(this));
	    mainPanel.add(bouton);
	    
	    mainPanel.setBounds(0,0,widthScreen,heightScreen);
	    this.getContentPane().add(mainPanel);
	    this.setVisible(true);
		repaint();
	}
	
	void displayMessage(String message, Color color){
		messagePanel = new JPanel();
		messagePanel.setLayout(null);
		messagePanel.setBackground(color);
		messagePanel.setBounds(0,0,widthScreen,40);
	    
	    JLabel labelError = new JLabel(message,(Icon) new ImageIcon("i.png"),SwingConstants.LEFT);
	    labelError.setBounds(50,10,widthScreen,20);
	    messagePanel.add(labelError);
	    mainPanel.add(messagePanel);
		repaint();
	}
  
	void displayHome(){
		repaint();
		this.getContentPane().remove(messagePanel);
		this.getContentPane().remove(mainPanel);
		mainPanel = new JPanel();
	    mainPanel.setLayout(null);
		mainPanel.setBackground(colorEventary);
	    mainPanel.setBounds(0,0,widthMainPanel, heightScreen);
	    
		secondaryPanel = new JPanel();
		secondaryPanel.setBounds(widthMainPanel,0,widthScreen-widthMainPanel, heightScreen);
		secondaryPanel.setBackground(Color.WHITE);
	    
		
		JButton bouton = new EventaryButton("Quitter");
		bouton.setBounds((int) (widthMainPanel/2 - widthButton/2),(int) (heightScreen*.87),widthButton,heightButton);
		bouton.addActionListener(new ButtonDisconnection(this));
		mainPanel.add(bouton);

	    JLabel labelConnected = new JLabel("Welcome Home!");
	    secondaryPanel.add(labelConnected);
		this.getContentPane().add(mainPanel,BorderLayout.WEST);
		this.getContentPane().add(secondaryPanel,BorderLayout.CENTER);
	    this.setVisible(true);
	}
}

class Main {

  public static void main(String[] args){

	  Screen screen = new Screen();
    //screen.getConnected();
  }
}
