package database;

import java.sql.DriverManager;

import org.sqlite.SQLiteConfig;

/**
 * The Class SQLiteConnection.
 *
 * @author Mathieu Soyer
 * config
 * File: SQLiteConnection.java
 * 
 * Cette classe (type singleton) établit la connexion entre une application Java et une BDD SQLite.
 */
class SQLiteConnection {
	private String dsn;
	private java.sql.Connection connect;
	private static SQLiteConnection theInst = null;

	/**
	 * constructeur privé
	 */
	private SQLiteConnection(){
		String path = System.getProperty("user.dir");
		path+="/database/eventary.db";
		this.dsn = "jdbc:sqlite:"+path;
		System.out.println("BDD: "+ this.dsn);
		// encoding UTF8
		SQLiteConfig config = new SQLiteConfig();
		config.setEncoding(SQLiteConfig.Encoding.UTF8);
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			this.connect = DriverManager.getConnection(this.dsn, config.toProperties());
			System.out.println( "Connexion reussie" );
		}
		catch ( Exception e ) {
			System.err.println( "Erreur de connexion : " + e.getMessage() );
		}
	}

	/**
	 * Renvoie l'instance static de type SQLiteConnection. Appel du constructeur privé si elle n'a pas encore été initialisée
	 * 
	 * @return l'instance static de type SQLiteConnection
	 */
	public static SQLiteConnection getInstance(){
		if(SQLiteConnection.theInst == null){
			SQLiteConnection.theInst = new SQLiteConnection();
		}

		return SQLiteConnection.theInst;
	}

	/**
	 * Renvoie l'objet qui a établi la connexion avec la BDD.
	 * 
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
	 * Lanceur qui teste la classe SQLiteConnection
	 */
	public static void main(String[] args){
		SQLiteConnection theObj = SQLiteConnection.getInstance();
		theObj.closeConnection();
	}

}
