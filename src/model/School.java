/*
 * 
 */
package model;

import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class School.
 */
public class School extends Observable {
	
	/** The id. */
	int id;
	
	/** The name. */
	String name;
	
	/**
	 * Instantiates a new school.
	 */
	public School() {	//Constructeur vide
	}
	
	/**
	 * Inits the School.
	 * Méthode appelée par les DAO.
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
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + "]";
	}




}
