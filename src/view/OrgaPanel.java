package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.OrganizationDAO;
import model.Organization;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class OrgaPanel.
 * 
 * L’utilisateur peut consulter la liste des membres de l’organisation
 * Une liste déroulante pour ajouter un nouveau  est disponible quand l’organisation est une association.
 * Pour cela, l’utilisateur saisie l’identifiant du nouveau membre dans la liste déroulante et clique sur le bouton “Valider Inscription”.
 */
public class OrgaPanel extends JPanel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The frame. */
	Frame frame;

	/** The event. */
	Organization organisation;

	/** The orga name panel. */
	JPanel orgaNamePanel;

	/** The organisation name. */
	JLabel organisationName;

	/** The inscription pan. */
	JPanel inscriptionPan;

	/** The login box model. */
	DefaultComboBoxModel<String> loginBoxModel;

	/** The login box. */
	JComboBox<String> loginBox;

	/** The valider. */
	JButton valider;

	/** The liste pan. */
	JPanel listePan;

	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	public OrgaPanel(Frame frame){
		super();
		this.frame = frame;

		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(0,5)));

		// Le panel titre et son label
		this.orgaNamePanel = new JPanel();
		orgaNamePanel.setBackground(Frame.colorEventary);
		orgaNamePanel.setMaximumSize(new Dimension(800,30));
		this.organisationName = new JLabel("");
		this.orgaNamePanel.add(organisationName);
		this.add(orgaNamePanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Pour l'ajout d'un nouveau membre
		this.inscriptionPan = new JPanel();
		this.inscriptionPan.setBackground(Color.WHITE);
		this.inscriptionPan.setMaximumSize(new Dimension(800,30));
		this.inscriptionPan.setLayout(new BoxLayout(inscriptionPan, BoxLayout.X_AXIS));
		this.add(this.inscriptionPan);

		JPanel inscriptionTitrePan = new JPanel();
		inscriptionTitrePan.setBackground(Frame.colorEventary);
		inscriptionTitrePan.setMaximumSize(new Dimension(200,30));
		inscriptionTitrePan.add(new JLabel("Ajouter un nouveau membre"));
		inscriptionPan.add(inscriptionTitrePan);

		JPanel inscriptionBoxPan = new JPanel();
		inscriptionBoxPan.setMaximumSize(new Dimension(450,30));
		inscriptionBoxPan.setBackground(Color.WHITE);
		inscriptionBoxPan.add(new JLabel("Saisir Numéro Etudiant       "));
		this.loginBox = new EventaryComboBox<String>();
		this.loginBoxModel = new DefaultComboBoxModel<String>();
		this.loginBox.setEditable(true);
		inscriptionBoxPan.add(this.loginBox);
		inscriptionPan.add(inscriptionBoxPan);

		this.valider = new JButton();
		this.valider.setMaximumSize(new Dimension(150,30));
		this.valider.setBackground(new Color(139,233,120));
		this.inscriptionPan.add(this.valider);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Pour la liste des membres
		JPanel listeTitrePan = new JPanel();
		listeTitrePan.setBackground(Frame.colorEventary);
		listeTitrePan.setMaximumSize(new Dimension(800,30));
		listeTitrePan.add(new JLabel("Liste des Membres"));
		this.add(listeTitrePan);

		this.listePan = new JPanel();
		this.listePan.setMaximumSize(new Dimension(800,500));
		this.listePan.setLayout(new BoxLayout(this.listePan, BoxLayout.Y_AXIS));
		this.add(this.listePan);

	}


	/**
	 * Adapte le panel à l'Organization cliquée
	 *
	 * @param orga the orga
	 * @param listeEtu la liste des membres de l'Organization
	 */
	public void adaptOrga(Organization orga, List<User> listeEtu){
		this.organisation = orga;

		// On change le label titre selon l'organisation
		this.organisationName.setText(this.organisation.getName());

		// Pour le comboBox
		if(OrganizationDAO.getOrganizationType(orga.getId()).equals("asso")){
			this.inscriptionPan.setVisible(true);
			this.loginBoxModel.removeAllElements();
			this.loginBoxModel.addElement("");
			for(int i = 0; i < listeEtu.size(); i++){
				if(listeEtu.get(i).isInOrga(this.organisation) == false){
					loginBoxModel.addElement(listeEtu.get(i).getLogin());
				}
			}
			this.loginBox.setModel(loginBoxModel);
		} else {
			this.inscriptionPan.setVisible(false);
		}

		// Pour la liste des membres
		this.listePan.removeAll();
		for(User membre : this.organisation.getListeMembres()){
			JPanel membrePan = new JPanel();
			membrePan.setMaximumSize(new Dimension(800,25));
			membrePan.add(new JLabel(membre.getfName() + " " + membre.getlName() + " - " + membre.getLogin()));
			this.listePan.add(membrePan);
		}

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
	 * Gets the organisation.
	 *
	 * @return the organisation
	 */
	public Organization getOrganisation() {
		return organisation;
	}


	/**
	 * Gets the valider.
	 *
	 * @return the valider
	 */
	public JButton getValider() {
		return valider;
	}


	/**
	 * Gets the login box.
	 *
	 * @return the login box
	 */
	public JComboBox<String> getLoginBox() {
		return loginBox;
	}

}
