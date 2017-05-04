package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
 * The Class EventDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: EventDAO.java
 * 
 * Classe pour les objets Dao de Event
 */

public class EventDAO{

	/**
	 * Instantiates a new event DAO.
	 */
	public EventDAO() {

	}

	/**
	 * Pour retrouver tous les tuples.
	 *
	 * @return the result set
	 */
	public ArrayList<Event> findAll() {
		Statement stat = null;
		String query = "";
		ArrayList<Event> ret = new ArrayList<Event>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM EVENT;";

			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				//tant que le curseur n'est pas aprÃ¨s le dernier Ã©lÃ©ment du rÃ©sultat de la requÃªte
				while(!result.isAfterLast()){
					ret.add(new Event()); //ajout du Event à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), result.getString(3), result.getTimestamp(4), result.getTimestamp(5), result.getTimestamp(6), result.getTimestamp(7), result.getTimestamp(8), result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12)); //initialisaton de les paramètres du retour de la requête
					result.next(); //bouge le curseur d'une ligne depuis sa place courante
				}
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}

	/**
	 * Permet de retrouver juste un tuple.
	 *
	 * @param id_event id de l'Event a retrouver
	 * @return the event
	 */
	public Event find(int id_event) {
		Statement stat = null;
		String query = "";
		Event ret = new Event();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM EVENT WHERE id = " + id_event + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				ret.init(id_event, result.getString(2), result.getString(3), result.getTimestamp(4), result.getTimestamp(5), result.getTimestamp(6), result.getTimestamp(7), result.getTimestamp(8), result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
			}
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}


	/**
	 * Methode qui permet d'inserer un tuple.
	 *
	 * @param tuple Objet de type Event a inserer
	 */
	public void insert(Event tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Event
		int id = tuple.getId();
		String title = tuple.getTitle();
		String desc = tuple.getDescription();
		java.sql.Timestamp creaDate = tuple.getCreateDate();
		java.sql.Timestamp startDate = tuple.getStartDate();
		java.sql.Timestamp endDate = tuple.getEndDate();
		java.sql.Timestamp modifDate = tuple.getModifDate();
		java.sql.Timestamp cancelDate = tuple.getCancelDate();
		int maxNbParticipant = tuple.getMaxNbParticipant();
		int organizer = tuple.getOrganizer();
		int school_id = tuple.getSchool_id();
		String address = tuple.getAddress();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO EVENT VALUES("+ id +","+ title +","+ desc +","+ creaDate +","+ startDate +","+ endDate +","+ modifDate +","+ cancelDate +","+ maxNbParticipant +","+ organizer +","+ school_id +","+ address +");";

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}


	/**
	 * Permet de supprimer un tuple.
	 *
	 * @param id_event id du tuple a supprimer
	 */
	public void delete(int id_event) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//suppression de toutes les participations à  cet Event
			ParticipationDAO dao = new ParticipationDAO();
			dao.delete("", id_event);

			//Preparation de la requete
			query = "DELETE FROM EVENT WHERE id = " + id_event + ";";

			//Execute la requÃªte
			stat.executeQuery(query);

		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
