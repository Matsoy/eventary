package model;

/**
 * The Class Building.
 */
public class Building {
	
	/** The id. */
	int id;
	
	/** The site id. */
	int site_id;
	
	/** The name. */
	String name;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
	}

	/**
	 * Instantiates a new building.
	 */
	public Building() {	//Constructeur vide
	}
	
	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param site_id the site id
	 * @param name the name
	 */
	public void init(int id, int site_id, String name) {
		this.id = id;
		this.name = name;
		this.site_id = site_id;
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
	 * Gets the site id.
	 *
	 * @return the site id
	 */
	public int getSite_id() {
		return site_id;
	}

	/**
	 * Sets the site id.
	 *
	 * @param site_id the new site id
	 */
	public void setSite_id(int site_id) {
		this.site_id = site_id;
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
		return "Building [id=" + id + ", site_id=" + site_id + ", name=" + name + "]";
	}
}