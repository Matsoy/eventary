package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
 * The Class DepMemberDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: DepMemberDAO.java
 * 
 * Classe pour les objets Dao de repr�sentant l'appartenance d'un User � un Department
 */

public class DepMemberDAO{


	/**
	 * Instantiates a new dep member DAO.
	 */
	public DepMemberDAO() {

	}

	/**
	 * Renvoie la liste des User membre d'un Department.
	 *
	 * @param department_id id du Department
	 * @return the array list
	 */
	public ArrayList<User> participationsInAnEvent(int department_id) {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT user_login FROM DEP_MEMBER WHERE department_id = " + department_id + ";";

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
	 * @param department_id l'id du Department
	 */
	public void insert(String user_login, int department_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO DEP_MEMBER VALUES("+ department_id +","+ user_login +");";

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
	 * @param department_id l'id du Department
	 */
	public void delete(String user_login, int department_id) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM DEP_MEMBER WHERE department_id = " + department_id + "AND user_login = " + user_login + ";";

			//Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
