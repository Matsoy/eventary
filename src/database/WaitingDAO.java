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
 * The Class WaitingDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: WaitingDAO.java
 * 
 * Classe pour les objets Dao de repr�sentant la participation d'un User � un Event (sur liste d'attente)
 */

public class WaitingDAO{

	/**
	 * Instantiates a new waiting DAO.
	 */
	public WaitingDAO() {

	}

	/**
	 * Renvoie la liste des User participant à un Event (sur liste d'attente) tri�e de celui qui attend depuis le + longtemps � celui qui attend depuis le moins longtemps.
	 *
	 * @param id_event id du Event
	 * @return the array list
	 */
	public static ArrayList<User> waitingsForAnEvent(int id_event) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM WAITING WHERE event_id = " + id_event + " ORDER BY datetime(waiting_date) ASC;";

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
	 * Renvoie la liste des Event auxquels attend un User.
	 *
	 * @param user_login the user login
	 * @return the array list
	 */
	public static ArrayList<Event> waitingEvents(String user_login) {
		Statement stat = null;
		String query = "";
		ArrayList<Event> ret = new ArrayList<Event>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM WAITING WHERE UPPER(user_login) = UPPER('" + user_login + "') ORDER BY datetime(waiting_date) ASC;";

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
	 */
	public static void insert(String user_login, int event_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "INSERT INTO WAITING VALUES('"+ user_login +"',"+ event_id +");";

			//Execute la requête
			stat.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
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

			// pas de User désigné -> suppression de toutes les participations � cet Event (sur liste d'attente)
			if (user_login == null || user_login.isEmpty()) {
				//Preparation de la requete
				query = "DELETE FROM WAITING WHERE event_id = " + event_id + ";";
			}
			// sinon, on supprime la participation du User choisi pour l'Event choisi
			else{
				//Preparation de la requete
				query = "DELETE FROM WAITING WHERE event_id = " + event_id + "AND UPPER(user_login) = UPPER('" + user_login + "');";
			}

			//Execute la requête
			stat.executeUpdate(query);
			ret = true;
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
		return false;
	}

	/**
	 * Renvoie le premier qui est sur la liste d'attente d'un �v�nement.
	 *
	 * @param event_id l'id du Event
	 * @return user_login the user login
	 */
	public static String getFirstWaiting(int event_id) {
		Statement stat = null;
		String query = "";
		String ret = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			query = "SELECT * FROM WAITING WHERE event_id = " + event_id + " ORDER  BY datetime(waiting_date) ASC LIMIT 1;";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret = result.getString(2); //ret = le login du USER qui est sur la liste d'attente depuis le plus longtemps	
				} 
				while (result.next());
			}
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}
}
