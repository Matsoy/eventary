/*
 * 
 */
package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import view.EventItemPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionDisplayEvent.
 *
 * @see DisplayEventEvent
 */
public class DisplayEventListener implements MouseListener {	

	
	/* (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		((EventItemPanel)e.getSource()).getFrame().getHomePanel().setContainerCentral(((EventItemPanel)e.getSource()).getFrame().getDisplayEventPanel());
		((EventItemPanel)e.getSource()).getFrame().getDisplayEventPanel().displayEvent(((EventItemPanel)e.getComponent()).getEvent());
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
