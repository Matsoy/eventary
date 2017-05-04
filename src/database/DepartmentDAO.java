package database;

import java.sql.*;
import java.util.ArrayList;

import model.*;

/**
 * The Class DepartmentDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: DepartmentDAO.java
 * 
 * Classe pour les objets Dao de Department
 */

public class DepartmentDAO{

	/**
	 * Instantiates a new department DAO.
	 */
	public DepartmentDAO() {

	}

	/**
	 * Pour retrouver tous les tuples.
	 *
	 * @return the result set
	 */
	public ArrayList<Department> findAll() {
		Statement stat = null;
		String query = "";
        ArrayList<Department> ret = new ArrayList<Department>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM DEPARTMENT;";

			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				//tant que le curseur n'est pas aprÃ¨s le dernier Ã©lÃ©ment du rÃ©sultat de la requÃªte
				while(!result.isAfterLast()){
					ret.add(new Department()); //ajout du Department à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2)); //initialisaton de les paramètres du retour de la requête
					result.next(); //bouge le curseur d'une ligne depuis sa place courante
				}
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}

	/**
	 * Permet de retrouver juste un tuple.
	 *
	 * @param id_department id du Department a retrouver
	 * @return the department
	 */
	public Department find(int id_department) {
		Statement stat = null;
		String query = "";
		Department ret = new Department();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM DEPARTMENT WHERE id = " + id_department + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.first()) {
				ret.init(id_department, result.getString(2));
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
	 * @param tuple Objet de type Department a inserer
	 */
	public void insert(Department tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Department
		int id = tuple.getId();
		String name = tuple.getName();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO DEPARTMENT VALUES("+ id +","+ name +");";

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
	 * @param id_department id du tuple a supprimer
	 */
	public void delete(int id_department) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM DEPARTMENT WHERE id = " + id_department + ";";

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
