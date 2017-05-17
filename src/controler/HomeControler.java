package controler;

import java.util.Observable;

import model.Context;
import view.HomePanel;

/**
 * The Class HomeControler.
 */
public class HomeControler implements java.util.Observer{

	/** The model. */
	Context model;

	/** The view. */
	HomePanel view;

	/**
	 * Instantiates a new home controler.
	 *
	 * @param homePanel the home panel
	 * @param model the model
	 */
	HomeControler(HomePanel homePanel, Context model){
		this.model = model;
		this.view = homePanel;
		this.model.addObserver(this);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

	}

}
