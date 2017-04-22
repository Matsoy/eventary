public class Room {
	int id;
	String name;
	int nbPlaces;
	
	public static void main(String[] args) {
	}
	
	public Room() {	// Constructeur vide
	}
	
	public void init(int id, String name, int nbPlaces){
		this.id = id;
		this.name = name;
		this.nbPlaces = nbPlaces;
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", nbPlaces=" + nbPlaces + "]";
	}
}
