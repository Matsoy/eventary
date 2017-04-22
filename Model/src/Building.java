public class Building {
	int id;
	String name;
	
	public static void main(String[] args) {
	}

	public Building() {	//Constructeur vide
	}
	
	public void init(int id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + "]";
	}
}