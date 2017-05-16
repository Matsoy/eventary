package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomePanel extends JPanel{
	
	JPanel mainPanel;
	JPanel secondaryPanel;
	Frame frame;
	
	HomePanel(Frame frame){
		this.frame = frame;
		repaint();
		//this.getContentPane().remove(messagePanel);
		//this.getContentPane().remove(mainPanel);
		mainPanel = new JPanel();
	    mainPanel.setLayout(null);
		mainPanel.setBackground(Frame.colorEventary);
	    mainPanel.setBounds(0,0,Frame.widthMainPanel, Frame.heightScreen);

		secondaryPanel = new JPanel();
		secondaryPanel.setBounds(Frame.widthMainPanel,0,Frame.widthScreen-Frame.widthMainPanel, Frame.heightScreen);
		secondaryPanel.setBackground(Color.WHITE);


		JButton bouton = new EventaryButton("Quitter");
		bouton.setBounds((int) (Frame.widthMainPanel/2 - Frame.widthButton/2),(int) (Frame.heightScreen*.87),Frame.widthButton,Frame.heightButton);
		//bouton.addActionListener(new ButtonDisconnection(this));
		mainPanel.add(bouton);
	    JLabel labelConnected = new JLabel("Welcome Home!");
	    secondaryPanel.add(labelConnected);
		//this.getContentPane().add(mainPanel,BorderLayout.WEST);
		//this.getContentPane().add(secondaryPanel,BorderLayout.CENTER);
	    this.setVisible(true);
	}
}
