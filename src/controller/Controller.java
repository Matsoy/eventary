/*
 * 
 */
package controller;

import model.Context;
import view.Frame;

// TODO: Auto-generated Javadoc
/**
 * The Class Controler.
 * Cette classe est notre controller général.
 * C'est lui qui va se charger de créer le context,
 * la fenêtre, et les deux mini controller.
 * Ce controller est créé dans le lanceur.
 */
public class Controller {
	
	/** The connection controler. */
	ConnectionController connectionControler;
	
	/** The home controler. */
	HomeController homeControler;
	
	/** The frame. */
	Frame frame;
	
	/** The context. */
	Context context;	

	
	/**
	 * Instantiates a new controler.
	 */
	public Controller(){
		this.frame = new Frame();
		this.context = new Context();
		
		// page de connexion
		this.connectionControler = new ConnectionController(this.frame.getConnectionPanel(), this.context);
		
		// page d'accueil
		this.homeControler = new HomeController(this.frame.getHomePanel(), this.context);
	}
}
