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
import javax.swing.JButton;
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
 * 
 * L’interface est constituée d’un formulaire où doit être renseigné :
 * <b>Le nom de l'événement</b>
 * <b>Les dates de début de fin</b>
 * <b>Une description</b>
 * <b>Le lieu</b>
 * Soit une adresse extérieure
 * Soit une salle d’une école
 * <b>Le nombre de participants maximum </b>
 * si l’événement à lieu à une adresse extérieure
 * sinon, si le l’événement a lieu dans une salle d’une école, alors le nombre maximum de participants est la capacité de la salle choisie 
 * <b>L’organisateur</b>
 * Soit au nom de l’utilisateur
 * Soit au nom d’une association dont l’utilisateur est membre
 * Soit au nom du département dont l’utilisateur est membre
 * L’utilisateur valide le formulaire de création en cliquant sur le bouton “Valider”.
 * Le formulaire de création d’un événement est alors vidé et l’événement créé devient alors visible par tout le monde.
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

	/** The school box model. */
	DefaultComboBoxModel<String> schoolBoxModel;

	/** The site box model. */
	DefaultComboBoxModel<String> siteBoxModel;

	/** The building box model. */
	DefaultComboBoxModel<String> buildingBoxModel;

	/** The room box model. */
	DefaultComboBoxModel<String> roomBoxModel;

	/** The asso box model. */
	DefaultComboBoxModel<String> assoBoxModel;

	/** The schools. */
	ArrayList<School> schools;

	/** The sites. */
	ArrayList<Site> sites;

	/** The buildings. */
	ArrayList<Building> buildings;

	/** The rooms. */
	ArrayList<Room> rooms;

	/** The assos. */
	ArrayList<Association> assos;

	/** The dpts. */
	ArrayList<Department> dpts;

	/** The create event button. */
	JButton createEventButton;

	/** The titre field. */
	JTextField titreField;

	/** The date debut field. */
	JTextField dateDebutField;

	/** The date fin field. */
	JTextField dateFinField;

	/** The lieu group. */
	ButtonGroup lieuGroup;

	/** The lieu field. */
	JTextField lieuField;

	/** The room box. */
	JComboBox<String> roomBox;

	/** The nb participants field. */
	JTextField nbParticipantsField;

	/** The organisateur group. */
	ButtonGroup organisateurGroup;

	/** The desc field. */
	JTextArea descField;

	/** The asso box. */
	JComboBox<String> assoBox;


	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	CreateEventPanel(Frame frame){
		this.frame = frame;
		this.createEventButton = new EventaryButton(new Color(135, 233, 144)); 
	}



	/**
	 * Gets the frame.
	 *
	 * @return the frame
	 */
	public Frame getFrame() {
		return frame;
	}



	/**
	 * Gets the titre field.
	 *
	 * @return the titre field
	 */
	public JTextField getTitreField() {
		return titreField;
	}



	/**
	 * Gets the date debut field.
	 *
	 * @return the date debut field
	 */
	public JTextField getDateDebutField() {
		return dateDebutField;
	}



	/**
	 * Gets the date fin field.
	 *
	 * @return the date fin field
	 */
	public JTextField getDateFinField() {
		return dateFinField;
	}



	/**
	 * Gets the lieu group.
	 *
	 * @return the lieu group
	 */
	public ButtonGroup getLieuGroup() {
		return lieuGroup;
	}



	/**
	 * Gets the lieu field.
	 *
	 * @return the lieu field
	 */
	public JTextField getLieuField() {
		return lieuField;
	}



	/**
	 * Gets the room box.
	 *
	 * @return the room box
	 */
	public JComboBox<String> getRoomBox() {
		return roomBox;
	}



	/**
	 * Gets the nb participants field.
	 *
	 * @return the nb participants field
	 */
	public JTextField getNbParticipantsField() {
		return nbParticipantsField;
	}



	/**
	 * Gets the organisateur group.
	 *
	 * @return the organisateur group
	 */
	public ButtonGroup getOrganisateurGroup() {
		return organisateurGroup;
	}



	/**
	 * Gets the desc field.
	 *
	 * @return the desc field
	 */
	public JTextArea getDescField() {
		return descField;
	}



	/**
	 * Gets the rooms.
	 *
	 * @return the rooms
	 */
	public ArrayList<Room> getRooms() {
		return rooms;
	}



	/**
	 * Gets the assos.
	 *
	 * @return the assos
	 */
	public ArrayList<Association> getAssos() {
		return assos;
	}



	/**
	 * Gets the dpts.
	 *
	 * @return the dpts
	 */
	public ArrayList<Department> getDpts() {
		return dpts;
	}



	/**
	 * Gets the asso box.
	 *
	 * @return the asso box
	 */
	public JComboBox<String> getAssoBox() {
		return assoBox;
	}



	/**
	 * Gets the creates the event button.
	 *
	 * @return the creates the event button
	 */
	public JButton getCreateEventButton() {
		return createEventButton;
	}


	/**
	 * Affiche le formulaire de creation d'un evenement.
	 *
	 * @param assosList the assos list
	 * @param dptsList the dpts list
	 * @param schoolsList the schools list
	 */
	public void displayForm(ArrayList<Association> assosList, ArrayList<Department> dptsList, ArrayList<School> schoolsList){
		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.createEventButton.setPreferredSize(new Dimension(widthMenuButton, heightMenuButton));
		this.schools = schoolsList;
		this.sites = new ArrayList<Site>();
		this.buildings = new ArrayList<Building>();
		this.rooms = new ArrayList<Room>();
		this.assos = assosList;
		this.dpts = dptsList;

		this.titreField = new JTextField(60);

		this.dateDebutField = new JTextField(20);

		this.dateFinField = new JTextField(20);

		this.lieuGroup = new ButtonGroup();
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
		this.roomBox = new EventaryComboBox<String>();
		roomBoxModel = new DefaultComboBoxModel<String>();
		roomBoxModel.addElement("< Salle >");
		roomBox.setModel(roomBoxModel);
		this.lieuField = new JTextField(31);

		this.nbParticipantsField = new JTextField(5);

		this.organisateurGroup = new ButtonGroup();
		JRadioButton meButton = new JRadioButton("Moi");
		meButton.setSelected(true);
		JRadioButton dptButton = new JRadioButton("Le département: "+dpts.get(0).getName());
		JRadioButton assoButton = new JRadioButton("Une association");
		this.assoBox = new EventaryComboBox<String>();
		assoBoxModel = new DefaultComboBoxModel<String>();
		assoBoxModel.addElement("< Association >");
		for (int i = 0; i < assos.size(); i++) {
			assoBoxModel.addElement(assos.get(i).getName());
		}
		assoBox.setModel(assoBoxModel);
		organisateurGroup.add(meButton);
		organisateurGroup.add(dptButton);
		organisateurGroup.add(assoButton);

		descField = new JTextArea(5, 60);
		JScrollPane descScroll = new JScrollPane(descField);

		this.add(Box.createRigidArea(new Dimension(0,5)));

		JPanel newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(800,30));
		newPan.add(new JLabel("Créer un événement"));
		this.add(newPan);
		this.add(Box.createRigidArea(new Dimension(0,20)));

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

		this.add(Box.createRigidArea(new Dimension(0,20)));

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

		this.add(Box.createRigidArea(new Dimension(0,20)));

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

		this.add(Box.createRigidArea(new Dimension(0,20)));

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
			@SuppressWarnings("deprecation")
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
					nbParticipantsField.enable();
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
			@SuppressWarnings("deprecation")
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
					nbParticipantsField.enable();
				}

				roomBoxModel = new DefaultComboBoxModel<String>();
				roomBoxModel.addElement("< Salle >");
				roomBox.setModel(roomBoxModel);

			}
		});
		jp2.add(buildingBox);
		// quand sélection d'un bâtiment
		buildingBox.addItemListener(new ItemListener() {
			@SuppressWarnings("deprecation")
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
					nbParticipantsField.enable();
				}
			}
		});
		jp2.add(roomBox);
		// quand sélection d'une salle
		roomBox.addItemListener(new ItemListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void itemStateChanged(ItemEvent e) {
				if ((e.getStateChange() == ItemEvent.SELECTED) && (roomBox.getSelectedIndex() > 0)) {
					nbParticipantsField.setText( String.valueOf(rooms.get(roomBox.getSelectedIndex()-1).getNbPlaces()));
					nbParticipantsField.disable();
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

		this.add(Box.createRigidArea(new Dimension(0,20)));

		// ######################################## nb de participants maximum
		JPanel nbParticipantsMAxPan = new JPanel();
		nbParticipantsMAxPan.setBackground(Color.WHITE);
		nbParticipantsMAxPan.setMaximumSize(new Dimension(800,30));
		nbParticipantsMAxPan.setLayout(new BoxLayout(nbParticipantsMAxPan, BoxLayout.X_AXIS));
		this.add(nbParticipantsMAxPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,30));
		newPan.add(new JLabel("Nb participants"));
		nbParticipantsMAxPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(100,30));
		newPan.add(nbParticipantsField);
		nbParticipantsMAxPan.add(newPan);

		newPan = new JPanel();
		newPan.setMaximumSize(new Dimension(600,30));
		nbParticipantsMAxPan.add(newPan);

		this.add(Box.createRigidArea(new Dimension(0,20)));

		// ######################################## organisateur
		JPanel organisateurPan = new JPanel();
		organisateurPan.setBackground(Color.WHITE);
		organisateurPan.setMaximumSize(new Dimension(800,80));
		organisateurPan.setLayout(new BoxLayout(organisateurPan, BoxLayout.X_AXIS));
		this.add(organisateurPan);

		newPan = new JPanel();
		newPan.setBackground(Frame.colorEventary);
		newPan.setMaximumSize(new Dimension(100,80));
		newPan.add(new JLabel("Organisateur"));
		organisateurPan.add(newPan);

		newPan = new JPanel(new BorderLayout());
		newPan.setMaximumSize(new Dimension(700,80));
		organisateurPan.add(newPan);



		JPanel cardPanel_orga, jp1_orga, jp2_orga, buttonPanel_orga, uselessPanel_orga;
		CardLayout cardLayout_orga = new CardLayout();

		cardPanel_orga = new JPanel();
		buttonPanel_orga = new JPanel();
		uselessPanel_orga = new JPanel();

		cardPanel_orga.setLayout(cardLayout_orga);
		jp1_orga = new JPanel();
		jp2_orga = new JPanel();
		jp2_orga.add(assoBox);

		cardPanel_orga.add(jp1_orga, "1");
		cardPanel_orga.add(jp2_orga, "2");
		meButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout_orga.show(cardPanel_orga, "1");
			}
		});
		dptButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout_orga.show(cardPanel_orga, "1");
			}
		});
		assoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cardLayout_orga.show(cardPanel_orga, "2");
			}
		});
		buttonPanel_orga.add(meButton);
		buttonPanel_orga.add(dptButton);
		buttonPanel_orga.add(assoButton);
		newPan.add(cardPanel_orga, BorderLayout.CENTER);
		newPan.add(buttonPanel_orga, BorderLayout.NORTH);
		newPan.add(uselessPanel_orga, BorderLayout.SOUTH);

		this.add(Box.createRigidArea(new Dimension(0,20)));

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

		this.add(Box.createRigidArea(new Dimension(0,20)));

		this.add(createEventButton);

	}
}