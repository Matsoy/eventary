/*
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import model.User;
import view.Frame;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseProfileImageListener.
 *
 * @see ChooseProfileImageListener
 */
public class ChooseProfileImageListener implements MouseListener {	

	/** The user. */
	private User user;
	
	/** The view. */
	private HomePanel view;

	/**
	 * Instantiates a new choose profile image listener.
	 *
	 * @param view the view
	 * @param user the user
	 */
	public ChooseProfileImageListener(HomePanel view, User user){
		super();
		this.user = user;
		this.view = view;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// liste des extensions autorisées
		List<String> ImageExtensions = new ArrayList<String>();
		ImageExtensions.add("PNG");
		ImageExtensions.add("JPG");
		ImageExtensions.add("JPEG");
		ImageExtensions.add("GIF");
		
		//la fenêtre de dialogue
		JFileChooser dialogue = new JFileChooser(".");
		File fichier = null;
		String path = null;
		String lextension = null;

		//fait apparaître la fenêtre (modale) de dialogue permettant de sélectionner un fichier. 
		//A la fermeture, renvoie APPROVE_OPTION ou bien CANCEL_OPTION.
		if (dialogue.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			//le fichier File = le fichier sélectionné
			fichier = dialogue.getSelectedFile();
			//le chemin du fichier
			path = fichier.getAbsolutePath();
		}
		if(path!=null){
			int pos = path.lastIndexOf(".");
			if (pos > -1) {
				lextension = path.substring(pos+1);
			}
			else{
				lextension=path;
			}
			lextension = lextension.toUpperCase();

			// si le fichier est bien une image (i.e. l'extension est dans la liste des extesions autorisées)
			if(ImageExtensions.contains(lextension)){
				try {
					// suppression de la précédente image de l'utilisateur (s'il en avait une)
					File directoryPath = new File(System.getProperty("user.dir")+"/img");
					File [] filesList = directoryPath.listFiles();
					// parcours des fichiers de Eventary/img/
					for (int i = 0; i < filesList.length; i++){
						if (filesList[i].isFile()){ //this line weeds out other directories/folders
							String tmp = "";
							int pos2 = filesList[i].getName().lastIndexOf(".");
							if (pos2 > -1) {
								tmp = filesList[i].getName().substring(0, pos2);

								if (tmp.equals(user.getLogin())) { // si on trouve l'ancienne photo de l'utilisateur
									filesList[i].delete(); //suppression de l'image
									break;
								}
							}
						}
					}
										
					// copie de l'image sélectionnée dans img/
					Files.copy(fichier.toPath(), (new File(System.getProperty("user.dir")+"/img/"+user.getLogin()+"."+lextension)).toPath(), StandardCopyOption.REPLACE_EXISTING);
					view.displayProfile(user, "img/"+user.getLogin()+"."+lextension);
					SwingUtilities.updateComponentTreeUI(view.getFrame());

				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			
			// si le fichier sélectionné n'est pas une image
			else {
				view.getFrame().displayMessage("Le fichier sélectionné n'est pas de type gif, png, jpeg ou jpeg",Frame.colorEventaryError);
			}


		}

	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
