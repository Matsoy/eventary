package view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DisplayOrgaListener;

// TODO: Auto-generated Javadoc
/**
 * The Class MyOrganisationsPanel.
 */
public class MyOrganisationsPanel extends JPanel{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The frame. */
	Frame frame;
	
	/**
	 * Instantiates a new my organisations panel.
	 *
	 * @param frame the frame
	 */
	public MyOrganisationsPanel(Frame frame) {
		this.frame = frame;
	}
	
	/**
	 * Display my organisations.
	 *
	 * @param listeAsso the liste asso
	 * @param listeDpt the liste dpt
	 */
	public void displayMyOrganisations(List<model.Association> listeAsso, List<model.Department> listeDpt) {
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
			JPanel panelAsso = new OrgaItemPanel(this.frame,asso);
			panelAsso.addMouseListener(new DisplayOrgaListener());
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
			JPanel panelDpt = new OrgaItemPanel(this.frame,dept);
			panelDpt.addMouseListener(new DisplayOrgaListener());
			this.add(panelDpt);
			this.add(Box.createRigidArea(new Dimension(0,10)));
		}
	}
}
