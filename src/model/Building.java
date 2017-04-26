package model;

public class Building {
	int id;
	String name;
	int siteId;
	
	public static void main(String[] args) {
	}

	public Building() {	//Constructeur vide
	}
	
	public void init(int id, String name, int siteId) {
		this.id = id;
		this.name = name;
		this.siteId = siteId;
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

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", siteId=" + siteId + "]";
	}
}