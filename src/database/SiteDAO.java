/*
 * 
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Room;
import model.Site;

// TODO: Auto-generated Javadoc
/**
 * The Class SiteDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: SiteDAO.java
 * 
 * Classe pour les objets Dao de Site
 */

public class SiteDAO{

    /**
     * Instantiates a new site DAO.
     */
    public SiteDAO() {

    }

    /**
     * Pour retrouver tous les tuples.
     *
     * @return la liste des Site
     */
    public static ArrayList<Site> findAll() {
        Statement stat = null;
        String query = "";
        ArrayList<Site> ret = new ArrayList<Site>();
        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete en ligne
            stat = con.createStatement();

            //Preparation de la requete
            query = "SELECT * FROM SITE;";

            //Le resultat de la requ�te
            ResultSet result = stat.executeQuery(query);
            
			if (result.next() ) {
				do {
                	ret.add(new Site()); //ajout du Site � l'ArrayList. Appel du constructeur vide
                    ret.get(ret.size()-1).init(result.getInt(1), SchoolDAO.find(result.getInt(2)), result.getString(3)); //initialisaton de les param�tres du retour de la requ�te
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
     * @param id_site id du Site a retrouver
     * @return the Site
     */
    public static Site find(int id_site) {
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

			if (result.next() ) {
				do {
	                ret.init(id_site, SchoolDAO.find(result.getInt(2)), result.getString(3));
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
	 * Pour retrouver les sites d'une ecole.
	 *
	 * @param school_id the school id
	 * @return la liste des Site
	 */
	public static ArrayList<Site> findSchoolSites(int school_id) {
		Statement stat = null;
		String query = "";
		ArrayList<Site> ret = new ArrayList<Site>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM SITE WHERE school_id = "+ school_id +";";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
                	ret.add(new Site()); //ajout du Site � l'ArrayList. Appel du constructeur vide
                    ret.get(ret.size()-1).init(result.getInt(1), SchoolDAO.find(result.getInt(2)), result.getString(3)); //initialisaton de les param�tres du retour de la requ�te
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
     * Methode qui permet d'inserer un tuple.
     *
     * @param tuple a inserer
     */
    public static void insert(Site tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Site
        int id = tuple.getId();
        int school_id = tuple.getSchool().getId();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();
            
          //Preparation de la requete en ligne
			stat = con.createStatement();

            //Preparation de la requete
            query = "INSERT INTO SITE VALUES("+ id +","+ school_id +",'"+ name +"');";

            //Execute la requête
            stat.executeUpdate(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }


    /**
     * Permet de supprimer un tuple.
     *
     * @param id_site id du tuple a supprimer
     */
    public static void delete(int id_site) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();
            
          //Preparation de la requete en ligne
			stat = con.createStatement();

            //Preparation de la requete
            query = "DELETE FROM SITE WHERE id = " + id_site + ";";

            //Execute la requête
            stat.executeUpdate(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
