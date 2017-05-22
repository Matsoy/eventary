/*
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

// TODO: Auto-generated Javadoc
/**
 * The Class Building.
 */
public class Building extends Observable{
	
	/** The id. */
	int id;
	
	/** The site. */
	Site site;
	
	/** The name. */
	String name;
	
	/** The liste salles. */
	List<Room> listeSalles = new ArrayList<Room>();

	/**
	 * Instantiates a new building.
	 */
	public Building() {	//Constructeur vide
	}
	
	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param site the site
	 * @param name the name
	 */
	public void init(int id, Site site, String name) {
		this.id = id;
		this.name = name;
		this.site = site;
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
	 * Gets the site.
	 *
	 * @return the site id
	 */
	public Site getSite() {
		return site;
	}

	/**
	 * Sets the site.
	 *
	 * @param site the new site
	 */
	public void setSite(Site site) {
		this.site = site;
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
	 * Gets the liste salles.
	 *
	 * @return the liste salles
	 */
	public List<Room> getListeSalles() {
		return listeSalles;
	}

	/**
	 * Sets the liste salles.
	 *
	 * @param listeSalles the new liste salles
	 */
	public void setListeSalles(List<Room> listeSalles) {
		this.listeSalles = listeSalles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Building [id=" + id + ", site=" + site + ", name=" + name + "]";
	}
}