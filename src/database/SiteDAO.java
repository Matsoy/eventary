package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
* @author Mathieu Soyer
*
* File: SiteDAO.java
*
*Classe pour les objets Dao de Site
*/

public class SiteDAO{
    //Methodes
    /**
    *Constructeur
    */
    public SiteDAO() {

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
            query = "SELECT * FROM SITE;";

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
    *@param id_site id du Site a retrouver
    */
    public Site find(int id_site) {
        Statement stat = null;
        String query = "";
        Site ret = new Site();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM SITE WHERE id = " + id_site + ";";

            //Retourne l'execution de la requete sous la forme d'un objet ResultSet
            ResultSet result = stat.executeQuery(query);

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(id_site, result.getInt(2), result.getString(3));
            }
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        return ret;
    }


    /**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Site a inserer
    */
    public void insert(Site tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Site
        int id = tuple.getId();
        int school_id = tuple.getSchoolId();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO SITE VALUES("+ id +","+ school_id +","+ name +");";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }


    /**
    * Permet de supprimer un tuple
    *@param id_site id du tuple a supprimer
    */
    public void delete(int id_site) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "DELETE FROM SITE WHERE id = " + id_site + ";";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
