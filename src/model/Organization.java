package model;

import java.util.*;

/**
 * The Class Organization.
 */
public abstract class Organization {
	
	/** The id. */
	int id;
	
	/** The name. */
	String name;
	
	List<User> listeMembres = new ArrayList<User>();
	
	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param name the name
	 */
	public void init(int id, String name) {
		this.id = id;
		this.name = name;
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
	
	public List<User> getListeMembres() {
		return listeMembres;
	}

	public void setListeMembres(List<User> listeMembres) {
		this.listeMembres = listeMembres;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + "]";
	}
}
