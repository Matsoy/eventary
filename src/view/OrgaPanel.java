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

import model.Organization;
import model.User;

public class OrgaPanel extends JPanel {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The frame. */
	Frame frame;

	/** The event. */
	Organization organisation;

	JPanel orgaNamePanel;

	JLabel organisationName;
	
	DefaultComboBoxModel<String> loginBoxModel;
	
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
		JPanel inscriptionPan = new JPanel();
		inscriptionPan.setBackground(Color.WHITE);
		inscriptionPan.setMaximumSize(new Dimension(800,30));
		inscriptionPan.setLayout(new BoxLayout(inscriptionPan, BoxLayout.X_AXIS));
		this.add(inscriptionPan);

		JPanel inscriptionTitrePan = new JPanel();
		inscriptionTitrePan.setBackground(Frame.colorEventary);
		inscriptionTitrePan.setMaximumSize(new Dimension(250,30));
		inscriptionTitrePan.add(new JLabel("Ajouter un nouveau membre"));
		inscriptionPan.add(inscriptionTitrePan);

		JPanel inscriptionBoxPan = new JPanel();
		inscriptionBoxPan.setMaximumSize(new Dimension(300,30));
		JComboBox<String> loginBox = new EventaryComboBox<String>();
		this.loginBoxModel = new DefaultComboBoxModel<String>();
		this.loginBoxModel.addElement("<Login Etudiant>");
		loginBox.setModel(loginBoxModel);
		loginBox.setEditable(true);
		inscriptionBoxPan.add(loginBox);
		inscriptionPan.add(inscriptionBoxPan);

		JButton valider = new JButton();
		valider.setMaximumSize(new Dimension(250,30));
		valider.setBackground(new Color(10,189,22));
		inscriptionPan.add(valider);

		this.add(Box.createRigidArea(new Dimension(0,10)));
		
		// Pour la liste des membres
		JPanel listeTitrePan = new JPanel();
		listeTitrePan.setBackground(Frame.colorEventary);
		listeTitrePan.setMaximumSize(new Dimension(800,30));
		listeTitrePan.add(new JLabel("Liste des Membres"));
		this.add(listeTitrePan);
		
		this.listePan = new JPanel();
		this.add(listePan);

	}

	public void adaptOrga(Organization orga, List<User> listeEtu){
		this.organisation = orga;

		// On change le label titre selon l'organisation
		this.organisationName.setText(this.organisation.getName());

		// Pour le comboBox
		this.loginBoxModel.removeAllElements();
		this.loginBoxModel.addElement("<Login Etudiant>");
		int i = 0;
		while(i < 5 && i < listeEtu.size()){
			if(listeEtu.get(i).isInAsso(this.organisation) == false){
				System.out.println(listeEtu.get(i).isInAsso(this.organisation));
				loginBoxModel.addElement(listeEtu.get(i).getLogin());
				i++;
			}
		}
		
		// Pour la liste des membres
		for(User membre : this.organisation.getListeMembres()){
				this.listePan.add(new JLabel(membre.getfName() + membre.getlName() + " - " + membre.getLogin()));
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
}
