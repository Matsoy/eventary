package model;

public class School {
	String name;
	
	public static void main(String[] args) {
	}
	
	public School() {	//Constructeur vide
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
		return "School [name=" + name + "]";
	}
}
