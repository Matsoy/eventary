package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class HomePanel.
 */
public class HomePanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The main panel. */
	JPanel mainPanel;
	
	/** The left panel. */
	JPanel leftPanel;
	
	/** The frame. */
	Frame frame;

	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	HomePanel(Frame frame){
		this.frame = frame;
		this.setLayout(new BorderLayout());

		// panel central
		this.mainPanel = new JPanel();
		this.mainPanel.setBackground(Color.WHITE);

		JLabel labelConnected = new JLabel("Welcome Home!");
		this.mainPanel.add(labelConnected);

		this.add(this.mainPanel,BorderLayout.CENTER);

		// sidebar de gauche
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(null);
		this.leftPanel.setBackground(Frame.colorEventary);
		this.leftPanel.setPreferredSize(new Dimension(Frame.sidebarWidth, Frame.heightScreen));

		JButton bouton = new EventaryButton("Quitter");
		bouton.setBounds((int) (Frame.sidebarWidth/2 - Frame.widthButton/2),(int) (Frame.heightScreen*.87),Frame.widthButton,Frame.heightButton);
		this.leftPanel.add(bouton);

		this.add(this.leftPanel,BorderLayout.WEST);
	}
}
