package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.SwingUtilities;

import database.UserDAO;
import model.User;
import view.OrgaItemPanel;


public class DisplayOrgaListener implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		((OrgaItemPanel)e.getSource()).getFrame().getHomePanel().setContainerCentral(((OrgaItemPanel)e.getSource()).getFrame().getOrgaPanel());              
		((OrgaItemPanel)e.getSource()).getFrame().getOrgaPanel().adaptOrga(((OrgaItemPanel)e.getComponent()).getOrganisation(), (List<User>)UserDAO.findAll());
		SwingUtilities.updateComponentTreeUI(((OrgaItemPanel)e.getSource()).getFrame());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
