package database;

import java.sql.*;
import model.*;

/**
* @author Mathieu Soyer
*
* File: DepartmentDAO.java
*
*Classe pour les objets Dao de Department
*/

public class DepartmentDAO{
    //Methodes
    /**
    *Constructeur
    */
    public DepartmentDAO() {

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
            query = "SELECT * FROM DEPARTMENT;";

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
    *@param id_department id du Department a retrouver
    */
    public Department find(int id_department) {
        Statement stat = null;
        String query = "";
        Department ret = new Department();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM DEPARTMENT WHERE id = " + id_department + ";";

            //Retourne l'execution de la requete sous la forme d'un objet ResultSet
            ResultSet result = stat.executeQuery(query);

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(id_department, result.getString(2));
            }
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        return ret;
    }


    /**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Department a inserer
    */
    public void insert(Department tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Department
        int id = tuple.getId();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO DEPARTMENT VALUES("+ id +","+ name +");";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }


    /**
    * Permet de supprimer un tuple
    *@param id_department id du tuple a supprimer
    */
    public void delete(int id_department) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "DELETE FROM DEPARTMENT WHERE id = " + id_department + ";";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
