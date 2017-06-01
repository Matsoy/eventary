/*
 * 
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Room;

// TODO: Auto-generated Javadoc
/**
 * The Class RoomDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: RoomDAO.java
 * 
 * Classe pour les objets Dao de Room
 */

public class RoomDAO{

	/**
	 * Instantiates a new room DAO.
	 */
	public RoomDAO() {

	}

	/**
	 * Pour retrouver tous les tuples.
	 *
	 * @return la liste des Room
	 */
	public static ArrayList<Room> findAll() {
		Statement stat = null;
		String query = "";
		ArrayList<Room> ret = new ArrayList<Room>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ROOM;";
			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Room()); //ajout du Room � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), BuildingDAO.find(result.getInt(2)), result.getInt(3), result.getString(4)); //initialisaton de les param�tres du retour de la requ�te
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
	 * @param id_room id de la Room a retrouver
	 * @return the Room
	 */
	public static Room find(int id_room) {
		Statement stat = null;
		String query = "";
		Room ret = new Room();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ROOM WHERE id = " + id_room + ";";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.init(id_room, BuildingDAO.find(result.getInt(2)), result.getInt(3), result.getString(4));
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
	 * Pour retrouver les salles d'un batiment.
	 *
	 * @param building_id the building id
	 * @return la liste des Room
	 */
	public static ArrayList<Room> findBuildingRooms(int building_id) {
		Statement stat = null;
		String query = "";
		ArrayList<Room> ret = new ArrayList<Room>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM ROOM WHERE building_id = "+ building_id +";";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Room()); //ajout du Room � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), BuildingDAO.find(result.getInt(2)), result.getInt(3), result.getString(4)); //initialisaton de les param�tres du retour de la requ�te
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
	 * @param tuple a inserer
	 */
	public static void insert(Room tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Room
		int id = tuple.getBuilding().getId();
		int nbPlaces = tuple.getNbPlaces();
		String name = tuple.getName();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "INSERT INTO ROOM VALUES("+ id +","+ nbPlaces +",'"+ name +"');";

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
	 * @param id_room id du tuple a supprimer
	 */
	public static void delete(int id_room) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();
			
			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "DELETE FROM ROOM WHERE id = " + id_room + ";";

			//Execute la requête
			stat.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
