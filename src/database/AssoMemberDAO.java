package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
 * The Class AssoMemberDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: AssoMemberDAO.java
 * 
 * Classe pour les objets Dao de repr�sentant l'appartenance d'un User � une Association
 */

public class AssoMemberDAO{


	/**
	 * Instantiates a new association DAO.
	 */
	public AssoMemberDAO() {

	}

	/**
	 * Renvoie la liste des User membre d'une AssoMember
	 *
	 * @param association_id id du Association
	 * @return the array list
	 */
	public ArrayList<User> participationsInAnEvent(int association_id) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT user_login FROM ASSO_MEMBER WHERE association_id = " + association_id + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				//tant que le curseur n'est pas après le dernier élément du résultat de la requête
				while(!result.isAfterLast()){
					UserDAO tmpDAO = new UserDAO(); //création du DAO pour récupérer l'objet User ayant le login de la ligne courante du curseur
					ret.add(tmpDAO.find(result.getString(2))); //ajout du User à l'ArrayList
					result.next(); //bouge le curseur d'une ligne depuis sa place courante
				}
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
	public void insert(String user_login, int association_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO ASSO_MEMBER VALUES("+ association_id +","+ user_login +");";

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
	 * @param association_id id du Association
	 */
	public void delete(String user_login, int association_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM ASSO_MEMBER WHERE association_id = " + association_id + "AND user_login = " + user_login + ";";

			//Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
