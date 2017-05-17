package controler;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import model.Context;
import model.Event;
import view.EventPanel;

public class ActionUnsubscribeEvent extends AbstractAction{

	Event event;
	
	Context context;
	
	EventPanel view;
	
	ActionUnsubscribeEvent(EventPanel view, Context context){
		this.event = context.getCurrentEvent();
		this.view = view;
		this.putValue(Action.NAME, "Se désinscrire");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.event = context.getCurrentEvent();
		if(event.removeParticipant(context.getCurrentUser())){ //true pour removed
			view.displayMessage("Vous êtes maintenant inscrit à l'événément", Color.GREEN);
		}else{ //false pour not removed
			view.displayMessage("Vous êtes maintenant sur la liste d'attente de l'événément", Color.YELLOW);
		}
	}

}
