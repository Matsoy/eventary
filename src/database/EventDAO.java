package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import model.Event;
import model.Organization;
import model.Room;
import model.User;

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

	private static java.text.SimpleDateFormat parser = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
	public static ArrayList<Event> findAll() {
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

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					String[] datesStr = new String[5];
					Date[] dates = new Date[5];
					for (int i = 0; i < datesStr.length; i++) {
						datesStr[i] = result.getString(4+i);
					}

					for (int i = 0; i < datesStr.length; i++) {
						if(datesStr[i] != null){
							try {
								dates[i] = parser.parse(datesStr[i]);
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
						else{
							dates[i] = null;
						}
					}
					String orga_type = OrganizationDAO.getOrganizationType(result.getInt(11)); //recuperation type de l'orga de l'evenement ("asso" pour une association, "dpt" pour un departement)
					Organization organization = null;
					if (orga_type!= null && orga_type.equals("asso")) {
						organization = OrganizationDAO.findAsso(result.getInt(11));
					} 
					else if (orga_type!= null && orga_type.equals("dpt")){
						organization = OrganizationDAO.findDpt(result.getInt(11));
					}

					ret.add(new Event()); //ajout du Event � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), result.getString(3), dates[0], dates[1], dates[2], dates[3], dates[4], result.getInt(9), UserDAO.find(result.getString(10)), organization, RoomDAO.find(result.getInt(12)), result.getString(13), ParticipationDAO.eventParticipants(result.getInt(1)), WaitingDAO.waitingsForAnEvent(result.getInt(1))); //initialisaton de les param�tres du retour de la requ�te
				} 
				while (result.next());
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR findAll: " + e.getMessage());
		}

		return ret;
	}

	/**
	 * Permet de retrouver juste un tuple.
	 *
	 * @param id_event id de l'Event a retrouver
	 * @return the event
	 */
	public static Event find(int id_event) {
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
					String[] datesStr = new String[5];
					Date[] dates = new Date[5];
					for (int i = 0; i < datesStr.length; i++) {
						datesStr[i] = result.getString(4+i);
					}

					for (int i = 0; i < datesStr.length; i++) {
						if(datesStr[i] != null){
							try {
								dates[i] = parser.parse(datesStr[i]);
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}
						else{
							dates[i] = null;
						}
					}

					String orga_type = OrganizationDAO.getOrganizationType(result.getInt(11)); //recuperation type de l'orga de l'evenement ("asso" pour une association, "dpt" pour un departement)
					Organization organization = null;
					if (orga_type != null && orga_type.equals("asso")) {
						organization = OrganizationDAO.findAsso(result.getInt(11));
					} 
					else if (orga_type != null && orga_type.equals("dpt")){
						organization = OrganizationDAO.findDpt(result.getInt(11));
					}

					ret.init(result.getInt(1), result.getString(2), result.getString(3), dates[0], dates[1], dates[2], dates[3], dates[4], result.getInt(9), UserDAO.find(result.getString(10)), organization, RoomDAO.find(result.getInt(12)), result.getString(13), ParticipationDAO.eventParticipants(result.getInt(1)), WaitingDAO.waitingsForAnEvent(result.getInt(1)));
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
	public static boolean insert(String title, String description, Date startDate, Date endDate, int maxNbParticipant, User organizer, Organization organization, Room room, String address) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		String organizer_login = null;
		if (organizer != null) {
			organizer_login = organizer.getLogin();		
		}

		int room_id = 0;
		if (room != null) {
			room_id = room.getId();	
		}

		String[] datesStr = new String[2];
		Date[] dates = new Date[2];
		dates[0] = startDate;
		dates[1] = endDate;

		try {
			for (int i = 0; i < dates.length; i++) {
				if(dates[i] != null){
					datesStr[i] = "datetime('" + parser.format(dates[i]) + "')";
				}
				else{
					throw new IllegalArgumentException(dates[i] +"== null");
				}
			}

			try {
				//Recuperation de la connexion
				Connection con = SQLiteConnection.getInstance().getConnection();

				//Preparation de la requete
				query = "INSERT INTO EVENT (title, descr, startDate, endDate, maxNbParticipant, organizer, orga_id, room_id, address)"
						+ " VALUES("+ title +"','"+ description +"',"+ dates[0] +","+ dates[1] +","+ maxNbParticipant +","+ organizer_login +","+ room_id +",'"+ address +"');";

				//Execute la requête
				stat.executeQuery(query);

				ret = true;
			}
			catch(SQLException e) {
				System.out.println("ERREUR: " + e.getMessage()); 
			}
		} catch (Exception e) {
			// TODO: // TODO: handle exceptionhandle exception
		}
		return ret;
	}


	/**
	 * Permet de supprimer un tuple.
	 *
	 * @param id_event id du tuple a supprimer
	 */
	public static void delete(int id_event) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//suppression de toutes les participations � cet Event
			ParticipationDAO.delete("", id_event);

			//Preparation de la requete
			query = "DELETE FROM EVENT WHERE id = " + id_event + ";";

			//Execute la requête
			stat.executeQuery(query);

		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
