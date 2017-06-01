package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.SwingUtilities;

import database.UserDAO;
import model.User;
import view.OrgaItemPanel;


// TODO: Auto-generated Javadoc
/**
 * The Class ActionDisplayOrga.
 * Ce listener va être identique à la classe
 * DisplayEventListener, mais pour les organisations.
 * Grâce à ce listener, l'utilisateur va donc permettre
 * d'afficher le panel détaillé de l'organisation
 * sur lequel l'utilisateur connecté aura cliqué.
 */
public class DisplayOrgaListener implements MouseListener {

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		((OrgaItemPanel)e.getSource()).getFrame().getHomePanel().setContainerCentral(((OrgaItemPanel)e.getSource()).getFrame().getOrgaPanel());              
		((OrgaItemPanel)e.getSource()).getFrame().getOrgaPanel().adaptOrga(((OrgaItemPanel)e.getComponent()).getOrganisation(), (List<User>)UserDAO.findAll());
		SwingUtilities.updateComponentTreeUI(((OrgaItemPanel)e.getSource()).getFrame());
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
