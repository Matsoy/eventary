package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
* @author Mathieu Soyer
*
* File: EventDAO.java
*
*Classe pour les objets Dao de Event
*/

public class EventDAO{
    //Methodes
    /**
    *Constructeur
    */
    public EventDAO() {

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
            query = "SELECT * FROM EVENT;";

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
    *@param id_event id de l'Event a retrouver
    */
    public Event find(int id_event) {
        Statement stat = null;
        String query = "";
        Event ret = new Event();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM EVENT WHERE id = " + id_event + ";";

            //Retourne l'execution de la requete sous la forme d'un objet ResultSet
            ResultSet result = stat.executeQuery(query);

            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                ret.init(id_event, result.getString(2), result.getString(3), result.getTimestamp(4), result.getTimestamp(5), result.getTimestamp(6), result.getTimestamp(7), result.getTimestamp(8), result.getInt(9), result.getInt(10), result.getInt(11), result.getString(12));
            }
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }

        return ret;
    }


    /**
    *Methode qui permet d'inserer un tuple
    *@param tuple Objet de type Event a inserer
    */
    public void insert(Event tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Event
        int id = tuple.getId();
        String title = tuple.getTitle();
        String desc = tuple.getDesc();
        java.sql.Timestamp creaDate = tuple.getCreaDate();
        java.sql.Timestamp startDate = tuple.getStartDate();
        java.sql.Timestamp endDate = tuple.getEndDate();
        java.sql.Timestamp modifDate = tuple.getModifDate();
        java.sql.Timestamp cancelDate = tuple.getCancelDate();
        int maxNbParticipant = tuple.getMaxNbParticipant();
        int organizer = tuple.getOrganizer();
        int school_id = tuple.getSchoolId();
        String address = tuple.getAddress();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO EVENT VALUES("+ id +","+ title +","+ desc +","+ creaDate +","+ startDate +","+ endDate +","+ modifDate +","+ cancelDate +","+ maxNbParticipant +","+ organizer +","+ school_id +","+ address +");";

            //Execute la requête
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }


    /**
    * Permet de supprimer un tuple
    *@param id_event id du tuple a supprimer
    */
    public void delete(int id_event) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //suppression de toutes les participations à cet Event
            ParticipationDAO dao = new ParticipationDAO();
            dao.delete("", id_event);

            //Preparation de la requete
            query = "DELETE FROM EVENT WHERE id = " + id_event + ";";

            //Execute la requête
            stat.executeQuery(query);

        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
