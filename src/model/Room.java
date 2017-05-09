package model;

/**
 * The Class Room.
 */
public class Room {
	
	/** The id. */
	int id;
	
	/** The building. */
	Building building;
	
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
	 * @param building the building
	 * @param nbPlaces the nb places
	 * @param name the name
	 */
	public void init(int id, Building building, int nbPlaces, String name) {
		this.id = id;
		this.building = building;
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
	 * Gets the building.
	 *
	 * @return the building
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * Sets the building.
	 *
	 * @param building the new building
	 */
	public void setBuilding(Building building) {
		this.building = building;
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
		return "Room [id=" + id + ", building=" + building + ", nbPlaces=" + nbPlaces + ", name=" + name + "]";
	}

}
