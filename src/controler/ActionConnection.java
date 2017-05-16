package controler;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import model.Context;
import view.ConnectionPanel;


public class ActionConnection extends AbstractAction {
	Context model;
	ConnectionPanel view;
	ConnectionControler controler;
	
	ActionConnection(Context context, ConnectionPanel view, ConnectionControler controler){
		this.model = context;
		this.view = view;
		this.controler = controler;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.model.connexion(this.view.getLogin(), this.view.getPassword());
	}

}
