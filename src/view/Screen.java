package view;

import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Screen extends JFrame{
	
	private static int widthScreen = 1440;
	private static int heightScreen = 810;
	private static int widthText = 150;
	private static int heightText = 25;

	private static int widthButton = 95;
	private static int heightButton = 25;
	
	private static Color colorEventary = new Color(191,169,120);
	private static Color colorEventaryError = new Color(214,56,45);
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel secondaryPanel;
	

	public Screen(){
		//Definit un titre pour notre fenetre
		this.setTitle("Eventary");
	    //Definit sa taille : 400 pixels de large et 100 pixels de haut
	    this.setSize(widthScreen,heightScreen);
	    //Nous demandons maintenant a notre objet de se positionner au centre
	    this.setLocationRelativeTo(null);
	    //Termine le processus lorsqu'on clique sur la croix rouge
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(new BorderLayout());
	    mainPanel = new JPanel();
	    mainPanel.setBackground(colorEventary);
	    mainPanel.setLayout(null);
	    this.getContentPane().add(mainPanel);
    
    
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
	    
	    //Et enfin, la rendre visible
	    this.setVisible(true);
	}
	
	void displayError(String message){
	    JLabel labelError = new JLabel(message,(Icon) new ImageIcon("i.png"),SwingConstants.LEFT);
	    labelError.setBounds(widthScreen/10,0,widthScreen,70);
	    mainPanel.add(labelError);
	    
		JPanel panelError = new JPanel();
		panelError.setBackground(colorEventaryError);
		panelError.setBounds(0,0,widthScreen,70);
	    this.mainPanel.add(panelError);
	    repaint();
	}
  
	void getConnected(){
		repaint(); 
		this.getContentPane().remove(mainPanel);
		this.setLayout(new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.setBackground(colorEventary);
		mainPanel.setPreferredSize(new Dimension(360, 810));
	    
		this.secondaryPanel = new JPanel();
		secondaryPanel.setBackground(Color.WHITE);
	    mainPanel.setLayout(new FlowLayout());
	    
		this.getContentPane().add(mainPanel,BorderLayout.WEST);
		this.getContentPane().add(secondaryPanel,BorderLayout.CENTER);
		
		JButton bouton = new EventaryButton("Quitter");
	    mainPanel.add(bouton);

	    JLabel labelConnected = new JLabel("Welcome Home!");
	    secondaryPanel.add(labelConnected);
	    this.setVisible(true);
	}
}

class Main {

  public static void main(String[] args){

	  Screen screen = new Screen();
    //screen.getConnected();
  }
}
