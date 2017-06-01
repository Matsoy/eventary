/*
 * 
 */
package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Context;
import model.Event;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class DisplayEventPanel.
 * 
 * Cet interface détaille les différentes informations de l’événement:
 * <b>le titre<b>
 * <b>les dates de début et de fin<b>
 * <b>le lieu<b>
 * soit les informations de la salle 
 * soit l’adresse extérieure
 * <b>l’organisateur<b>
 * soit le nom de l’organisateur si l’événement a été créé au nom d’une personne
 * soit le nom de l’organisation si l’événement a été créé au nom d’une organisation ainsi que la personne responsable
 * <b>la description<b>
 * On peut y voir la liste des participants et la liste d’attente.
 * Si l’utilisateur n’est pas inscrit à l’événement, il peut alors s’y inscrire en cliquant sur le bouton “S’inscrire”. Si il est déjà inscrit, alors ce bouton d’inscription est remplacé par un bouton “Se désinscrire”
 * Un bouton “Supprimer cet Evenement”, pour supprimer l’événement peut être disponible si:
 * l’utilisateur est l’organisateur de l’événement
 * l’événement est organisé au nom d’une organisation dont l’utilisateur est membre
 * l’utilisateur est modérateur. Il peut d’ailleurs écrire un message qui sera envoyé sous forme de notification à l’organisateur de l’événement.
 */
public class EventPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant widthMenuButton. */
	static final int widthMenuButton = 200;

	/** The Constant heightMenuButton. */
	static final int heightMenuButton = 30;

	/** The frame. */
	Frame frame;

	/** The event. */
	Event event;

	/** The event title. */
	JLabel eventTitle;

	/** The panel suppression. */
	JPanel panelSuppression;

	/** The suppression event. */
	JButton suppressionEvent;

	/** The infos pan. */
	JPanel infosPan;

	/** The infos titre. */
	JLabel infosTitre;

	/** The infos date. */
	JLabel infosDate;

	/** The infos desc. */
	JLabel infosDesc;

	/** The infos adresse. */
	JLabel infosAdresse;

	/** The infos organizer. */
	JLabel infosOrganizer;

	/** The date format. */
	SimpleDateFormat dateFormat;

	/** The inscription pan. */
	JPanel inscriptionPan;

	/** The desinscription pan. */
	JPanel desinscriptionPan;

	/** The inscription. */
	JButton inscription;

	/** The desinscription. */
	JButton desinscription;

	/** The participants list label. */
	JLabel participantsListLabel;

	/** The waitings list label. */
	JLabel waitingsListLabel;

	/** The participants list panel. */
	JPanel participantsListPanel;

	/** The waitings list panel. */
	JPanel waitingsListPanel;

	/** The supp message field. */
	JTextField suppMessageField;


	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	EventPanel(Frame frame){
		super();
		this.frame = frame;

		this.suppressionEvent = new JButton();
		this.inscription = new JButton();
		this.desinscription = new JButton();

	}


	/**
	 * Gets the event.
	 *
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 * Gets the mess supp.
	 *
	 * @return the mess supp
	 */
	public JTextField getMessSupp(){
		return this.suppMessageField;
	}


	/**
	 * Gets the suppression event.
	 *
	 * @return the suppression event
	 */
	public JButton getSuppressionEvent() {
		return suppressionEvent;
	}


	/**
	 * Gets the inscription.
	 *
	 * @return the inscription
	 */
	public JButton getInscription() {
		return inscription;
	}


	/**
	 * Gets the desinscription.
	 *
	 * @return the desinscription
	 */
	public JButton getDesinscription() {
		return desinscription;
	}


	/**
	 * Adapte le panel à l'Event et au Context
	 *
	 * @param event the event
	 * @param context the context
	 */
	public void adaptEvent(Event event, Context context){
		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(Box.createRigidArea(new Dimension(0,5)));

		// le panel titre
		JPanel eventsPanel = new JPanel();
		eventsPanel.setBackground(Frame.colorEventary);
		eventsPanel.setMaximumSize(new Dimension(800,30));
		this.eventTitle = new JLabel("");
		eventsPanel.add(eventTitle);
		this.add(eventsPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Le bouton de Suppression
		this.panelSuppression = new JPanel();
		this.panelSuppression.setMaximumSize(new Dimension(800,30));
		this.panelSuppression.setLayout(new BoxLayout(panelSuppression, BoxLayout.X_AXIS));

		this.suppressionEvent.setMaximumSize(new Dimension(800,30));
		this.suppressionEvent.setBackground(new Color(253,58,58));
		this.panelSuppression.add(suppressionEvent);
		this.add(this.panelSuppression);

		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Le panel d'informartions/détails
		this.infosPan = new JPanel();
		this.infosPan.setMaximumSize(new Dimension(800,210));
		this.infosPan.setLayout(new BoxLayout(this.infosPan, BoxLayout.Y_AXIS));

		this.infosTitre = new JLabel("");
		this.infosDate = new JLabel("");
		this.infosAdresse = new JLabel("");
		this.infosOrganizer = new JLabel("");
		this.infosDesc = new JLabel("");

		JPanel infosPanTitre = new JPanel();
		infosPanTitre.setMaximumSize(new Dimension(800,50));
		infosPanTitre.add(this.infosTitre);

		JPanel infosPanDate = new JPanel();
		infosPanDate.setMaximumSize(new Dimension(800,30));
		infosPanDate.add(this.infosDate);

		JPanel infosPanAdresse = new JPanel();
		infosPanAdresse.setMaximumSize(new Dimension(800,30));
		infosPanAdresse.add(this.infosAdresse);

		JPanel infosPanOrganizer = new JPanel();
		infosPanOrganizer.setMaximumSize(new Dimension(800,30));
		infosPanOrganizer.add(this.infosOrganizer);

		JPanel infosPanDesc = new JPanel();
		infosPanDesc.setMaximumSize(new Dimension(800,100));
		infosPanDesc.add(this.infosDesc);

		this.infosPan.add(infosPanTitre);
		this.dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy - kk:mm", Locale.getDefault());
		this.infosPan.add(infosPanDate);
		this.infosPan.add(infosPanAdresse);
		this.infosPan.add(infosPanOrganizer);
		this.infosPan.add(infosPanDesc);

		this.add(this.infosPan);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Les boutons d'Inscription/Desinscription
		this.inscriptionPan = new JPanel();
		this.inscriptionPan.setMaximumSize(new Dimension(800,30));
		this.inscriptionPan.setLayout(new BoxLayout(inscriptionPan, BoxLayout.X_AXIS));

		this.inscription.setBackground(new Color(139,233,120));
		this.inscription.setMaximumSize(new Dimension(800,30));
		this.inscriptionPan.add(this.inscription);
		this.add(this.inscriptionPan);

		this.desinscriptionPan = new JPanel();
		this.desinscriptionPan.setMaximumSize(new Dimension(800,30));
		this.desinscriptionPan.setLayout(new BoxLayout(desinscriptionPan, BoxLayout.X_AXIS));

		this.desinscription.setBackground(new Color(253,58,58));
		this.desinscription.setMaximumSize(new Dimension(800,30));
		this.desinscriptionPan.add(this.desinscription);
		this.add(this.desinscriptionPan);
		this.add(Box.createRigidArea(new Dimension(0,10)));


		// Liste des participants titre
		JPanel listeTitrePan = new JPanel();
		listeTitrePan.setBackground(Frame.colorEventary);
		listeTitrePan.setMaximumSize(new Dimension(800,30));
		this.participantsListLabel = new JLabel("");
		listeTitrePan.add(this.participantsListLabel);
		this.add(listeTitrePan);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Liste des participants
		this.participantsListPanel = new JPanel();
		this.participantsListPanel.setMaximumSize(new Dimension(800,300));
		this.participantsListPanel.setLayout(new BoxLayout(this.participantsListPanel, BoxLayout.Y_AXIS));
		this.add(this.participantsListPanel);

		// Liste des users sur liset d'attente
		JPanel listeWTitrePan = new JPanel();
		listeWTitrePan.setBackground(Frame.colorEventary);
		listeWTitrePan.setMaximumSize(new Dimension(800,30));
		this.waitingsListLabel = new JLabel("");
		listeWTitrePan.add(this.waitingsListLabel);
		this.add(listeWTitrePan);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Liste des users en attente
		this.waitingsListPanel = new JPanel();
		this.waitingsListPanel.setMaximumSize(new Dimension(800,300));
		this.waitingsListPanel.setLayout(new BoxLayout(this.waitingsListPanel, BoxLayout.Y_AXIS));
		this.add(this.waitingsListPanel);

		// ################################################################################################################################
		// personnalisation du panel pour l'event
		// ################################################################################################################################

		this.event = event;

		suppMessageField = new JTextField("");
		JLabel labelSupp = new JLabel("  Votre message :  ");
		// Rendre visible ou non le bouton supprimer selon le currentUser
		if(this.event.canRemove(context.getCurrentUser())){
			if (context.getCurrentUser().getModerator()) { // si modérateur, alors il peut laisser un message 
				JPanel suppMessagePanel = new JPanel();
				suppMessagePanel.setMaximumSize(new Dimension(800,210));
				
				panelSuppression.add(labelSupp);	
				panelSuppression.add(this.suppMessageField);	
			}
			this.panelSuppression.setVisible(true);
		} else {
			this.panelSuppression.setVisible(false);
		}

		//Rendre visible l'inscription ou la desinscription selon le currentUser
		// Changer, faire en sorte d'appeler une fonction du model
		boolean trouve = false;

		for(User particip : this.event.getListeParticipants()){
			if(particip.getLogin().equals(context.getCurrentUser().getLogin())){
				trouve = true;
				this.eventTitle.setText(this.event.getTitle() + "    -    Vous Participez");
				this.inscriptionPan.setVisible(false);
				this.desinscriptionPan.setVisible(true);
			}
		}
		if(trouve == false) {
			for(User atta : this.event.getListeAttente()){
				if(atta.getLogin().equals(context.getCurrentUser().getLogin())){
					trouve = true;
					this.eventTitle.setText(this.event.getTitle() + "    -    Vous etes en Attente");
					this.inscriptionPan.setVisible(false);
					this.desinscriptionPan.setVisible(true);
				}
			}
		}

		if(trouve == false){
			this.eventTitle.setText(this.event.getTitle() + "    -    Vous n'etes pas Inscrit");
			this.inscriptionPan.setVisible(true);
			this.desinscriptionPan.setVisible(false);
		}

		this.infosTitre.setText(this.event.getTitle());
		if (this.event.getTitle().length()<=45){
			this.infosTitre.setFont(new Font("Impact", Font.PLAIN, 40));
		} else {
			this.infosTitre.setFont(new Font("Impact", Font.PLAIN, 30));
		}
		this.infosDate.setText(this.dateFormat.format(this.event.getStartDate()) + "     TO     " + this.dateFormat.format(this.event.getEndDate()));
		if(this.event.getAddress() != null) {
			this.infosAdresse.setText(this.event.getAddress());
		} else {
			String room = this.event.getRoom().getName();
			String batiment = this.event.getRoom().getBuilding().getName();
			String site = this.event.getRoom().getBuilding().getSite().getName();
			String ecole = this.event.getRoom().getBuilding().getSite().getSchool().getName();
			this.infosAdresse.setText("Salle : "+room+"     Bâtiment : "+batiment+"     Site : "+site+"     Ecole : "+ecole);
		}
		this.infosDesc.setText(this.event.getDescription());
		// si event au nom d'un utilisateur
		if (this.event.getOrganization() == null) {
			this.infosOrganizer.setText("Organisateur : "+this.event.getOrganizer().getfName() + " " + this.event.getOrganizer().getlName() + " - " + this.event.getOrganizer().getLogin());
		}
		else { // si event au nom d'une orga
			this.infosOrganizer.setText("Organisateur : "+this.event.getOrganization().getName() + " - Pour plus d'informations, merci de contacter "+this.event.getOrganization().getInCharge().getfName() + " " + this.event.getOrganization().getInCharge().getlName() + " - " + this.event.getOrganization().getInCharge().getLogin());
			infosPanOrganizer.add(infosOrganizer);
		}


		//Rendre visible l'inscription ou la desinscription selon le currentUser
		// Changer, faire en sorte d'appeler une fonction du model


		this.participantsListLabel.setText("Liste des Participants (" + this.event.getListeParticipants().size() + " sur "+this.event.getMaxNbParticipant()+")");

		if (this.event.getListeParticipants().size() == 0) {
			JPanel participantPan = new JPanel();
			participantPan.setMaximumSize(new Dimension(800,25));
			participantPan.add(new JLabel(""));
			this.participantsListPanel.add(participantPan);
		}

		for(User participantUser : this.event.getListeParticipants()){
			JPanel participantPan = new JPanel();
			participantPan.setMaximumSize(new Dimension(800,25));
			participantPan.add(new JLabel(participantUser.getfName() + " " + participantUser.getlName() + " - " + participantUser.getLogin()));
			this.participantsListPanel.add(participantPan);
		}

		this.waitingsListLabel.setText("Liste d'attente (" + this.event.getListeAttente().size()+")");

		if (this.event.getListeAttente().size() == 0) {
			JPanel waitingPan = new JPanel();
			waitingPan.setMaximumSize(new Dimension(800,25));
			waitingPan.add(new JLabel(""));
			this.waitingsListPanel.add(waitingPan);
		}

		for(User waitingUser : this.event.getListeAttente()){
			JPanel waitingPan = new JPanel();
			waitingPan.setMaximumSize(new Dimension(800,25));
			waitingPan.add(new JLabel(waitingUser.getfName() + " " + waitingUser.getlName() + " - " + waitingUser.getLogin()));
			this.waitingsListPanel.add(waitingPan);
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