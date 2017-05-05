package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Site.
 */
public class Site {
	
	/** The id. */
	int id;
	
	/** The school id. */
	int school_id;
	
	/** The name. */
	String name;
	
	List<Building> listeBatiments = new ArrayList<Building>();
	
	/**
	 * Instantiates a new site.
	 */
	public Site() {	//Constructeur vide
	}
	
	
	
	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param school_id the school id
	 * @param name the name
	 */
	public void init(int id, int school_id, String name) {
		this.id = id;
		this.school_id = school_id;
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
	 * Gets the school id.
	 *
	 * @return the school id
	 */
	public int getSchool_id() {
		return school_id;
	}

	/**
	 * Sets the school id.
	 *
	 * @param school_id the new school id
	 */
	public void setSchool_id(int school_id) {
		this.school_id = school_id;
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
	
	public List<Building> getListeBatiments() {
		return listeBatiments;
	}

	public void setListeBatiments(List<Building> listeBatiments) {
		this.listeBatiments = listeBatiments;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Site [id=" + id + ", school_id=" + school_id + ", name=" + name + "]";
	}


}