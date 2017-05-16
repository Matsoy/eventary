package controler;

import model.Context;
import view.Frame;

/**
 * The Class Controler.
 */
public class Controler {
	
	/** The connection controler. */
	ConnectionControler connectionControler;
	
	/** The frame. */
	Frame frame;
	
	/** The context. */
	Context context;
	
	/** The action connection. */
	ActionConnection actionConnection;

	/**
	 * Instantiates a new controler.
	 */
	public Controler(){
		this.frame = new Frame();
		this.context = new Context();
		this.connectionControler = new ConnectionControler(this.frame.getConnectionPanel(), this.context);
		this.actionConnection = new ActionConnection(this.context, this.frame.getConnectionPanel());
		this.frame.getConnectionPanel().getBouton().setAction(this.actionConnection);
	}

}
