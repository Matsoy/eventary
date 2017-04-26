package model;

public class Room {
	int id;
	String name;
	int nbPlaces;
	int buildingId;
	
	public static void main(String[] args) {
	}
	
	public Room() {	// Constructeur vide
	}
	
	public void init(int id, String name, int nbPlaces, int buildingId){
		this.id = id;
		this.name = name;
		this.nbPlaces = nbPlaces;
		this.buildingId = buildingId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", nbPlaces=" + nbPlaces + ", buildingId=" + buildingId + "]";
	}
}
