package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OrganisationsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** The frame. */
	Frame frame;
	
	public OrganisationsPanel(Frame frame) {
		this.frame = frame;
	}
	
	public void displayOrganisations(List<model.Association> listeAsso, List<model.Department> listeDpt) {
		this.removeAll();
		this.setBackground(Color.WHITE);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createRigidArea(new Dimension(0,5)));
		
		JPanel assoPanel = new JPanel();
		assoPanel.setBackground(Frame.colorEventary);
		assoPanel.setMaximumSize(new Dimension(800,30));
		assoPanel.add(new JLabel("Mes Associations"));
		this.add(assoPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		
		for(model.Association asso : listeAsso) {
			JPanel panelAsso = new JPanel();
			panelAsso.setMinimumSize(new Dimension(800,50));
			panelAsso.setMaximumSize(new Dimension(800,50));
			panelAsso.add(new JLabel(asso.getName()));
			this.add(panelAsso);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
		
		this.add(Box.createRigidArea(new Dimension(0,30)));
		JPanel dptPanel = new JPanel();
		dptPanel.setBackground(Frame.colorEventary);
		dptPanel.setMaximumSize(new Dimension(800,30));
		dptPanel.add(new JLabel("Mes Départements"));
		this.add(dptPanel);
		this.add(Box.createRigidArea(new Dimension(0,10)));

		for(model.Department dept : listeDpt) {
			JPanel panelDpt = new JPanel();
			panelDpt.setMaximumSize(new Dimension(800,50));
			panelDpt.add(new JLabel(dept.getName()));
			this.add(panelDpt);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
	}
}
