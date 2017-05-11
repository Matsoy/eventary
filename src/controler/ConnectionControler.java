package controler;

import java.util.Observable;
import model.*;
import view.*;

public class ConnectionControler implements java.util.Observer{
	Context model;
	Screen view;
	
	ConnectionControler(view.Screen view){
		this.model = new model.Context();
		this.view = view;
		this.model.addObserver(this); //On observe le model pour que lorsque authentification est true on load setPanelHome();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if(this.model.getAuthentification()){
			view.setPanelHome();
		}else{
			view.displayConnectionError();
		}
	}
	
}
