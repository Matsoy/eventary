package model;

import java.sql.Timestamp;
import java.util.*;
import database.*;

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
	Timestamp createDate;
	
	/** The start date. */
	Timestamp startDate;
	
	/** The end date. */
	Timestamp endDate;
	
	/** The modif date. */
	Timestamp modifDate;
	
	/** The cancel date. */
	Timestamp cancelDate;	
	
	/** The max nb participant. */
	int maxNbParticipant;
	
	/** The organizer. */
	User organizer;
	
	/** The school. */
	School school;
	
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
	 * @param school the school
	 * @param address the address
	 */
	public void init(int id, String title, String description, Timestamp createDate, Timestamp startDate, Timestamp endDate,
			Timestamp modifDate, Timestamp cancelDate, int maxNbParticipant, User organizer, School school,
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
		this.school = school;
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
	public Timestamp getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Timestamp getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Timestamp getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the modif date.
	 *
	 * @return the modif date
	 */
	public Timestamp getModifDate() {
		return modifDate;
	}

	/**
	 * Sets the modif date.
	 *
	 * @param modifDate the new modif date
	 */
	public void setModifDate(Timestamp modifDate) {
		this.modifDate = modifDate;
	}

	/**
	 * Gets the cancel date.
	 *
	 * @return the cancel date
	 */
	public Timestamp getCancelDate() {
		return cancelDate;
	}

	/**
	 * Sets the cancel date.
	 *
	 * @param cancelDate the new cancel date
	 */
	public void setCancelDate(Timestamp cancelDate) {
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
	 * Gets the school.
	 *
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Sets the school .
	 *
	 * @param school the new school
	 */
	public void setSchool(School school) {
		this.school = school;
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
	
	public void ajouterParticipant(User newParticipant){
		// Si il y a encore de la place, on ajoute l'utilisateur en tant que participant
		if(this.listeParticipants.size() < this.maxNbParticipant){
			ParticipationDAO participant = new ParticipationDAO();
			participant.insert(newParticipant.getLogin(), this.id);
			this.listeParticipants = participant.participationsInAnEvent(this.id);	
		}
		// Sinon, on l'ajoute dans la liste d'attente
		else{
			//AttenteDAO attente = new AttenteDAO();
			//attente.insert(attente.getLogin(), this.id)
			//this.listeAttente = attente.attenteInAnEvent(this.id);
		}
	}
	
	public void supprimerParticipant(User participant){
		ParticipationDAO participation = new ParticipationDAO();
		//AttenteDAO attente = new AttenteDAO();
		participation.delete(participant.getLogin(), this.id);
		this.listeParticipants = participation.participationsInAnEvent(this.id);
		//this.listeAttente = attente.attenteInAnEvent(this.id);
	}
	
	public void supprimerAttente(User attente){
		//AttenteDAO attente = new AttenteDAO();
		//attente.delete(attente.getLogin(), this.id)
		//this.listeAttente = attente.attenteInAnEvent(this.id);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Event [id=" + id + ", title=" + title + ", description=" + description + ", createDate=" + createDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", modifDate=" + modifDate + ", cancelDate="
				+ cancelDate + ", maxNbParticipant=" + maxNbParticipant + ", organizer=" + organizer + ", school="
				+ school + ", address=" + address + "]";
	}
	
}