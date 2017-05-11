package controler;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class ActionConnection extends AbstractAction {
	model.Context model;
	view.Screen view;
	ConnectionControler controler;
	
	ActionConnection(model.Context context, view.Screen view, ConnectionControler controler){
		this.model = context;
		this.view = view;
		this.controler = controler;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(this.model.connexion(this.view.getLogin(), this.view.getPassword())){
			this.model.setAuthentification(true);
		}else{
			this.model.setAuthentification(false);
		}
	}

}
