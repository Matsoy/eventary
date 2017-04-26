package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
* @author Mathieu Soyer
*
* File: SchoolDAO.java
*
*Classe pour les objets Dao de School
*/

public class SchoolDAO{
    //Methodes
    /**
    *Constructeur
    */
    public SchoolDAO() {

    }

    /**
    *Pour retrouver tous les tuples
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
            query = "SELECT * FROM SCHOOL;";

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
    *Permet de retrouver juste un tuple
    *@param id_school id du School a retrouver
    */
    public School find(int id_school) {
        Statement stat = null;
        String query = "";
        School ret = new School();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM SCHOOL WHERE id = " + id_school + ";";

            //Retourne l'execution de la requete sous la forme d'un objet ResultSet
            ResultSet result = stat.executeQuery(query);

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(id_school, result.getString(2));
            }
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        return ret;
    }


    /**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type School a inserer
    */
    public void insert(School tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Site
        int id = tuple.getId();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO SITE VALUES("+ id +","+ name +");";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }


    /**
    * Permet de supprimer un tuple
    *@param id_school id du tuple a supprimer
    */
    public void delete(int id_school) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "DELETE FROM SCHOOL WHERE id = " + id_school + ";";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
