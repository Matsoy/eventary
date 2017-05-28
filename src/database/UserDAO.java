/*
 * 
 */
package database;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDAO.
 *
 * @author Mathieu Soyer
 * 
 * File: UserDAO.java
 * 
 * Classe pour les objets Dao de User
 */

public class UserDAO{

	/**
	 * Instantiates a new user DAO.
	 */
	public UserDAO() {

	}

	/**
	 * Pour retrouver tous les tuples.
	 *
	 * @return the result set
	 */
	public static ArrayList<User> findAll() {
		Statement stat = null;
		String query = "";
		ArrayList<User> ret = new ArrayList<User>();
		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM USER;";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.add(new User()); //ajout du User � l'ArrayList. Appel du constructeur vide
					ret.get(ret.size()-1).init(result.getString(1), result.getBoolean(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7), OrganizationDAO.assoInWhichUserIsMember(result.getString(1)), OrganizationDAO.dptInWhichUserIsMember(result.getString(1))); //initialisaton de les param�tres du retour de la requ�te
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
	 * @param login_user login de l'User a retrouver
	 * @return the user
	 */
	public static User find(String login_user) {
		Statement stat = null;
		String query = "";
		User ret = new User();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM USER WHERE UPPER(login) = UPPER('" + login_user + "');";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					ret.init(login_user, result.getBoolean(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7), null, null);
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
	 * V�rifie si l'utilisateur ayant le login/mdp existe.
	 *
	 * @param login_user login de l'User a retrouver
	 * @param passwd_user passwd de l'User a retrouver
	 * @return l'utilisateur connect�, null sinon
	 */
	public static User connect(String login_user, String passwd_user) {
		Statement stat = null;
		String query = "";
		User ret = new User();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "SELECT * FROM USER WHERE UPPER(login) = UPPER('" + login_user + "') AND passwd = '" + passwd_user + "';";

			//Retourne l'execution de la requete sous la forme d'un objet ResultSet
			ResultSet result = stat.executeQuery(query);

			//Si le resultat est bon, prends la premiere ligne
			if (result.next() ) {
				do {
					ret.init(login_user, result.getBoolean(3), result.getString(4), result.getString(5), result.getString(6), result.getInt(7), OrganizationDAO.assoInWhichUserIsMember(login_user), OrganizationDAO.dptInWhichUserIsMember(login_user));
				} 
				while (result.next());
			}
			else{
				ret = null;
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
	 * @param tuple Objet de type User a inserer
	 * @param passwd le mdp de l'utilisateur
	 */
	public static void insert(User tuple, String passwd) {
		Statement stat = null;
		String query = "";

		//Recuperation des attributs de l'objet User
		String login = tuple.getLogin();
		boolean moderator = tuple.getModerator();
		String fName = tuple.getfName();
		String lName = tuple.getlName();
		String branch = tuple.getBranch();
		int year = tuple.getYear();

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//Preparation de la requete
			query = "INSERT INTO USER VALUES('"+ login +"','"+ passwd +"',"+ moderator +",'"+ fName +"','"+ lName +"','"+ branch +"',"+ year +");";

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
	 * @param login_user login du tuple a supprimer
	 */
	public static void delete(String login_user) {
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//suppression de toutes les participations du User à des Event
			ParticipationDAO.delete(login_user, -1);

			//Preparation de la requete
			query = "DELETE FROM USER WHERE UPPER(login) = UPPER('" + login_user + "');";

			//Execute la requête
			stat.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}
	}



	/**
	 * Update moderators.
	 *
	 * @param modoLogins the modo logins
	 * @return true, if successful
	 */
	public static boolean updateModerators(ArrayList<String> modoLogins) {
		boolean ret = false;
		Statement stat = null;
		String query = "";

		try {
			//Recuperation de la connexion
			Connection con = SQLiteConnection.getInstance().getConnection();

			//Preparation de la requete en ligne
			stat = con.createStatement();

			//recup des modo
			//Preparation de la requete
			query = "SELECT login FROM USER WHERE moderator = 1";

			//Le resultat de la requ�te
			ResultSet result = stat.executeQuery(query);

			if (result.next() ) {
				do {
					// si le user n'est pas dans la list donnée. Si le user parcouru ne doit plus etre modo
					if (!modoLogins.contains(result.getString(1))) {
						query = "UPDATE USER SET moderator = 0 WHERE UPPER(login) = UPPER('"+ result.getString(1) +"');";
						stat.executeUpdate(query);
					}
					// si le user est dans la liste, donc pas de changement a faire. On le supp de la liste
					else {
						modoLogins.remove(result.getString(1));
					}
				} 
				while (result.next());
			}

			//il ne reste plus que les nouveaux modo
			for (String login : modoLogins) {
				query = "UPDATE USER SET moderator = 1 WHERE UPPER(login) = UPPER('"+ login +"');";
				stat.executeUpdate(query);
			}
			ret = true;
		}
		catch(SQLException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return ret;
	}


	/**
	 * Generate hash.
	 *
	 * @param passwd the passwd
	 * @return the string
	 */
	public static String generateHash(String passwd) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(passwd.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			System.out.println("ERREUR: " + e.getMessage());
		}

		return hash.toString();
	}
}
