/*
 * 
 */
package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import database.BuildingDAO;
import database.RoomDAO;
import database.SiteDAO;
import model.Association;
import model.Building;
import model.Department;
import model.Room;
import model.School;
import model.Site;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateEventPanel.
 */
public class CreateEventPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;


	/** The frame. */
	Frame frame;

	DefaultComboBoxModel<String> schoolBoxModel;

	DefaultComboBoxModel<String> siteBoxModel;

	DefaultComboBoxModel<String> buildingBoxModel;

	DefaultComboBoxModel<String> roomBoxModel;

	ArrayList<School> schools;

	ArrayList<Site> sites;

	ArrayList<Building> buildings;

	ArrayList<Room> rooms;

	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	CreateEventPanel(Frame frame){
		this.frame = frame;
	}


	/**
	 * Affiche le formulaire de creation d'un evenement.
	 */
	public void displayForm(ArrayList<Association> assos, ArrayList<Department> dpts, ArrayList<School> schoolsList){
		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.schools = schoolsList;
		this.sites = new ArrayList<Site>();
		this.buildings = new ArrayList<Building>();
		this.rooms = new ArrayList<Room>();

		JTextField titreField = new JTextField(60);
		JTextField dateDebutField = new JTextField(20);
		JTextField dateFinField = new JTextField(20);
		ButtonGroup lieuGroup = new ButtonGroup();
		JRadioButton addressButton = new JRadioButton("Adresse extérieure");
		addressButton.setSelected(true);
		JRadioButton schoolButton = new JRadioButton("Dans une école");
		lieuGroup.add(addressButton);
		lieuGroup.add(schoolButton);
		JComboBox<String> schoolBox = new EventaryComboBox<String>();
		schoolBoxModel = new DefaultComboBoxModel<String>();
		schoolBoxModel.addElement("< Ecole >");
		for (int i = 0; i < schools.size(); i++) {
			schoolBoxModel.addElement(schools.get(i).getName());
		}
		schoolBox.setModel(schoolBoxModel);
		JComboBox<String> siteBox = new EventaryComboBox<String>();
		siteBoxModel = new DefaultComboBoxModel<String>();
		siteBoxModel.addElement("< Site >");
		siteBox.setModel(siteBoxModel);
		JComboBox<String> buildingBox = new EventaryComboBox<String>();
		buildingBoxModel = new DefaultComboBoxModel<String>();
		buildingBoxModel.addElement("< Bâtiment >");
		buildingBox.setModel(buildingBoxModel);
		JComboBox<String> roomBox = new EventaryComboBox<String>();
		roomBoxModel = new DefaultComboBoxModel<String>();
		roomBoxModel.addElement("< Salle >");
		roomBox.setModel(roomBoxModel);
		JTextField lieuField = new JTextField(31);
		JTextField organisateurField = new JTextField();
		JTextArea descField = new JTextArea(5, 60);
		JScrollPane descScroll = new JScrollPane(descField);


		this.add(Box.createRigidArea(new Dimension(0,5)));

		JPanel newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(800,30));
		newPan.add(new JLabel("Créer un événement"));
		this.add(newPan);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// ######################################## titre
		JPanel titrePan = new JPanel();
		titrePan.setBackground(Color.WHITE);
		titrePan.setMaximumSize(new Dimension(800,30));
		titrePan.setLayout(new BoxLayout(titrePan, BoxLayout.X_AXIS));
		this.add(titrePan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,30));
		newPan.add(new JLabel("Titre"));
		titrePan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(700,30));
		newPan.add(titreField);
		titrePan.add(newPan);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// ######################################## Date de début
		JPanel dateDebutPan = new JPanel();
		dateDebutPan.setBackground(Color.WHITE);
		dateDebutPan.setMaximumSize(new Dimension(800,30));
		dateDebutPan.setLayout(new BoxLayout(dateDebutPan, BoxLayout.X_AXIS));
		this.add(dateDebutPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,30));
		newPan.add(new JLabel("Date de début"));
		dateDebutPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(260,30));
		newPan.add(dateDebutField);
		dateDebutPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(120,30));
		newPan.add(new JLabel("jj/MM/aaaa hh:mm"));
		dateDebutPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(320,30));
		dateDebutPan.add(newPan);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// ######################################## date de fin
		JPanel dateFinPan = new JPanel();
		dateFinPan.setBackground(Color.WHITE);
		dateFinPan.setMaximumSize(new Dimension(800,30));
		dateFinPan.setLayout(new BoxLayout(dateFinPan, BoxLayout.X_AXIS));
		this.add(dateFinPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,30));
		newPan.add(new JLabel("Date de fin"));
		dateFinPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(260,30));
		newPan.add(dateFinField);
		dateFinPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(120,30));
		newPan.add(new JLabel("jj/MM/aaaa hh:mm"));
		dateFinPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(320,30));
		dateFinPan.add(newPan);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// ######################################## lieu
		JPanel lieuPan = new JPanel();
		lieuPan.setBackground(Color.WHITE);
		lieuPan.setMaximumSize(new Dimension(800,80));
		lieuPan.setLayout(new BoxLayout(lieuPan, BoxLayout.X_AXIS));
		this.add(lieuPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,80));
		newPan.add(new JLabel("Lieu"));
		lieuPan.add(newPan);

		newPan = new JPanel(new BorderLayout());
		newPan.setMaximumSize(new Dimension(700,80));
		lieuPan.add(newPan);



		JPanel cardPanel, jp1, jp2, buttonPanel, uselessPanel;
		CardLayout cardLayout = new CardLayout();

		cardPanel = new JPanel();
		buttonPanel = new JPanel();
		uselessPanel = new JPanel();

		cardPanel.setLayout(cardLayout);
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp1.add(lieuField);
		jp2.add(schoolBox);
		// quand sélection d'une école
		schoolBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (schoolBox.getSelectedIndex() > 0)) {
					siteBoxModel = new DefaultComboBoxModel<String>();
					siteBoxModel.addElement("< Site >");
					sites = SiteDAO.findSchoolSites((schools.get(schoolBox.getSelectedIndex()-1)).getId());
					for (int i = 0; i < sites.size(); i++) {
						siteBoxModel.addElement(sites.get(i).getName());
					}
					siteBox.setModel(siteBoxModel);					
				}
				else {
					siteBoxModel = new DefaultComboBoxModel<String>();
					siteBoxModel.addElement("< Site >");
					siteBox.setModel(siteBoxModel);		
				}

				buildingBoxModel = new DefaultComboBoxModel<String>();
				buildingBoxModel.addElement("< Bâtiment >");
				buildingBox.setModel(buildingBoxModel);

				roomBoxModel = new DefaultComboBoxModel<String>();
				roomBoxModel.addElement("< Salle >");
				roomBox.setModel(roomBoxModel);
			}
		});
		jp2.add(siteBox);
		// quand sélection d'un site
		siteBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (siteBox.getSelectedIndex() > 0)) {
					buildingBoxModel = new DefaultComboBoxModel<String>();
					buildingBoxModel.addElement("< Bâtiment >");
					buildings = BuildingDAO.findSiteBuildings((sites.get(siteBox.getSelectedIndex()-1)).getId());
					for (int i = 0; i < buildings.size(); i++) {
						buildingBoxModel.addElement(buildings.get(i).getName());
					}
					buildingBox.setModel(buildingBoxModel);
				}
				else {
					buildingBoxModel = new DefaultComboBoxModel<String>();
					buildingBoxModel.addElement("< Bâtiment >");
					buildingBox.setModel(buildingBoxModel);
				}

				roomBoxModel = new DefaultComboBoxModel<String>();
				roomBoxModel.addElement("< Salle >");
				roomBox.setModel(roomBoxModel);
			}
		});
		jp2.add(buildingBox);
		// quand sélection d'un bâtiment
		buildingBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (buildingBox.getSelectedIndex() > 0)) {
					roomBoxModel = new DefaultComboBoxModel<String>();
					roomBoxModel.addElement("< Salle >");
					rooms = RoomDAO.findBuildingRooms((buildings.get(buildingBox.getSelectedIndex()-1)).getId());
					for (int i = 0; i < rooms.size(); i++) {
						roomBoxModel.addElement(rooms.get(i).getName());
					}
					roomBox.setModel(roomBoxModel);
				}
				else {
					roomBoxModel = new DefaultComboBoxModel<String>();
					roomBoxModel.addElement("< Salle >");
					roomBox.setModel(roomBoxModel);
				}
			}
		});
		jp2.add(roomBox);
		// quand sélection d'une salle
		roomBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (roomBox.getSelectedIndex() > 0)) {
					System.out.println("Salle sélectionnée = "+e.getItem());
				}
			}
		});
		cardPanel.add(jp1, "1");
		cardPanel.add(jp2, "2");
		addressButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "1");
			}
		});
		schoolButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "2");
			}
		});
		buttonPanel.add(addressButton);
		buttonPanel.add(schoolButton);
		newPan.add(cardPanel, BorderLayout.CENTER);
		newPan.add(buttonPanel, BorderLayout.NORTH);
		newPan.add(uselessPanel, BorderLayout.SOUTH);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// ######################################## organisateur
		JPanel organisateurPan = new JPanel();
		organisateurPan.setBackground(Color.WHITE);
		organisateurPan.setMaximumSize(new Dimension(800,60));
		organisateurPan.setLayout(new BoxLayout(organisateurPan, BoxLayout.X_AXIS));
		this.add(organisateurPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,60));
		newPan.add(new JLabel("Organisateur"));
		organisateurPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(700,60));
		newPan.add(organisateurField);
		organisateurPan.add(newPan);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// ######################################## description
		JPanel descPan = new JPanel();
		descPan.setBackground(Color.WHITE);
		descPan.setMaximumSize(new Dimension(800,95));
		descPan.setLayout(new BoxLayout(descPan, BoxLayout.X_AXIS));
		this.add(descPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,95));
		newPan.add(new JLabel("Description"));
		descPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(700,95));
		newPan.add(descScroll);
		descPan.add(newPan);

		this.add(Box.createRigidArea(new Dimension(0,10)));

	}
}