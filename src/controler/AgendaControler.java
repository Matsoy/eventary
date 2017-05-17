package controler;

import java.util.Observable;
import java.util.Observer;

import model.Context;
import view.ConnectionPanel;

public class AgendaControler implements Observer{
	
	/** The model. */
	Context model;
	
	/** The view. */
	ConnectionPanel view;

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
