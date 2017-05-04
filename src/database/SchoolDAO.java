package database;

import java.sql.*;
import java.util.*;
import model.*;

/**
 * The Class SchoolDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: SchoolDAO.java
 * 
 * Classe pour les objets Dao de School
 */

public class SchoolDAO{

    /**
     * Instantiates a new school DAO.
     */
    public SchoolDAO() {

    }

    /**
     * Pour retrouver tous les tuples.
     *
     * @return the result set
     */
    public ArrayList<School> findAll() {
        Statement stat = null;
        String query = "";
        ArrayList<School> ret = new ArrayList<School>();
        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM SCHOOL;";

            //Le resultat de la requ�te
            ResultSet result = stat.executeQuery(query);
            
            //Si le resultat est bon, prends la premiere ligne
            if (result.first()) {
                //tant que le curseur n'est pas après le dernier élément du résultat de la requête
                while(!result.isAfterLast()){
                    ret.add(new School()); //ajout du School � l'ArrayList. Appel du constructeur vide
                    ret.get(ret.size()-1).init(result.getInt(1), result.getString(2)); //initialisaton de les param�tres du retour de la requ�te
                    result.next(); //bouge le curseur d'une ligne depuis sa place courante
                }
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
     * @param id_school id du School a retrouver
     * @return the school
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
     * Methode qui permet d'inserer un tuple.
     *
     * @param tuple Objet de type School a inserer
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
     * Permet de supprimer un tuple.
     *
     * @param id_school id du tuple a supprimer
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
