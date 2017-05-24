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

import javax.activation.MimetypesFileTypeMap;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import model.User;
import view.EventItemPanel;
import view.Frame;
import view.HomePanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseProfileImageListener.
 *
 * @see ChooseProfileImageListener
 */
public class ChooseProfileImageListener implements MouseListener {	

	private User user;
	private HomePanel view;

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
				lextension = path.substring(pos);
			}
			else{
				lextension=path;
			}

			// on check le type du fichier
			String mimetype= new MimetypesFileTypeMap().getContentType(fichier);
			String type = mimetype.split("/")[0];
			
			// si le fichier est bien une image
			if(type.equals("image")){
				try {
					Files.copy(fichier.toPath(), (new File(System.getProperty("user.dir")+"/img/"+user.getLogin()+lextension)).toPath(), StandardCopyOption.REPLACE_EXISTING);
					((EventItemPanel)e.getSource()).getFrame().getHomePanel().displayProfile(user, "/img/"+user.getLogin()+lextension);
					SwingUtilities.updateComponentTreeUI(((EventItemPanel)e.getSource()).getFrame());

				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
			
			// si le fichier sélectionné n'est pas une image
			else {
				view.getFrame().displayMessage("Le fichier sélectionné n'est pas une image",Frame.colorEventaryError);
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
