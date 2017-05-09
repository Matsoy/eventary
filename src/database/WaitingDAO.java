package database;

import java.sql.*;
import java.util.*;
import model.*;

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
	 * Renvoie la liste des User participant à un Event (sur liste d'attente)
	 *
	 * @param id_event id du Event
	 * @return the array list
	 */
	public ArrayList<User> WaitingsForAnEvent(int id_event) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT user_login FROM WAITING WHERE event_id = " + id_event + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					UserDAO tmpDAO = new UserDAO(); //création du DAO pour récupérer l'objet User ayant le login de la ligne courante du curseur
					ret.add(tmpDAO.find(result.getString(2))); //ajout du User à l'ArrayList			
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
	public void insert(String user_login, int event_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO WAITING VALUES('"+ user_login +"',"+ event_id +");";

			//Execute la requête
			stat.executeQuery(query);
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
	 */
	public void delete(String user_login, int event_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			// pas de User désigné -> suppression de toutes les participations � cet Event (sur liste d'attente)
			if (user_login == null || user_login.isEmpty()) {
				//Preparation de la requete
				query = "DELETE FROM WAITING WHERE event_id = " + event_id + ";";
			}
			// sinon, on supprime la participation du User choisi pour l'Event choisi
			else{
				//Preparation de la requete
				query = "DELETE FROM WAITING WHERE event_id = " + event_id + "AND user_login = '" + user_login + "';";
			}

			//Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}

	/**
	 * Renvoie le premier qui est sur la liste d'attente d'un �v�nement
	 *
	 * @param event_id l'id du Event
	 * @return user_login the user login
	 */
	public String getFirstWaiting(int event_id) {
		Statement stat = null;
		String query = "";
		String ret = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

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
