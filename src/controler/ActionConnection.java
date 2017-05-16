package controler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import model.Context;
import view.Screen;


public class ActionConnection extends AbstractAction {
	Context model;
	Screen view;
	ConnectionControler controler;
	
	ActionConnection(Context context, Screen view, ConnectionControler controler){
		this.model = context;
		this.view = view;
		this.controler = controler;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.model.connexion(this.view.getLogin(), this.view.getPassword())){
			this.model.setAuthentificated(true);
		}else{
			this.model.setAuthentificated(false);
		}
	}

}
