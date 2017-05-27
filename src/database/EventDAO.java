/*
 * 
 */
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

// TODO: Auto-generated Javadoc
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

	/** The parser. */
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
			query = "SELECT * FROM EVENT ORDER BY datetime(startDate) ASC;";

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
	 * @param title the title
	 * @param description the description
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param maxNbParticipant the max nb participant
	 * @param organizer the organizer
	 * @param organization the organization
	 * @param room the room
	 * @param address the address
	 * @return true, if successful
	 */	
	public static boolean insert(String title, String description, Date startDate, Date endDate, int maxNbParticipant, User organizer, Organization organization, Room room, String address) {
		System.out.println("dans EventDAO.insert");
		System.out.println(title);
		System.out.println(description);
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(maxNbParticipant);
		System.out.println(organizer);
		System.out.println(organization);
		System.out.println(room);
		System.out.println(address);

		boolean ret = false;
		Statement stat = null;
		String query = "INSERT INTO EVENT (title, descr, organizer,";
		String values = " VALUES (\""+ title +"\",\""+ description +"\",'"+organizer.getLogin()+"',";

		if (organization != null) {
			query+=" orga_id,";
			values+=organization.getId()+",";
		}

		if (room != null) {
			query+=" room_id,";
			values+=room.getId()+",";
			query+=" maxNbParticipant,";
			values+=room.getNbPlaces()+",";
		}
		else {
			query+=" maxNbParticipant,";
			values+=maxNbParticipant+",";
			query+=" address,";
			values+="'"+address+"',";
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
					if(i==0) throw new IllegalArgumentException("startDate == null");
					throw new IllegalArgumentException("endDate == null");
				}
			}
			query+=" startDate, endDate)";
			values+=datesStr[0]+","+datesStr[1]+");";

			try {
				//Recuperation de la connexion
				Connection con = SQLiteConnection.getInstance().getConnection();
				
				//Preparation de la requete en ligne
				stat = con.createStatement();

				//Execute la requête
				stat.executeUpdate(query + values);
				ret = true;
			}
			catch(SQLException e) {
				System.out.println("ERREUR: " + e.getMessage()); 
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("ERREUR: " + ex.getMessage()); 
		}
		return ret;
	}


	/**
	 * Permet de supprimer un tuple.
	 *
	 * @param id_event id du tuple a supprimer
	 * @return true, if successful
	 */
	public static boolean delete(int id_event) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//suppression de toutes les participations � cet Event
			ParticipationDAO.delete("", id_event);

			//Preparation de la requete
			query = "DELETE FROM EVENT WHERE id = " + id_event + ";";

			//Execute la requête
			stat.executeUpdate(query);
			ret = true;
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}
}
