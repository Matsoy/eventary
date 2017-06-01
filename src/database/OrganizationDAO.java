/*
 * 
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Association;
import model.Department;
import model.Organization;

// TODO: Auto-generated Javadoc
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
	 * Pour retrouver tous les tuples des associations.
	 *
	 * @return la liste des Association
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

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Association()); //ajout du Association � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3)), OrgaMemberDAO.find(result.getInt(1))); //initialisaton de les param�tres du retour de la requ�te
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
	 * Pour retrouver tous les tuples des departements.
	 *
	 * @return la liste des Department
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

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Department()); //ajout du Department � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3)), OrgaMemberDAO.find(result.getInt(1))); //initialisaton de les param�tres du retour de la requ�te
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
	 * Pour retrouver l'association recherchee.
	 *
	 * @param id_asso the id asso
	 * @return the result set
	 */
	public static Association findAsso(int id_asso) {
		Statement stat = null;
		String query = "";
		Association ret = new Association();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ORGANIZATION	WHERE id = "+ id_asso +" AND type_orga = 'asso';";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3)), OrgaMemberDAO.find(result.getInt(1))); //initialisaton de les param�tres du retour de la requ�te
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
	 * Pour retrouver le departement recherche.
	 *
	 * @param id_dpt the id dpt
	 * @return le Department
	 */
	public static Department findDpt(int id_dpt) {
		Statement stat = null;
		String query = "";
		Department ret = new Department();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ORGANIZATION	WHERE id = "+ id_dpt +" AND type_orga = 'dpt';";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3)), OrgaMemberDAO.find(result.getInt(1))); //initialisaton de les param�tres du retour de la requ�te
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
	 * Pour retrouver les liste des associations dans lesquelles un User est membre.
	 *
	 * @param user_login the user login
	 * @return l'Association
	 */
	public static ArrayList<Association> assoInWhichUserIsMember(String user_login) {
		Statement stat = null;
		String query = "";
		ArrayList<Association> ret = new ArrayList<Association>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT orga_id FROM ORGA_MEMBER WHERE UPPER(user_login) = UPPER('" + user_login + "');";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					if (getOrganizationType(result.getInt(1)).equals("asso")) {
						ret.add(findAsso(result.getInt(1))); //ajout de l'Association à l'ArrayList
					}
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
	 * Pour retrouver les liste des departements dans lesquelles un User est membre.
	 *
	 * @param user_login the user login
	 * @return la liste des Department
	 */
	public static ArrayList<Department> dptInWhichUserIsMember(String user_login) {
		Statement stat = null;
		String query = "";
		ArrayList<Department> ret = new ArrayList<Department>();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT orga_id FROM ORGA_MEMBER WHERE UPPER(user_login) = UPPER('" + user_login + "');";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					if (getOrganizationType(result.getInt(1)).equals("dpt")) {
						ret.add(findDpt(result.getInt(1))); //ajout du Department à l'ArrayList
					}
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
	 * Retourne le type d'organisation ("asso" pour une association, "dpt" pour un departement).
	 *
	 * @param id_orga l'id de l'organisation
	 * @return le type de l'Organization
	 */
	public static String getOrganizationType(int id_orga) {
		Statement stat = null;
		String query = "";
		String ret = null;
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT type_orga FROM ORGANIZATION	WHERE id = "+ id_orga +";";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret = result.getString(1);
				} 
				while (result.next());
			}
		}
		catch (SQLException e) {
			System.out.println("ERREUR_getOrganizationType: " + e.getMessage());
		}

		return ret;
	}


	/**
	 * Methode qui permet d'inserer un tuple.
	 *
	 * @param tuple a inserer
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
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "INSERT INTO ORGANIZATION VALUES("+ id +",'"+ name +"');";

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
	 * @param id_orga the id orga
	 */
	public static void delete(int id_orga) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM ORGANIZATION WHERE id = " + id_orga + ";";

			//Execute la requête
			stat.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
