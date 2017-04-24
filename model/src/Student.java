public class Student {
	String fName;
	String lName;
	String branch;
	int year;
	
	public static void main(String[] args) {
	}
	
	public Student() {	//Constructeur vide
	}
	
	public void init(String fname, String lname, String branch, int year) {
		this.fName = fname;
		this.lName = lname;
		this.branch = branch;
		this.year = year;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student [fName=" + fName + ", lName=" + lName + ", branch=" + branch + ", year=" + year + "]";
	}
}
