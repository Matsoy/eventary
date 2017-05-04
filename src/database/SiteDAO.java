package database;

import java.sql.*;
import java.util.*;
import model.*;

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
     * @return the result set
     */
    public ArrayList<Site> findAll() {
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

            //Le resultat de la requête
            ResultSet result = stat.executeQuery(query);
            
			if (result.next() ) {
				do {
                	ret.add(new Site()); //ajout du Site à l'ArrayList. Appel du constructeur vide
                    ret.get(ret.size()-1).init(result.getInt(1), result.getInt(2), result.getString(3)); //initialisaton de les paramètres du retour de la requête
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
     * @return the site
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

			if (result.next() ) {
				do {
	                ret.init(id_site, result.getInt(2), result.getString(3));
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
     * @param tuple Objet de type Site a inserer
     */
    public void insert(Site tuple) {
        Statement stat = null;
        String query = "";

        //Recuperation des attributs de l'objet Site
        int id = tuple.getId();
        int school_id = tuple.getSchool_id();
        String name = tuple.getName();

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "INSERT INTO SITE VALUES("+ id +","+ school_id +","+ name +");";

            //Execute la requÃªte
            stat.executeQuery(query);
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
    public void delete(int id_site) {
        Statement stat = null;
        String query = "";

        try {
            //Recuperation de la connexion
            Connection con = SQLiteConnection.getInstance().getConnection();

            //Preparation de la requete
            query = "DELETE FROM SITE WHERE id = " + id_site + ";";

            //Execute la requÃªte
            stat.executeQuery(query);
        }
        catch(SQLException e) {
            System.out.println("ERREUR: " + e.getMessage());
        }
    }
}
