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
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel secondaryPanel;
	

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
    
    
	    JTextField login = new JTextField();
	    login.setHorizontalAlignment(JTextField.CENTER);
	    login.setBounds((int) (widthScreen/2 - widthText/2),(int) ((heightScreen/2 - heightText/2)-20),widthText,heightText);
	    mainPanel.add(login);
    
	    JPasswordField password = new JPasswordField();
	    password.setHorizontalAlignment(JTextField.CENTER);
	    password.setBounds((int) (widthScreen/2 - widthText/2),(int) ((heightScreen/2 - heightText/2)+20),widthText,heightText);
	    mainPanel.add(password);
	    
	    JButton bouton = new EventaryButton("Connexion");
	    bouton.setBounds((int) (widthScreen/2 - widthButton/2),(int) (heightScreen/2 + 60),widthButton,heightButton);
		bouton.addActionListener(new ButtonConnexionListener(this));
	    mainPanel.add(bouton);
	    
	    //Et enfin, la rendre visible
	    this.setVisible(true);
	}
  
	void getConnected(){
		repaint(); 
		this.getContentPane().remove(mainPanel);
		this.setLayout(new BorderLayout());
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(191,169,120));
		mainPanel.setPreferredSize(new Dimension(360, 810));
	    
		this.secondaryPanel = new JPanel();
		secondaryPanel.setBackground(Color.WHITE);
	    
		this.getContentPane().add(mainPanel,BorderLayout.WEST);
		this.getContentPane().add(secondaryPanel,BorderLayout.CENTER);
		
		JButton bouton = new EventaryButton("Connexion");
	    mainPanel.add(bouton);
	    this.setVisible(true);
	}
}

class Main {

  public static void main(String[] args){

	  Screen screen = new Screen();
    //screen.getConnected();
  }
}
