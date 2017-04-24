public class User {
	String login;
	String passwd;
	boolean moderator;
	
	public static void main(String[] args) {
	}
	
	public User() {	//Constructeur vide
	}
	
	public void init(String log, String passwd, boolean modo) {
		this.login = log;
		this.passwd = passwd;
		this.moderator = modo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public boolean getModerator() {
		return moderator;
	}

	public void setModerator(boolean moderator) {
		this.moderator = moderator;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", passwd=" + passwd + ", moderator=" + moderator + "]";
	}
}
