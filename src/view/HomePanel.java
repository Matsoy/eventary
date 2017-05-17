package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
// TODO: Auto-generated Javadoc
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

	/** The main panel. */
	JPanel mainPanel;

	/** The left panel. */
	JPanel leftPanel;

	/** The frame. */
	Frame frame;

	/** The label error. */
	JLabel labelMessage;

	/** The button 'My Events'. */
	JButton myEventsButton;

	/** The Quit button. */
	JButton quitButton;

	/** The panel for the creation of a new event */
	JPanel newEventPanel;
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
		this.add(this.mainPanel,BorderLayout.CENTER);
		// sidebar de gauche
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(null);
		this.leftPanel.setBackground(Frame.colorEventary);
		this.leftPanel.setPreferredSize(new Dimension(Frame.sidebarWidth, Frame.heightScreen));
		ImageIcon profilImage = new ImageIcon("nerd.png");
		this.leftPanel.add(new JLabel(profilImage));

		myEventsButton = new EventaryMenuButton("Mes evenements");
		myEventsButton.setBounds((int) (Frame.sidebarWidth/2 - widthMenuButton/2),10,widthMenuButton,heightMenuButton);
		this.leftPanel.add(myEventsButton);
		quitButton = new EventaryButton("Quitter");
		quitButton.setBounds((int) (Frame.sidebarWidth/2 - Frame.widthButton/2),(int) (Frame.heightScreen*.87),Frame.widthButton,Frame.heightButton);
		this.leftPanel.add(quitButton);
		this.add(this.leftPanel,BorderLayout.WEST);
	}


	/**
	 * Affiche la liste des evenements de l'utilisateur courant
	 * ACTUELLEMENT affiche tous les evenements dans la BDD
	 *
	 * @param eventsList the events list
	 */
	public void displayEvents(ArrayList<model.Event> eventsList){
		//JPanel panelEvent;
		mainPanel.removeAll();
		newEventPanel = new JPanel();
		newEventPanel.setPreferredSize(new Dimension(800,160));
		newEventPanel.add(new JLabel("New Event"));
		ImageIcon icon = new ImageIcon("i.png");
		newEventPanel.setBorder(BorderFactory.createMatteBorder(10,20,5,1, icon));
		mainPanel.add(newEventPanel);
		for (model.Event event : eventsList) {
			JPanel panelEvent = new JPanel();
			panelEvent.setPreferredSize(new Dimension(800,160));
			panelEvent.add(new JLabel(event.getTitle()));
			panelEvent.add(new JLabel(event.getStartDate().toString()));
			mainPanel.add(panelEvent);
		}
		SwingUtilities.updateComponentTreeUI(mainPanel);
	}

	/**
	 * Gets the my events button.
	 *
	 * @return the my events button
	 */
	public JButton getMyEventsButton(){
		return myEventsButton;
	}

	public JButton getQuitButton(){
		return quitButton;
	}

	public void setConnectionPanel(){
		this.frame.setConnectionPanel();
	}
}