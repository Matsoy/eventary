package model;

/**
 * The Class Room.
 */
public class Room {
	
	/** The id. */
	int id;
	
	/** The building id. */
	int building_id;
	
	/** The nb places. */
	int nbPlaces;
	
	/** The name. */
	String name;
	
	/**
	 * Instantiates a new room.
	 */
	public Room() {	// Constructeur vide
	}
	
	
	/**
	 * Inits the.
	 *
	 * @param id the id
	 * @param building_id the building id
	 * @param nbPlaces the nb places
	 * @param name the name
	 */
	public void init(int id, int building_id, int nbPlaces, String name) {
		this.id = id;
		this.building_id = building_id;
		this.nbPlaces = nbPlaces;
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
	 * Gets the building id.
	 *
	 * @return the building id
	 */
	public int getBuilding_id() {
		return building_id;
	}

	/**
	 * Sets the building id.
	 *
	 * @param building_id the new building id
	 */
	public void setBuilding_id(int building_id) {
		this.building_id = building_id;
	}

	/**
	 * Gets the nb places.
	 *
	 * @return the nb places
	 */
	public int getNbPlaces() {
		return nbPlaces;
	}

	/**
	 * Sets the nb places.
	 *
	 * @param nbPlaces the new nb places
	 */
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
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
		return "Room [id=" + id + ", building_id=" + building_id + ", nbPlaces=" + nbPlaces + ", name=" + name + "]";
	}

}
