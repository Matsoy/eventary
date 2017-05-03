package database;

import java.sql.*;
import java.util.*;
import model.*;

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
    //Methodes
    /**
     * Constructeur.
     */
    public BuildingDAO() {

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
            query = "SELECT * FROM BUILDING;";

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
     * @param id_building id du Building a retrouver
     * @return the building
     */
    public Building find(int id_building) {
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

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(id_building, result.getInt(2), result.getString(3));
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
     * @param tuple Objet de type Building a inserer
     */
    public void insert(Building tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Building
        int id = tuple.getId();
        int site_id = tuple.getSite_id();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO BUILDING VALUES("+ id +","+ site_id +","+ name +");";

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
     * @param id_building id du tuple a supprimer
     */
    public void delete(int id_building) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "DELETE FROM BUILDING WHERE id = " + id_building + ";";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
