/*
 * 
 */
package model;

import database.OrgaMemberDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class Association.	
 * Cette classe se distingue de la classe département car elle contient
 * une méthode pour ajouter des membres dans l'association.
 */
public class Association extends Organization {
	
	/**
	 * Instantiates a new association.
	 */
	public Association() {
	}
	
	/**
	 * Adds the member.
	 * Cette méthode va permettre l'ajout de l'utilisateur passé en paramètre
	 * dans l'association (this), et va s'occuper de notifier les autres membres 
	 * de l'association de cet ajout.
	 * 
	 * @param nouveauMembre the nouveau membre
	 */
	public void addMember(User nouveauMembre){
		OrgaMemberDAO.insert(nouveauMembre.getLogin(), this.id);
		this.setListeMembres(OrgaMemberDAO.find(this.id));
		// Pour chaque membre de la liste, on notifie
		for(User membre : listeMembres){
			membre.addNotification(nouveauMembre.fName+" "+nouveauMembre.lName+" a été ajouté dans l'association "+this.name);
		}
	}
}
