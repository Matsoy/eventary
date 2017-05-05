package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.User;
import view.Screen;

public class ConnectionController implements ActionListener{	
	private Screen screen;
	
	ConnectionController(Screen screen){
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.println("Connexion");
		//this.screen.getConnected();
	}

	public boolean ActionConnection(){
//		if(UserConnection()){
//			
//		}
		return false;
	}
}
