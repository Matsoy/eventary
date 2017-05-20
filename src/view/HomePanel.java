package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The Class HomePanel.
 */
public class HomePanel extends JPanel{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;

	/** The frame. */
	Frame frame;

	/** The container central. */
	Container containerCentral;

	/** The left panel. */
	JPanel leftPanel;

	/** The label error. */
	JLabel labelMessage;

	/** The button 'All Events'. */
	JButton allEventsButton;

	/** The button 'My Events'. */
	JButton myEventsButton;

	/** The create event button. */
	JButton createEventButton;

	/** The Quit button. */
	JButton quitButton;

	/** The scroll main panel. */
	JScrollPane scrollMainPanel;

	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	HomePanel(Frame frame){
		this.frame = frame;
		this.setLayout(new BorderLayout());

		// #################### sidebar de gauche
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(null);
		this.leftPanel.setBackground(Frame.colorEventary);
		this.leftPanel.setPreferredSize(new Dimension(Frame.sidebarWidth, Frame.heightScreen));
		ImageIcon profilImage = new ImageIcon("nerd.png");
		this.leftPanel.add(new JLabel(profilImage));
		// Tous les evenements
		allEventsButton = new EventaryMenuButton("Tous les evenements");
		allEventsButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),10,widthMenuButton,heightMenuButton);
		this.leftPanel.add(allEventsButton);
		// Mes evenements
		myEventsButton = new EventaryMenuButton("Mes evenements");
		myEventsButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),50,widthMenuButton,heightMenuButton);
		this.leftPanel.add(myEventsButton);
		// Creer un evenement
		createEventButton = new EventaryMenuButton("Creer un evenement");
		createEventButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),50,widthMenuButton,heightMenuButton);
		this.leftPanel.add(createEventButton);
		// Quitter
		quitButton = new EventaryButton("Quitter");
		quitButton.setBounds((int) (Frame.sidebarWidth/2 - Frame.widthButton/2),(int) (Frame.heightScreen*.87),Frame.widthButton,Frame.heightButton);
		this.leftPanel.add(quitButton);
		this.add(this.leftPanel,BorderLayout.WEST);	

		// #################### composant central
		// container central
		this.containerCentral = new Container();
		// on place la container dans une scroll bar 
		this.scrollMainPanel = new JScrollPane(this.containerCentral, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(this.scrollMainPanel,BorderLayout.CENTER);
	}

	// ###################################### GETTERS


	public Container getContainerCentral() {
		return containerCentral;
	}

	/**
	 * Gets the left panel.
	 *
	 * @return the left panel
	 */
	public JPanel getLeftPanel() {
		return leftPanel;
	}

	/**
	 * Gets the label message.
	 *
	 * @return the label message
	 */
	public JLabel getLabelMessage() {
		return labelMessage;
	}

	/**
	 * Gets the all events button.
	 *
	 * @return the all events button
	 */
	public JButton getAllEventsButton() {
		return allEventsButton;
	}

	/**
	 * Gets the my events button.
	 *
	 * @return the my events button
	 */
	public JButton getMyEventsButton() {
		return myEventsButton;
	}

	/**
	 * Gets the quit button.
	 *
	 * @return the quit button
	 */
	public JButton getQuitButton() {
		return quitButton;
	}
	
	public Frame getFrame() {
		return this.frame;
	}

	// ###################################### Switcher l'interface
	public void setContainerCentral(Container newContainer){
		this.remove(((BorderLayout) this.getLayout()).getLayoutComponent(BorderLayout.CENTER));
		this.containerCentral = new JScrollPane(newContainer, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(this.containerCentral, BorderLayout.CENTER);

	}
}