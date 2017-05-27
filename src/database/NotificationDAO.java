/*
 * 
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class NotificationDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: NotificationDAO.java
 * 
 * Classe pour les objets Dao de repr�sentant les notifications
 */

public class NotificationDAO{


	/**
	 * Instantiates a new organization DAO.
	 */
	public NotificationDAO() {

	}


	/**
	 * Retourne la liste des notifications d'un utilisateur.
	 *
	 * @param user_login the user login
	 * @return the array list
	 */
	public static ArrayList<String> find(String user_login) {
		Statement stat = null;
		String query = "";
		ArrayList<String> ret = new ArrayList<String>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM NOTIFICATION WHERE UPPER(user_login) = UPPER('" + user_login + "');";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(result.getString(3)); //ajout du message de la notification à l'ArrayList
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
	 * @param user_login the user login
	 * @param message the message
	 * @return true, if successful
	 */
	public static boolean insert(String user_login, String message) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "INSERT INTO NOTIFICATION (user_login, message) VALUES('"+ user_login +"','"+ message +"');";

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
	 * @param user_login the user login
	 * @return true, if successful
	 */
	public static boolean delete(String user_login) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "DELETE FROM NOTIFICATION WHERE UPPER(user_login) = UPPER('" + user_login + "');";
			
			System.out.println(query);

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
