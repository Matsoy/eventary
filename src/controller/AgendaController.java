package controller;

import java.util.Observable;
import java.util.Observer;

import model.Context;
import view.AgendaPanel;

public class AgendaController implements Observer{
	
	/** The model. */
	Context context;
	
	/** The view. */
	AgendaPanel agendaPanel;
	
	AgendaController(AgendaPanel agendaPanel, Context context){
		this.context = context;
		this.agendaPanel = agendaPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
