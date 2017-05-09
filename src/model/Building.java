package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Building.
 */
public class Building {
	
	/** The id. */
	int id;
	
	/** The site. */
	Site site;
	
	/** The name. */
	String name;
	
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
	 * @param site_id the new site id
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
	
	public List<Room> getListeSalles() {
		return listeSalles;
	}

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