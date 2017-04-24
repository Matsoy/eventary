package model;

public class Site {
	String name;
	
	public static void main(String[] args) {
	}
	
	public Site() {	//Constructeur vide
	}
	
	public void init(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Site [name=" + name + "]";
	}
}
