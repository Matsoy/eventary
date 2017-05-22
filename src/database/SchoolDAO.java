/*
 * 
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.School;

// TODO: Auto-generated Javadoc
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
    public static ArrayList<School> findAll() {
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
            
			if (result.next() ) {
				do {
                    ret.add(new School()); //ajout du School � l'ArrayList. Appel du constructeur vide
                    ret.get(ret.size()-1).init(result.getInt(1), result.getString(2)); //initialisaton de les param�tres du retour de la requ�te		
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
     * @param id_school id du School a retrouver
     * @return the school
     */
    public static School find(int id_school) {
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

			if (result.next() ) {
				do {
					ret.init(id_school, result.getString(2));		
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
     * @param tuple Objet de type School a inserer
     */
    public static void insert(School tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Site
        int id = tuple.getId();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO SITE VALUES("+ id +",'"+ name +"');";

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
    public static void delete(int id_school) {
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
