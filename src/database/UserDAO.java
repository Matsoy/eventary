package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
* @author Mathieu Soyer
*
* File: UserDAO.java
*
*Classe pour les objets Dao de User
*/

public class UserDAO{
    //Methodes
    /**
    *Constructeur
    */
    public UserDAO() {

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
            query = "SELECT * FROM USER;";

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
    *@param login_user login de l'User a retrouver
    */
    public User find(String login_user) {
        Statement stat = null;
        String query = "";
        User ret = new User();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM USER WHERE login = " + login_user + ";";

            //Retourne l'execution de la requete sous la forme d'un objet ResultSet
            ResultSet result = stat.executeQuery(query);

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(login_user, result.getString(2), result.getBoolean(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7));
            }
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        return ret;
    }


    /**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type User a inserer
    */
    public void insert(User tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet User
        String login = tuple.getLogin();
        String passwd = tuple.getPasswd();
        boolean moderator = tuple.getModerator();
        String fName = tuple.getFName();
        String lName = tuple.getLName();
        String branch = tuple.getBranch();
        int year = tuple.getYear();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO USER VALUES("+ login +","+ passwd +","+ moderator +","+ fName +","+ lName +","+ branch +","+ year +");";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }


    /**
    * Permet de supprimer un tuple
    *@param login_user login du tuple a supprimer
    */
    public void delete(String login_user) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //suppression de toutes les participations du User à des Event
            ParticipationDAO dao = new ParticipationDAO();
            dao.delete(login_user, -1);

            //Preparation de la requete
            query = "DELETE FROM USER WHERE login = " + login_user + ";";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
