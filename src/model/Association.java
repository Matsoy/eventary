/*
 * 
 */
package model;

import database.OrgaMemberDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Association.
 */
public class Association extends Organization {
	
	/**
	 * Instantiates a new association.
	 */
	public Association() {
	}
	
	/**
	 * Adds the member.
	 *
	 * @param nouveauMembre the nouveau membre
	 */
	public void addMember(User nouveauMembre){
		OrgaMemberDAO.insert(nouveauMembre.getLogin(), this.id);
		this.setListeMembres(OrgaMemberDAO.find(this.id));
		// Pour chaque membre de la liste, on notifie
//		for(User membre : listeMembres){
//			NotificationDAO.insert(membre.login);
//		}
	}
}
