package db;

import java.sql.*;
import org.sqlite.*; //import SQLite JDBC

/**
* Cette classe (type singleton) établit la connexion entre une
* application Java et une BDD SQLite.
*/

class SqliteConnection {
	private String dsn;
	private java.sql.Connection connect;
	private static SqliteConnection theInst = null;

	private SqliteConnection(){
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

	public static SqliteConnection getInstance(){
		if(SqliteConnection.theInst == null){
			SqliteConnection.theInst = new SqliteConnection();
		}

		return SqliteConnection.theInst;
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
		SqliteConnection theObj = SqliteConnection.getInstance();
		theObj.closeConnection();
	}

}
