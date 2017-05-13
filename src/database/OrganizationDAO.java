package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Association;
import model.Department;
import model.Organization;

/**
 * The Class OrganizationDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: OrganizationDAO.java
 * 
 * Classe pour les objets Dao de Organization (Association et Department)
 */

public class OrganizationDAO{

	/**
	 * Instantiates a new Organization DAO.
	 */
	public OrganizationDAO() {

	}

	/**
	 * Pour retrouver tous les tuples des associations
	 *
	 * @return the result set
	 */
	public static ArrayList<Association> findAllAsso() {
		Statement stat = null;
		String query = "";
		ArrayList<Association> ret = new ArrayList<Association>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ORGANIZATION	WHERE type_orga = 'asso';";

			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Association()); //ajout du Association à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3))); //initialisaton de les paramètres du retour de la requête
				} 
				while (result.next());
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}
	
	
	/**
	 * Pour retrouver tous les tuples des departements
	 *
	 * @return the result set
	 */
	public static ArrayList<Department> findAllDpt() {
		Statement stat = null;
		String query = "";
		ArrayList<Department> ret = new ArrayList<Department>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ORGANIZATION	WHERE type_orga = 'dpt';";

			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Department()); //ajout du Department à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3))); //initialisaton de les paramètres du retour de la requête
				} 
				while (result.next());
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}

	
	/**
	 * Methode qui permet d'inserer un tuple.
	 *
	 * @param tuple Objet de type Association a inserer
	 */
	public static void insert(Organization tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Association
		int id = tuple.getId();
		String name = tuple.getName();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO ORGANIZATION VALUES("+ id +",'"+ name +"');";

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
	 * @param id_association id du tuple a supprimer
	 */
	public static void delete(int id_orga) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM ORGANIZATION WHERE id = " + id_orga + ";";

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
