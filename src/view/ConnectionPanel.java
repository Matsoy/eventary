package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controler.ActionConnection;

public class ConnectionPanel extends JPanel {
	JTextField login;
	JLabel labelLogin;
	JPasswordField password;
	JLabel passwordLogin;
	JButton bouton;
	ActionConnection action;
	Frame frame;
	
	ConnectionPanel(Frame frame){
		this.frame = frame;
	    this.setBackground(Frame.colorEventary);
	    this.setBounds(0,0,Frame.widthScreen, Frame.heightScreen);
	    this.setLayout(null);
	    
		JTextField login = new JTextField();
	    login.setHorizontalAlignment(JTextField.CENTER);
	    login.setBounds((int) (Frame.widthScreen/2 - Frame.widthText/2),(int) ((Frame.heightScreen/2 - Frame.heightText/2)-20), Frame.widthText, Frame.heightText);
	    this.add(login);

	    JLabel labelLogin = new JLabel("Login : ");
	    labelLogin.setBounds((int) (Frame.widthScreen/2 - Frame.widthText*.9),(int) ((Frame.heightScreen/2 - Frame.heightText/2)-20), Frame.widthText, Frame.heightText);
	    this.add(labelLogin);

	    JPasswordField password = new JPasswordField();
	    password.setHorizontalAlignment(JTextField.CENTER);
	    password.setBounds((int) (Frame.widthScreen/2 - Frame.widthText/2),(int) ((Frame.heightScreen/2 - Frame.heightText/2)+20), Frame.widthText, Frame.heightText);
	    this.add(password);

	    JLabel passwordLogin = new JLabel("Password : ");
	    passwordLogin.setBounds((int) (Frame.widthScreen/2 - Frame.widthText),(int) ((Frame.heightScreen/2 - Frame.heightText/2)+20),Frame.widthText,Frame.heightText);
	    this.add(passwordLogin);

	    JButton bouton = new EventaryButton("Connexion");
	    bouton.setBounds((int) (Frame.widthScreen/2 - Frame.widthButton/2),(int) (Frame.heightScreen/2 + 60),Frame.widthButton,Frame.heightButton);
		//bouton.setAction(action);
	    this.add(bouton);
	}
	
	public JButton getBouton() {
		return bouton;
	}

	public String getLogin(){
		return this.login.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword(){
		return this.password.getText();
	}

	public void setHomePanel() {
		// TODO Auto-generated method stub
		this.frame.setHomePanel();
	}

	public void displayMessage(String string, Color color) {
		// TODO Auto-generated method stub
		this.frame.displayMessage(string, color);
	}
}
