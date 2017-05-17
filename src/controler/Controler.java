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
	
	EventControler eventControler;
	
	AgendaControler agendaControler;
	
	/** The frame. */
	Frame frame;
	
	/** The context. */
	Context context;	

	/**
	 * Instantiates a new controler.
	 */
	public Controler(){
		this.frame = new Frame();
		this.context = new Context();
		
		// page de connexion
		this.connectionControler = new ConnectionControler(this.frame.getConnectionPanel(), this.context);
		
		//page d'accueil
		this.homeControler = new HomeControler(this.frame.getHomePanel(), this.context);
		
		//page d'un event
		this.eventControler = new EventControler(this.frame.getEventPanel(), this.context);
		
		//page agenda
		this.agendaControler = new AgendaControler(this.frame.getAgendaPanel(), this.context);
		
	}

}
