package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The Class Organization.
 */
public abstract class Organization extends Observable{
	
	/** The id. */
	int id;
	
	/** The name. */
	String name;
	
	/** Le reponsable de l'organisation */
	User inCharge;
	
	List<User> listeMembres = new ArrayList<User>();
	
	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param name the name
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
	 * @param id the new in charge
	 */
	public void setInCharge(User inCharge) {
		this.inCharge = inCharge;
	}
	
	public List<User> getListeMembres() {
		return listeMembres;
	}

	public void setListeMembres(List<User> listeMembres) {
		this.listeMembres = listeMembres;
		this.setChanged();
		this.notifyObservers();
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", inCharge=" + inCharge + ", listeMembres=" + listeMembres
				+ "]";
	}
}
