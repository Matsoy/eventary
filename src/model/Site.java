package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * The Class Site.
 */
public class Site extends Observable{
	
	/** The id. */
	int id;
	
	/** The school. */
	School school;
	
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
	 * @param school the school
	 * @param name the name
	 */
	public void init(int id, School school, String name) {
		this.id = id;
		this.school = school;
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
	 * Gets the school.
	 *
	 * @return the school
	 */
	public School getSchool() {
		return school;
	}

	/**
	 * Sets the school.
	 *
	 * @param school_id the new school
	 */
	public void setSchool(School school) {
		this.school = school;
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
		return "Site [id=" + id + ", school=" + school + ", name=" + name + "]";
	}


}