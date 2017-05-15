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

			//Le resultat de la requête
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
					
					ret.add(new Event()); //ajout du Event à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), result.getString(3), dates[0], dates[1], dates[2], dates[3], dates[4], result.getInt(9), UserDAO.find(result.getString(10)), organization, RoomDAO.find(result.getInt(12)), result.getString(13), ParticipationDAO.participationsInAnEvent(result.getInt(1)), WaitingDAO.waitingsForAnEvent(result.getInt(1))); //initialisaton de les paramètres du retour de la requête
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
					if (orga_type.equals("asso")) {
						organization = OrganizationDAO.findAsso(result.getInt(11));
					} 
					else if (orga_type.equals("dpt")){
						organization = OrganizationDAO.findDpt(result.getInt(11));
					}

					ret.init(result.getInt(1), result.getString(2), result.getString(3), dates[0], dates[1], dates[2], dates[3], dates[4], result.getInt(9), UserDAO.find(result.getString(10)), organization, RoomDAO.find(result.getInt(12)), result.getString(13), ParticipationDAO.participationsInAnEvent(result.getInt(1)), WaitingDAO.waitingsForAnEvent(result.getInt(1)));
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
	public static void insert(Event tuple) {
		Statement stat = null;
		String query = "";

		String[] datesStr = new String[5];
		Date[] dates = new Date[5];
		dates[0] = tuple.getCreateDate();
		dates[1] = tuple.getStartDate();
		dates[2] = tuple.getEndDate();
		dates[3] = tuple.getModifDate();
		dates[4] = tuple.getCancelDate();

		for (int i = 0; i < dates.length; i++) {
			if(dates[i] != null){
				datesStr[i] = "datetime('" + parser.format(dates[i]) + "')";
			}
			else{
				datesStr[i] = null;
			}
		}

		//Recuperation des attributs de l'objet Event
		int id = tuple.getId();
		String title = tuple.getTitle();
		String desc = tuple.getDescription();
		String organizer = tuple.getOrganizer().getLogin();
		int room_id = tuple.getRoom().getId();
		String address = tuple.getAddress();
		int maxNbParticipant = tuple.getMaxNbParticipant();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO EVENT VALUES("+ id +",'"+ title +"','"+ desc +"',"+ dates[0] +","+ dates[1] +","+ dates[2] +","+ dates[3] +","+ dates[4] +","+ maxNbParticipant +","+ organizer +","+ room_id +",'"+ address +"');";

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
	public static void delete(int id_event) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//suppression de toutes les participations à  cet Event
			ParticipationDAO.delete("", id_event);

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
