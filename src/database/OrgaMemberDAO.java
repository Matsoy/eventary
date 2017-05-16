package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Association;
import model.User;

/**
 * The Class OrgaMemberDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: OrgaMemberDAO.java
 * 
 * Classe pour les objets Dao de représentant l'appartenance d'un User à une organisation
 */

public class OrgaMemberDAO{


	/**
	 * Instantiates a new organization DAO.
	 */
	public OrgaMemberDAO() {

	}

	/**
	 * Renvoie la liste des User membre d'une Association
	 *
	 * @param orga_id id de l'organisation
	 * @return the array list
	 */
	public static ArrayList<User> find(int orga_id) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ORGA_MEMBER WHERE orga_id = " + orga_id + ";";

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
	 * @param association_id id du Association
	 */
	public static void insert(String user_login, int association_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO ASSO_MEMBER VALUES("+ association_id +",'"+ user_login +"');";

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
	 * @param association_id id du Association
	 */
	public static void delete(String user_login, int association_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM ASSO_MEMBER WHERE association_id = " + association_id + "AND user_login = '" + user_login + "';";

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
