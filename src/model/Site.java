package model;

public class Site {
	String name;
	int schoolId;
	
	public static void main(String[] args) {
	}
	
	public Site() {	//Constructeur vide
	}
	
	public void init(String name, int schoolId) {
		this.name = name;
		this.schoolId = schoolId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	@Override
	public String toString() {
		return "Site [name=" + name + ", schoolId=" + schoolId + "]";
	}
}
