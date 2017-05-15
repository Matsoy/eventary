package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Building;

/**
 * The Class BuildingDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: BuildingDAO.java
 * 
 * Classe pour les objets Dao de Building
 */

public class BuildingDAO{

	/**
	 * Instantiates a new building DAO.
	 */
	public BuildingDAO() {

	}

	/**
	 * Pour retrouver tous les tuples.
	 *
	 * @return the result set
	 */
	public static ArrayList<Building> findAll() {
		Statement stat = null;
		String query = "";
		ArrayList<Building> ret = new ArrayList<Building>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM BUILDING;";

			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Building()); //ajout du Building à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), SiteDAO.find(result.getInt(2)), result.getString(3)); //initialisaton de les paramètres du retour de la requête
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
	 * @param id_building id du Building a retrouver
	 * @return the building
	 */
	public static Building find(int id_building) {
		Statement stat = null;
		String query = "";
		Building ret = new Building();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM BUILDING WHERE id = " + id_building + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.init(id_building, SiteDAO.find(result.getInt(2)), result.getString(3));
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
	 * Pour retrouver les batiments d'un site.
	 *
	 * @param site_id the site id
	 * @return the result set
	 */
	public static ArrayList<Building> findSiteBuildings(int site_id) {
		Statement stat = null;
		String query = "";
		ArrayList<Building> ret = new ArrayList<Building>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM BUILDING WHERE site_id = "+ site_id +";";

			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Building()); //ajout du Building à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), SiteDAO.find(result.getInt(2)), result.getString(3)); //initialisaton de les paramètres du retour de la requête
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
	 * @param tuple Objet de type Building a inserer
	 */
	public static void insert(Building tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Building
		int id = tuple.getId();
		int site_id = tuple.getSite().getId();
		String name = tuple.getName();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO BUILDING VALUES("+ id +","+ site_id +",'"+ name +"');";

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
	 * @param id_building id du tuple a supprimer
	 */
	public static void delete(int id_building) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM BUILDING WHERE id = " + id_building + ";";

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
