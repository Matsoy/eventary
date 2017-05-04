package database;

import java.sql.*;
import java.util.*;
import model.*;

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
	 * @return the result set
	 */
	public ArrayList<Room> findAll() {
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
			//Le resultat de la requête
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new Room()); //ajout du Room à l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getInt(1), result.getInt(2), result.getInt(3), result.getString(4)); //initialisaton de les paramètres du retour de la requête
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
	 * @return the room
	 */
	public Room find(int id_room) {
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
					ret.init(id_room, result.getInt(2), result.getInt(3), result.getString(4));
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
	 * @param tuple Objet de type Room a inserer
	 */
	public void insert(Room tuple) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet Room
		int id = tuple.getId();
		int nbPlaces = tuple.getNbPlaces();
		String name = tuple.getName();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "INSERT INTO ROOM VALUES("+ id +","+ nbPlaces +","+ name +");";

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
	 * @param id_room id du tuple a supprimer
	 */
	public void delete(int id_room) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete
			query = "DELETE FROM ROOM WHERE id = " + id_room + ";";

			//Execute la requÃªte
			stat.executeQuery(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}
}
