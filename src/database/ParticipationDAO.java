/*
 * 
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Event;
import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class ParticipationDAO.
 *
 * @author Mathieu Soyer
 *
 * File: ParticipationDAO.java
 *
 * Classe pour les objets Dao de repr�sentant la participation d'un User � un Event
 */

public class ParticipationDAO{

	/**
	 * Instantiates a new participation DAO.
	 */
	public ParticipationDAO() {

	}


	/**
	 * Renvoie la liste des User participant à un Event.
	 *
	 * @param id_event id du Event
	 * @return la liste des User
	 */
	public static ArrayList<User> eventParticipants(int id_event) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM PARTICIPATION WHERE event_id = " + id_event + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(UserDAO.find(result.getString(2))); //ajout du User à l'ArrayList
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
	 * Renvoie la liste des Event auxquels participe un User.
	 *
	 * @param user_login the user login
	 * @return la liste des Event
	 */
	public static ArrayList<Event> participationsInAnEvent(String user_login) {
		Statement stat = null;
		String query = "";
		ArrayList<Event> ret = new ArrayList<Event>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM PARTICIPATION WHERE UPPER(user_login) = UPPER('" + user_login + "');";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(EventDAO.find(result.getInt(1))); //ajout du Event à l'ArrayList
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
	 * @param user_login le login du User
	 * @param event_id l'id du Event
	 * @return true, if successful
	 */
	public static boolean insert(String user_login, int event_id) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "INSERT INTO PARTICIPATION VALUES("+ event_id +",'"+ user_login +"');";

			//Execute la requête
			stat.executeUpdate(query);
			ret = true;
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
		return ret;
	}


	/**
	 * Permet de supprimer un tuple.
	 *
	 * @param user_login le login du User
	 * @param event_id l'id du Event
	 * @return true, if successful
	 */
	public static boolean delete(String user_login, int event_id) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			// pas de User désigné -> suppression de toutes les participations pour cet Event
			if (user_login.equals("") || user_login.isEmpty()) {
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE event_id = " + event_id + ";";
				//Execute la requête
				stat.executeUpdate(query);
			}
			else{
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE UPPER(user_login) = UPPER('" + user_login + "') and event_id = " + event_id + ";";
				//Execute la requête
				stat.executeUpdate(query);
				// r�cup�ration du premier User sur liste d'attente
				String firstWaitingLogin = WaitingDAO.getFirstWaiting(event_id);
				// s'il y a un User en attente
				if (!(firstWaitingLogin.equals("") || firstWaitingLogin.isEmpty())) {
					// on le supprime de la liste d'attente
					WaitingDAO.delete(firstWaitingLogin, event_id);
					//et on le rajoute � la liste des participants
					ParticipationDAO.insert(firstWaitingLogin, event_id);
				}
			}

			ret = true;
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
		return ret;
	}
}
