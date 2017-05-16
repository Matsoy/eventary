package view;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import input_output.Reader;

public class Frame extends JFrame{
	static final int widthScreen = Reader.readInteger("ScreenWidth");
	static final int heightScreen = Reader.readInteger("ScreenHeight");
	static final int widthText = Reader.readInteger("TextWidth");
	static final int heightText = Reader.readInteger("TextHeight");
	static final int widthButton = Reader.readInteger("ButtonWidth");
	static final int heightButton = Reader.readInteger("ButtonHeight");
	static final int widthMainPanel = Reader.readInteger("MainPanelWidth");

	public static final Color colorEventary = new Color(191,169,120);
	public static final Color colorEventaryError = new Color(214,56,45);

	ConnectionPanel connectionPanel;
	HomePanel homePanel;
	JPanel messagePanel;
	
	public Frame(){
		this.connectionPanel = new ConnectionPanel(this/*actionConnection*/);
		this.homePanel = new HomePanel(this);
		
		this.setTitle("Eventary");
	    this.setSize(widthScreen,heightScreen);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(null);
	    
	    setConnectionPanel();
	}
	
	public ConnectionPanel getConnectionPanel() {
		return connectionPanel;
	}

	public HomePanel getHomePanel() {
		return homePanel;
	}

	public void setConnectionPanel(){
		connectionPanel.setBounds(0,0,widthScreen,heightScreen);
	    this.getContentPane().add(connectionPanel);
	    this.setVisible(true);
		repaint();
	}
	
	public void setHomePanel(){
		homePanel.setBounds(0,0,widthScreen,heightScreen);
	    this.getContentPane().add(homePanel);
	    this.setVisible(true);
		repaint();
	}
	
	public void displayMessage(String message, Color color){
		messagePanel = new JPanel();
		messagePanel.setLayout(null);
		messagePanel.setBackground(color);
		messagePanel.setBounds(0,0,widthScreen,40);

	    JLabel labelError = new JLabel(message,(Icon) new ImageIcon("i.png"),SwingConstants.LEFT);
	    labelError.setBounds(50,10,widthScreen,20);
	    messagePanel.add(labelError);
	    this.add(messagePanel);
		repaint();
	}
		
}
