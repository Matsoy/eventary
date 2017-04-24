package database;

import java.sql.*;
import org.sqlite.*; //import SQLite JDBC
import model.*;

/**
* Cette classe (type singleton) établit la connexion entre une
* application Java et une BDD SQLite.
*/

class SQLiteConnection {
	private String dsn;
	private java.sql.Connection connect;
	private static SQLiteConnection theInst = null;

	private SQLiteConnection(){
		String path = System.getProperty("user.dir");
		path+="/eventary.db";
		this.dsn = "jdbc:sqlite:"+path;
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			this.connect = DriverManager.getConnection(this.dsn);
			System.out.println( "Connexion reussie" );
		}
		catch ( Exception e ) {
			System.err.println( "Erreur de connexion : " + e.getMessage() );
		}
	}

	public static SQLiteConnection getInstance(){
		if(SQLiteConnection.theInst == null){
			SQLiteConnection.theInst = new SQLiteConnection();
		}

		return SQLiteConnection.theInst;
	}

	/**
	* Renvoie l'objet qui a établi la connexion avec la BDD.
	* @return l'objet qui a établi la connexion.
	*/
	public java.sql.Connection getConnection(){

		return this.connect;
	}

	/**
	* Ferme la connexion avec la BDD.
	*/
	public void closeConnection(){
		try {
			this.connect.close();
			this.connect = null;
		} catch ( Exception e ) {
			System.out.println ( "Probleme de fermeture" + e.getMessage() );
		}
	}


	/**
	* Lanceur qui teste la classe MySQLConnection
	*/
	public static void main(String[] args){
		SQLiteConnection theObj = SQLiteConnection.getInstance();
		theObj.closeConnection();
	}

}
