package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.EventDAO;
import database.ParticipationDAO;
import database.WaitingDAO;

/**
 * The Class Event.
 */
public class Event {

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

	List<User> listeParticipants = new ArrayList<User>();
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
	 */
	public void init(int id, String title, String description, Date createDate, Date startDate, Date endDate,
			Date modifDate, Date cancelDate, int maxNbParticipant, User organizer, Organization organization, Room room,
			String address) {
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

	public List<User> getListeParticipants() {
		return listeParticipants;
	}

	public void setListeParticipants(List<User> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}

	public List<User> getListeAttente() {
		return listeAttente;
	}

	public void setListeAttente(List<User> listeAttente) {
		this.listeAttente = listeAttente;
	}
	
	public static void removeEvent(User remover, Event eventToDelete){	// Prévoir qu'une orga peut supprimer un event
		if(remover == eventToDelete.getOrganizer()){	//Si un organisateur supprimer son événement
			EventDAO.delete(eventToDelete.getId());
		} else if(remover.getModerator() == true){	// Si un modérateur supprime un événement
			EventDAO.delete(eventToDelete.getId());
			System.out.println("Suppression de l'event par le modérateur " + remover.getLogin());
		}
	}
	
	public void addParticipant(User newParticipant){
		// Si il y a encore de la place, on ajoute l'utilisateur en tant que participant
		if(this.listeParticipants.size() < this.maxNbParticipant){
			ParticipationDAO.insert(newParticipant.getLogin(), this.id);
			this.listeParticipants = ParticipationDAO.participationsInAnEvent(this.id);	
		}
		// Sinon, on l'ajoute dans la liste d'attente
		else{
			WaitingDAO.insert(newParticipant.getLogin(), this.id);
			this.listeAttente = WaitingDAO.waitingsForAnEvent(this.id);
		}
	}

	public void removeParticipant(User participant){
		ParticipationDAO.delete(participant.getLogin(), this.id);
		this.listeParticipants = ParticipationDAO.participationsInAnEvent(this.id);
		this.listeAttente = WaitingDAO.waitingsForAnEvent(this.id);
	}

	public void removePendingParticipant(User participant){
		WaitingDAO.delete(participant.getLogin(), this.id);
		this.listeAttente = WaitingDAO.waitingsForAnEvent(this.id);
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", createDate=" + createDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", modifDate=" + modifDate + ", cancelDate="
				+ cancelDate + ", maxNbParticipant=" + maxNbParticipant + ", organizer=" + organizer + ", organization="
				+ organization + ", room=" + room + ", address=" + address + ", listeParticipants=" + listeParticipants
				+ ", listeAttente=" + listeAttente + "]";
	}

}