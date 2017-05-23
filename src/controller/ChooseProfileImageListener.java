/*
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;

// TODO: Auto-generated Javadoc
/**
 * The Class ChooseProfileImageListener.
 *
 * @see ChooseProfileImageListener
 */
public class ChooseProfileImageListener implements MouseListener {	


	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clic sur la photo de profil");
		//		((EventItemPanel)e.getSource()).getFrame().getHomePanel().setContainerCentral(((EventItemPanel)e.getSource()).getFrame().getDisplayEventPanel());
		//		((EventItemPanel)e.getSource()).getFrame().getDisplayEventPanel().displayEvent(((EventItemPanel)e.getComponent()).getEvent());
		//		SwingUtilities.updateComponentTreeUI(((EventItemPanel)e.getSource()).getFrame());

		//la fenêtre de dialogue
		JFileChooser dialogue = new JFileChooser(".");
		File fichier=null;
		String path = null;

		//fait apparaître la fenêtre (modale) de dialogue permettant de sélectionner un fichier. 
		//A la fermeture, renvoie APPROVE_OPTION ou bien CANCEL_OPTION.
		if (dialogue.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			//le fichier File = le fichier sélectionné
			fichier = dialogue.getSelectedFile();
			//le chemin du fichier
			path = fichier.getAbsolutePath();
		}
		if(path!=null){
			System.out.println("Image chargée: "+path);
			String leNom;
			int inf = path.lastIndexOf("\\");
			int sup = path.lastIndexOf(".");
			if (inf > -1 && sup > -1) {
				leNom = path.substring(inf+1,sup);
			}
			else{
				leNom=path;
			}
			System.out.println(leNom);
		}
		System.out.println(System.getProperty("user.dir"));
		//		System.out.println(System.getProperty(fichier.getName()));
		//		File dest =new File(System.getProperty("user.dir"), fichier.getName());


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
