package model;

import database.OrgaMemberDAO;

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
		OrgaMemberDAO.insert(nouveauMembre.getLogin(), this.id);
		this.setListeMembres(OrgaMemberDAO.find(this.id));
	}
}
