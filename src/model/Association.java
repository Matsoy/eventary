package model;

import database.*;

/**
 * The Class Association.
 */
public class Association extends Organization {
	
	/**
	 * Instantiates a new association.
	 */
	public Association() {
	}
	
	public void addMember(User nouveauMembre){
		AssoMemberDAO.insert(nouveauMembre.getLogin(), this.id);
		this.listeMembres = AssoMemberDAO.find(this.id);
	}
}
