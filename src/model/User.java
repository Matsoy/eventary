package model;

/**
 * The Class User.
 */
public class User {
	
	/** The login. */
	String login;
	
	/** The moderator. */
	boolean moderator;
	
	/** The name. */
	String fName;
	
	/** The l name. */
	String lName;
	
	/** The branch. */
	String branch;
	
	/** The year. */
	int year;

	/**
	 * Instantiates a new user.
	 */
	public User() {
	}

	/**
	 * Inits the.
	 *
	 * @param login the login
	 * @param moderator the moderator
	 * @param fName the f name
	 * @param lName the l name
	 * @param branch the branch
	 * @param year the year
	 */
	public void init(String login, Boolean moderator, String fName, String lName, String branch, int year) {
		this.login = login;
		this.moderator = moderator;
		this.fName = fName;
		this.lName = lName;
		this.branch = branch;
		this.year = year;
	}

	
	/**
	 * Gets the login.
	 *
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Checks if is moderator.
	 *
	 * @return true, if is moderator
	 */
	public boolean getModerator() {
		return moderator;
	}

	/**
	 * Sets the moderator.
	 *
	 * @param moderator the new moderator
	 */
	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	/**
	 * Gets the f name.
	 *
	 * @return the f name
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * Sets the f name.
	 *
	 * @param fName the new f name
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}

	/**
	 * Gets the l name.
	 *
	 * @return the l name
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * Sets the l name.
	 *
	 * @param lName the new l name
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}

	/**
	 * Gets the branch.
	 *
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}

	/**
	 * Sets the branch.
	 *
	 * @param branch the new branch
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}

	/**
	 * Gets the year.
	 *
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [login=" + login + ", moderator=" + moderator + ", fName=" + fName
				+ ", lName=" + lName + ", branch=" + branch + ", year=" + year + "]";
	}


}
