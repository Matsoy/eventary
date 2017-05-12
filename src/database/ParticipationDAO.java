package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

/**
 * The Class ParticipationDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: ParticipationDAO.java
 * 
 * Classe pour les objets Dao de représentant la participation d'un User à un Event
 */

public class ParticipationDAO{

	/**
	 * Instantiates a new participation DAO.
	 */
	public ParticipationDAO() {

	}

	/**
	 * Renvoie la liste des User participant Ã  un Event.
	 *
	 * @param id_event id du Event
	 * @return the array list
	 */
	public static ArrayList<User> participationsInAnEvent(int id_event) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT user_login FROM PARTICIPATION WHERE event_id = " + id_event + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(UserDAO.find(result.getString(2))); //ajout du User Ã  l'ArrayList			
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

			//Preparation de la requete
			query = "INSERT INTO PARTICIPATION VALUES('"+ user_login +"',"+ event_id +");";

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
	 * @param user_login le login du User
	 * @param event_id l'id du Event
	 */
	public static void delete(String user_login, int event_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			// pas de User dÃ©signÃ© -> suppression de toutes les participations pour cet Event
			if (user_login.equals("") || user_login.isEmpty()) {
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE event_id = " + event_id + ";";
			}
			else{
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE user_login = '" + user_login + "' and event_id = " + event_id + ";";
				// récupération du premier User sur liste d'attente
				String firstWaitingLogin = WaitingDAO.getFirstWaiting(event_id);
				// s'il y a un User en attente
				if (firstWaitingLogin.equals("") || firstWaitingLogin.isEmpty()) {
					// on le supprime de la liste d'attente
					WaitingDAO.delete(firstWaitingLogin, event_id);
					//et on le rajoute à la liste des participants
					insert(firstWaitingLogin, event_id);
				}
			}

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
