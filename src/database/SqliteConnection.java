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
 * Cette classe (type singleton) �tablit la connexion entre une application Java et une BDD SQLite.
 */
class SQLiteConnection {
	private String dsn;
	private java.sql.Connection connect;
	private static SQLiteConnection theInst = null;

	/**
	 * constructeur priv�
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
		}
		catch ( Exception e ) {
			System.err.println( "Erreur de connexion : " + e.getMessage() );
		}
	}

	/**
	 * Renvoie l'instance static de type SQLiteConnection. Appel du constructeur priv� si elle n'a pas encore �t� initialis�e
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
	 * Renvoie l'objet qui a �tabli la connexion avec la BDD.
	 * 
	 * @return l'objet qui a �tabli la connexion.
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
