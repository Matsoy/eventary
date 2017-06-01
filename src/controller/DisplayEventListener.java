/*
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import database.UserDAO;
import input_output.Reader;
import model.Context;
import view.EventItemPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionDisplayEvent.
 * Ce listener va permettre d'afficher le panel des détails
 * d'un événement, selon sur quel événement 
 * l'utilisateur connecté a cliqué.
 * On fait aussi une mise à jour des modérateurs,
 * car cela peut impacter l'affichage des détails
 * (bouton d'annulation/suppression).
 *
 * @see DisplayEventEvent
 */
public class DisplayEventListener implements MouseListener {	
	
	/** The model. */
	Context model;
	
	/**
	 * Instantiates a new display event listener.
	 *
	 * @param model the model
	 */
	public DisplayEventListener(Context model) {
		this.model = model;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		UserDAO.updateModerators(Reader.readLogs("moderatorLogins"));
		((EventItemPanel)e.getSource()).getFrame().getHomePanel().setContainerCentral(((EventItemPanel)e.getSource()).getFrame().getEventPanel());
		((EventItemPanel)e.getSource()).getFrame().getEventPanel().adaptEvent(((EventItemPanel)e.getComponent()).getEvent(), this.model);
		SwingUtilities.updateComponentTreeUI(((EventItemPanel)e.getSource()).getFrame());
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
