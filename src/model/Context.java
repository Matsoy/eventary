package model;

import database.*;

public class Context {
	User currentUser;
	
	public Context(){
		this.currentUser = null;
	}
	
	public boolean connexion(String login, String passwd){
		UserDAO user = new UserDAO();
		this.currentUser = user.connect(login, passwd);
		if(null == this.currentUser){	// Si les logs ne sont pas bon, on récupère un user null
			return false;
		}
		return true;
	}
}
