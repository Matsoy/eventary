package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import model.Event;

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
	
	private java.text.SimpleDateFormat parser;

	/**
	 * Instantiates a new event DAO.
	 */
	public EventDAO() {
		this.parser = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

			if (result.next() ) {
				do {
//					try {
//						String creatDate
//						String creatDate
//						String creatDate
//						String creatDate
//						String creatDate
//						System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
//						java.util.Date today = this.parser.parse(result.getString(5));
//						System.out.println("Today String = " + this.parser.format(today));
//						System.out.println("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}

					ret.add(new Event()); //ajout du Event à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), result.getString(3), result.getTimestamp(4), result.getTimestamp(5), result.getTimestamp(6), result.getTimestamp(7), result.getTimestamp(8), result.getInt(9), new UserDAO().find(result.getString(10)), new RoomDAO().find(result.getInt(11)), result.getString(12)); //initialisaton de les paramètres du retour de la requête
				} 
				while (result.next());
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

			if (result.next() ) {
				do {
					ret.init(id_event, result.getString(2), result.getString(3), result.getTimestamp(4), result.getTimestamp(5), result.getTimestamp(6), result.getTimestamp(7), result.getTimestamp(8), result.getInt(9), new UserDAO().find(result.getString(10)), new RoomDAO().find(result.getInt(11)), result.getString(12));
				} 
				while (result.next());
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
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//Recuperation des attributs de l'objet Event
		int id = tuple.getId();
		String title = tuple.getTitle();
		String desc = tuple.getDescription();

		java.util.Date creaDate = tuple.getCreateDate();
		java.util.Date startDate = tuple.getStartDate();
		java.util.Date endDate = tuple.getEndDate();
		java.util.Date modifDate = tuple.getModifDate();
		java.util.Date cancelDate = tuple.getCancelDate();
		int maxNbParticipant = tuple.getMaxNbParticipant();
		String organizer = tuple.getOrganizer().getLogin();
		int room_id = tuple.getRoom().getId();
		String address = tuple.getAddress();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO EVENT VALUES("+ id +",'"+ title +"','"+ desc +"',"+ sdf.format(creaDate) +","+ sdf.format(startDate) +","+ sdf.format(endDate) +","+ sdf.format(modifDate) +","+ sdf.format(cancelDate) +","+ maxNbParticipant +","+ organizer +","+ room_id +",'"+ address +"');";

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
