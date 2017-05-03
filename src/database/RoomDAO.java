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
    //Methodes
    /**
     * Constructeur.
     */
    public RoomDAO() {

    }

    /**
     * Pour retrouver tous les tuples.
     *
     * @return the result set
     */
    public ResultSet findAll() {
        Statement stat = null;
        String query = "";
        ResultSet ret = null;
        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM ROOM;";

            //Le resultat a retourner
            ret = stat.executeQuery(query);
        }
        catch (SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        //Retourne l'execution de la requete sous la forme d'un objet ResultSet
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

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(id_room, result.getInt(2), result.getInt(3), result.getString(4));
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

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
