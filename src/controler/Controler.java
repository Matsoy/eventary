package controler;

import model.Context;
import view.Frame;

/**
 * The Class Controler.
 */
public class Controler {
	
	/** The connection controler. */
	ConnectionControler connectionControler;
	
	/** The home controler. */
	HomeControler homeControler;
	
	/** The frame. */
	Frame frame;
	
	/** The context. */
	Context context;
	
	/** The action connection. */
	ActionConnection actionConnection;

	/** The action connection. */
	ActionDisplayMyEvents actionDisplayMyEvents;

	/**
	 * Instantiates a new controler.
	 */
	public Controler(){
		this.frame = new Frame();
		this.context = new Context();
		
		// page de connexion
		this.connectionControler = new ConnectionControler(this.frame.getConnectionPanel(), this.context);
		this.actionConnection = new ActionConnection(this.context, this.frame.getConnectionPanel());
		this.frame.getConnectionPanel().getBouton().setAction(this.actionConnection);
		
		//page d'accueil
		this.homeControler = new HomeControler(this.frame.getHomePanel(), this.context);
		this.actionDisplayMyEvents = new ActionDisplayMyEvents(this.context, this.frame.getHomePanel());
		this.frame.getHomePanel().getMyEvents().setAction(this.actionDisplayMyEvents);
		
	}

}
