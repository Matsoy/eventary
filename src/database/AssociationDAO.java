package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Association;

/**
 * The Class AssociationDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: AssociationDAO.java
 * 
 * Classe pour les objets Dao de Association
 */

public class AssociationDAO{

	/**
	 * Instantiates a new association DAO.
	 */
	public AssociationDAO() {

	}

	/**
	 * Pour retrouver tous les tuples.
	 *
	 * @return the result set
	 */
	public static ArrayList<Association> findAll() {
		Statement stat = null;
		String query = "";
		ArrayList<Association> ret = new ArrayList<Association>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ASSOCIATION;";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Association()); //ajout du Association � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getString(2), UserDAO.find(result.getString(3))); //initialisaton de les param�tres du retour de la requ�te
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
	 * Permet de retrouver juste un tuple.
	 *
	 * @param id_association id du Association a retrouver
	 * @return the association
	 */
	public static Association find(int id_association) {
		Statement stat = null;
		String query = "";
		Association ret = new Association();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ASSOCIATION WHERE id = " + id_association + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.init(id_association, result.getString(2), UserDAO.find(result.getString(3)));
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
	 * @param tuple Objet de type Association a inserer
	 */
	public static void insert(Association tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Association
		int id = tuple.getId();
		String name = tuple.getName();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO ASSOCIATION VALUES("+ id +",'"+ name +"');";

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
	 * @param id_association id du tuple a supprimer
	 */
	public static void delete(int id_association) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM ASSOCIATION WHERE id = " + id_association + ";";

			//Execute la requête
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
