package database;

import java.sql.*;
import java.util.*;
import model.*;

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
	 * @return the array list
	 */
	public ArrayList<User> participationsInAnEvent(int id_event) {
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
			query = "INSERT INTO PARTICIPATION VALUES("+ user_login +","+ event_id +");";

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

			// pas de User désigné -> suppression de toutes les participations de l'Event
			if (user_login == null || user_login.isEmpty()) {
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE event_id = " + event_id + ";";
			}
			// pas de User désigné -> suppression de toutes les participations du User
			else if(event_id == -1){
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE user_login = " + user_login + ";";
			}
			// sinon, on supprime la participation du User choisi pour l'Event choisi
			else{
				//Preparation de la requete
				query = "DELETE FROM PARTICIPATION WHERE event_id = " + event_id + "AND user_login = " + user_login + ";";
			}

			//Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
