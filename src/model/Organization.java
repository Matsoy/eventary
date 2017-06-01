/*
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class Organization.
 * Organization est une classe abstraite car 2 classes 
 * hériteront du type organization : Association et Département
 */
public abstract class Organization extends Observable{
	
	/** The id. */
	int id;
	
	/** The name. */
	String name;
	
	/**  Le reponsable de l'organisation. */
	User inCharge;
	
	/** The liste membres. */
	List<User> listeMembres = new ArrayList<User>();
	
	/**
	 * Inits the Organization.
	 * Méthode appelée par les DAO.
	 *
	 * @param id the id
	 * @param name the name
	 * @param inCharge the in charge
	 * @param listeMembres the liste membres
	 */
	public void init(int id, String name, User inCharge, List<User> listeMembres) {
		this.id = id;
		this.name = name;
		this.inCharge = inCharge;
		this.listeMembres = listeMembres;
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
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the in charge.
	 *
	 * @return the in charge
	 */
	public User getInCharge() {
		return inCharge;
	}

	/**
	 * Sets the in charge.
	 *
	 * @param inCharge the new in charge
	 */
	public void setInCharge(User inCharge) {
		this.inCharge = inCharge;
	}
	
	/**
	 * Gets the liste membres.
	 *
	 * @return the liste membres
	 */
	public List<User> getListeMembres() {
		return listeMembres;
	}

	/**
	 * Sets the liste membres.
	 *
	 * @param listeMembres the new liste membres
	 */
	public void setListeMembres(List<User> listeMembres) {
		this.listeMembres = listeMembres;
		this.setChanged();
		this.notifyObservers();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", inCharge=" + inCharge + ", listeMembres=" + listeMembres
				+ "]";
	}
}
