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

import model.Context;
import model.Event;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class DisplayEventPanel.
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

	JLabel participantsListLabel;

	JLabel waitingsListLabel;

	JPanel participantsListPanel;

	JPanel waitingsListPanel;


	/**
	 * Instantiates a new home panel.
	 *
	 * @param frame the frame
	 */
	EventPanel(Frame frame){
		super();
		this.frame = frame;

	}


	/**
	 * Adapt event.
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

		this.suppressionEvent = new JButton();
		this.suppressionEvent.setMaximumSize(new Dimension(800,30));
		this.suppressionEvent.setBackground(new Color(253,46,46));
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

		JPanel infosPanDesc = new JPanel();
		infosPanDesc.setMaximumSize(new Dimension(800,100));
		infosPanDesc.add(this.infosDesc);

		this.infosPan.add(infosPanTitre);
		this.dateFormat = new SimpleDateFormat("EEEE dd MMM yyyy - kk:mm", Locale.getDefault());
		this.infosPan.add(infosPanDate);
		this.infosPan.add(infosPanAdresse);
		this.infosPan.add(infosPanDesc);

		this.add(this.infosPan);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		// Les boutons d'Inscription/Desinscription
		this.inscriptionPan = new JPanel();
		this.inscriptionPan.setMaximumSize(new Dimension(800,30));
		this.inscriptionPan.setLayout(new BoxLayout(inscriptionPan, BoxLayout.X_AXIS));
		this.inscription = new JButton();
		this.inscription.setBackground(new Color(139,233,120));
		this.inscription.setMaximumSize(new Dimension(800,30));
		this.inscriptionPan.add(this.inscription);
		this.add(this.inscriptionPan);

		this.desinscriptionPan = new JPanel();
		this.desinscriptionPan.setMaximumSize(new Dimension(800,30));
		this.desinscriptionPan.setLayout(new BoxLayout(desinscriptionPan, BoxLayout.X_AXIS));
		this.desinscription = new JButton();
		this.desinscription.setBackground(new Color(253,46,46));
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

		// Rendre visible ou non le bouton supprimer selon le currentUser
		if(this.event.canRemove(context.getCurrentUser())){
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
		System.out.println(trouve);
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
			this.infosAdresse.setText("Salle : "+room+"     Bâtiment : "+batiment+"     Campus : "+site+"     Ecole : "+ecole);
		}
		this.infosDesc.setText(this.event.getDescription());

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