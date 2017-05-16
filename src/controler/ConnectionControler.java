package controler;

import java.util.Observable;

import model.Context;
import view.ConnectionPanel;
import view.Frame;

/**
 * The Class ConnectionControler.
 */
public class ConnectionControler implements java.util.Observer{
	
	/** The model. */
	Context model;
	
	/** The view. */
	ConnectionPanel view;

	/**
	 * Instantiates a new connection controler.
	 *
	 * @param connectionPanel the connection panel
	 * @param model the model
	 */
	ConnectionControler(ConnectionPanel connectionPanel, Context model){
		this.model = model;
		this.view = connectionPanel;
		this.model.addObserver(this);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("dans update de ConnectionControler");
		if(this.model.getAuthentificated()){
			view.setHomePanel();
			System.out.println("Connecté");
		}else{
			view.displayError();
			System.out.println("Pas connecté");
		}
	}

}
