/*
 * 
 */
package controller;

import java.io.File;
import java.util.Observable;

import javax.swing.SwingUtilities;

import database.EventDAO;
import database.SiteDAO;
import model.Context;
import view.ConnectionPanel;
import view.Frame;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionControler.
 */
public class ConnectionController implements java.util.Observer{

	/** The model. */
	Context model;

	/** The view. */
	ConnectionPanel view;

	/** The action connection. */
	ActionConnection actionConnection;


	/**
	 * Instantiates a new connection controler.
	 *
	 * @param connectionPanel the connection panel
	 * @param model the model
	 */
	ConnectionController(ConnectionPanel connectionPanel, Context model){
		this.model = model;
		this.view = connectionPanel;
		this.model.addObserver(this);
		this.actionConnection = new ActionConnection(this.model, this.view);
		this.view.getBouton().setAction(this.actionConnection);
	}


	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		// si l'utilisateur est authentifié, on passe à la page d'accueil
		if(this.model.getAuthentificated()){
			view.getFrame().setHomePanel(EventDAO.findAll());
			this.view.getFrame().getHomePanel().setContainerCentral(this.view.getFrame().getAllEventsPanel());
			this.view.getFrame().getAllEventsPanel().displayAllEvents(EventDAO.findAll(), SiteDAO.findAll());

			// selection de l'image de profil de l'utilisateur
			File directoryPath = new File(System.getProperty("user.dir")+"/img");
			File [] filesList = directoryPath.listFiles();
			String profilePath = null;
			// parcours des fichiers de Eventary/img/
			for (int i = 0; i < filesList.length; i++){
				if (filesList[i].isFile()){ //this line weeds out other directories/folders
					String tmp = "";
					int pos = filesList[i].getName().lastIndexOf(".");
					if (pos > -1) {
						tmp = filesList[i].getName().substring(0, pos);

						if (tmp.equals(this.model.getCurrentUser().getLogin())) {
							profilePath = filesList[i].getName();
							break;
						}
					}
				}
			}
			// si pas d'img, alors img par defaut
			if(profilePath == null){
				profilePath = "default_profile.png";
			}

			this.view.getFrame().getHomePanel().displayProfile(this.model.getCurrentUser(), "img/"+profilePath);
			SwingUtilities.updateComponentTreeUI(this.view.getFrame());
		}

		// si il y a un mauvais login/mdp, on affaiche un message d'erreur
		else{
			view.getFrame().displayMessage("Echec de connexion: le login et le password ne correspondent pas",Frame.colorEventaryError);
		}
	}

}
