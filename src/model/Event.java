/*
 * 
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import database.EventDAO;
import database.ParticipationDAO;
import database.WaitingDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Event.
 */
public class Event extends Observable{

	/** The id. */
	int id;

	/** The title. */
	String title;

	/** The description. */
	String description;

	/** The create date. */
	Date createDate;

	/** The start date. */
	Date startDate;

	/** The end date. */
	Date endDate;

	/** The modif date. */
	Date modifDate;

	/** The cancel date. */
	Date cancelDate;	

	/** The max nb participant. */
	int maxNbParticipant;

	/** The organizer. */
	User organizer;

	/** The organization. */
	Organization organization;

	/** The room. */
	Room room;

	/** The address. */
	String address;

	/** The liste participants. */
	List<User> listeParticipants = new ArrayList<User>();

	/** The liste attente. */
	List<User> listeAttente = new ArrayList<User>();

	/**
	 * Instantiates a new event.
	 */
	public Event() {	//Constructeur vide
	}

	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param title the title
	 * @param description the description
	 * @param createDate the create date
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param modifDate the modif date
	 * @param cancelDate the cancel date
	 * @param maxNbParticipant the max nb participant
	 * @param organizer the organizer
	 * @param organization the organization
	 * @param room the room
	 * @param address the address
	 * @param listeParticipants the liste participants
	 * @param listeAttente the liste attente
	 */
	public void init(int id, String title, String description, Date createDate, Date startDate, Date endDate,
			Date modifDate, Date cancelDate, int maxNbParticipant, User organizer, Organization organization, Room room,
			String address, List<User> listeParticipants, List<User> listeAttente) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifDate = modifDate;
		this.cancelDate = cancelDate;
		this.maxNbParticipant = maxNbParticipant;
		this.organizer = organizer;
		this.organization = organization; //null si Event cree par un simple User
		this.room = room;
		this.address = address;
		this.listeParticipants = listeParticipants;
		this.listeAttente = listeAttente;
	}

	/**
	 * Creates the event.
	 *
	 * @param title the title
	 * @param description the description
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param maxNbParticipant the max nb participant
	 * @param organizer the organizer
	 * @param organization the organization
	 * @param room the room
	 * @param address the address
	 * @return true, if successful
	 */
	//Return True si événement bien créé et False si problème à la création
	public static boolean createEvent(String title, String description, Date startDate, Date endDate, 
			int maxNbParticipant, User organizer, Organization organization, Room room, String address){
		return EventDAO.insert(title, description, startDate, endDate, maxNbParticipant, organizer, organization, room, address);
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the modif date.
	 *
	 * @return the modif date
	 */
	public Date getModifDate() {
		return modifDate;
	}

	/**
	 * Sets the modif date.
	 *
	 * @param modifDate the new modif date
	 */
	public void setModifDate(Date modifDate) {
		this.modifDate = modifDate;
	}

	/**
	 * Gets the cancel date.
	 *
	 * @return the cancel date
	 */
	public Date getCancelDate() {
		return cancelDate;
	}

	/**
	 * Sets the cancel date.
	 *
	 * @param cancelDate the new cancel date
	 */
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	/**
	 * Gets the max nb participant.
	 *
	 * @return the max nb participant
	 */
	public int getMaxNbParticipant() {
		return maxNbParticipant;
	}

	/**
	 * Sets the max nb participant.
	 *
	 * @param maxNbParticipant the new max nb participant
	 */
	public void setMaxNbParticipant(int maxNbParticipant) {
		this.maxNbParticipant = maxNbParticipant;
	}

	/**
	 * Gets the organizer.
	 *
	 * @return the organizer
	 */
	public User getOrganizer() {
		return organizer;
	}

	/**
	 * Sets the organizer.
	 *
	 * @param organizer the new organizer
	 */
	public void setOrganizer(User organizer) {
		this.organizer = organizer;
	}

	/**
	 * Gets the organization.
	 *
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * Sets the organization.
	 *
	 * @param organization the new organization
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	/**
	 * Gets the room.
	 *
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the room .
	 *
	 * @param room the new room
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the liste participants.
	 *
	 * @return the liste participants
	 */
	public List<User> getListeParticipants() {
		return listeParticipants;
	}

	/**
	 * Sets the liste participants.
	 *
	 * @param listeParticipants the new liste participants
	 */
	public void setListeParticipants(List<User> listeParticipants) {
		this.listeParticipants = listeParticipants;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Gets the liste attente.
	 *
	 * @return the liste attente
	 */
	public List<User> getListeAttente() {
		return listeAttente;
	}

	/**
	 * Sets the liste attente.
	 *
	 * @param listeAttente the new liste attente
	 */
	public void setListeAttente(List<User> listeAttente) {
		this.listeAttente = listeAttente;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Removes the event.
	 *
	 * @param remover the remover
	 */
	public void removeEvent(User remover){
		if(canRemove(remover)){	//Si l'evenement peut être supprimé par l'utilisateur
			// On notifie les participants et ceux en liste d'attente
			for(User participant : listeParticipants) {
				participant.addNotification("L'événement \" " + this.title + " \", auquel vous participiez, a été supprimé");
			}

			for(User attente : listeAttente){
				attente.addNotification("L'événement \" " + this.title + " \", auquel vous etiez en liste d'attente, a été supprimé");
			}

			EventDAO.delete(this.getId());

			if(remover.getModerator() == true && remover.getLogin() != this.organizer.getLogin()){	//Si c'est un modérateur qui supprime l'événement
				//alors il peut laisser un message à l'organisateur
				//à modifier pour que notifie un message à l'organisateur

				if (this.getOrganization() == null) {// si event au nom d'un utilisateur et qu'il est l'organisateur
					if(remover == this.organizer){
						this.organizer.addNotification("Le modérateur " + remover.getLogin() + " a supprimé votre événement '"+ this.getTitle() +"' :" + remover.message());
					}
				}
				else { // event au nom d'une orga, on l'envoi aussi au membre organizateur et au reponsable de l'orga
					this.organizer.addNotification("Le modérateur " + remover.getLogin() + " a supprimé votre événement '"+ this.getTitle() +"' :" + remover.message());
					this.organization.getInCharge().addNotification("Le modérateur " + remover.getLogin() + " a supprimé votre événement '"+ this.getTitle() +"' :" + remover.message());
				}
			}
		}
	}

	/**
	 * Can remove.
	 *
	 * @param remover the remover
	 * @return true, if successful
	 */
	public boolean canRemove(User remover){
		boolean ret = false;

		// si event au nom d'un utilisateur et qu'il est l'organisateur
		if (this.getOrganization() == null) {
			if(remover == this.organizer){
				ret = true;
			}
		}
		// si modérateur
		else if (remover.getModerator()){ 
			ret = true;
		}
		// si membre de l'orga qui organise l'event
		else if (remover.isInOrga(this.getOrganization())) {
			ret = true;
		}

		return ret;
	}

	/**
	 * Adds the participant.
	 *
	 * @param newParticipant the new participant
	 * @return true, if successful
	 */
	public boolean addParticipant(User newParticipant){
		// Si il y a encore de la place, on ajoute l'utilisateur en tant que participant
		if(this.listeParticipants.size() < this.maxNbParticipant){
			ParticipationDAO.insert(newParticipant.getLogin(), this.id);
			this.setListeParticipants(ParticipationDAO.eventParticipants(this.id));
			return true;
		}
		// Sinon, on l'ajoute dans la liste d'attente
		else{
			WaitingDAO.insert(newParticipant.getLogin(), this.id);
			this.setListeAttente(WaitingDAO.waitingsForAnEvent(this.id));
			return false;
		}
	}

	/**
	 * Removes the participant.
	 *
	 * @param participant the participant
	 * @return true, if successful
	 */
	public boolean removeParticipant(User participant){
		boolean trouve = false;

		for(User user : this.getListeParticipants()){ //parcours de la liste pricipale
			if(participant.getLogin().equals(user.getLogin())){ // si l'utilisateur est sur liste pricipale
				ParticipationDAO.delete(participant.getLogin(), this.id);
				trouve = true;
				break;
			}
		}

		if (!trouve) { // si l'utilisateur n'est pas sur la liste principale, parcours de la liste d'attente
			for(User user : this.getListeAttente()){
				if(participant.getLogin().equals(user.getLogin())){ // si l'utilisateur est sur liste d'attente
					WaitingDAO.delete(participant.getLogin(), this.id);
					break;
				}
			}
		}

		//maj des listes des participations
		this.setListeParticipants(ParticipationDAO.eventParticipants(this.id));
		this.setListeAttente(WaitingDAO.waitingsForAnEvent(this.id));

		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", createDate=" + createDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", modifDate=" + modifDate + ", cancelDate="
				+ cancelDate + ", maxNbParticipant=" + maxNbParticipant + ", organizer=" + organizer + ", organization="
				+ organization + ", room=" + room + ", address=" + address + ", listeParticipants=" + listeParticipants
				+ ", listeAttente=" + listeAttente + "]";
	}

}